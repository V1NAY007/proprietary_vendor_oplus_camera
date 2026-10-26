/*
 * Copyright (C) 2024-2026 The LineageOS Project
 *
 * SPDX-License-Identifier: Apache-2.0
 */

#define LOG_TAG "libgui_shim_opluscamera"

#include <dlfcn.h>
#include <stdio.h>
#include <string.h>
#include <android/log.h>

void _ZN7android18BnProducerListener16onBufferDetachedEi(int slot) {
    (void)slot;
}

// Fallback stubs for APSClient callbacks to prevent SIGSEGV at pc 0x0
void setOnTransactCallback(void* cb) {
    __android_log_print(ANDROID_LOG_INFO, LOG_TAG, "setOnTransactCallback called with %p", cb);
}

void setRequestActionCallback(void* cb) {
    __android_log_print(ANDROID_LOG_INFO, LOG_TAG, "setRequestActionCallback called with %p", cb);
}

int onTransact(int code, void* data, void* reply, int flags) {
    __android_log_print(ANDROID_LOG_INFO, LOG_TAG, "onTransact called: code=%d", code);
    (void)data;
    (void)reply;
    (void)flags;
    return 0;
}

typedef void* (*load_sphal_fn)(const char*, int);
typedef int (*unload_sphal_fn)(void*);

static void* s_vndk_handle = NULL;
static load_sphal_fn s_real_load_sphal = NULL;
static unload_sphal_fn s_real_unload_sphal = NULL;

static load_sphal_fn get_real_load_sphal(void) {
    if (s_real_load_sphal) return s_real_load_sphal;
    if (!s_vndk_handle) {
        s_vndk_handle = dlopen("libvndksupport.so", RTLD_NOW);
    }
    if (s_vndk_handle) {
        s_real_load_sphal = (load_sphal_fn)dlsym(s_vndk_handle, "android_load_sphal_library");
    }
    if (!s_real_load_sphal) {
        s_real_load_sphal = (load_sphal_fn)dlsym(RTLD_NEXT, "android_load_sphal_library");
    }
    return s_real_load_sphal;
}

void* android_load_sphal_library(const char* name, int flag) {
    __android_log_print(ANDROID_LOG_INFO, LOG_TAG, "android_load_sphal_library intercept: %s", name ? name : "null");
    if (!name) return NULL;

    void* handle = NULL;
    const char* base = strrchr(name, '/');
    base = base ? base + 1 : name;

    // 1. Try real android_load_sphal_library via sphal namespace
    load_sphal_fn real_fn = get_real_load_sphal();
    if (real_fn) {
        handle = real_fn(base, flag);
        if (handle) {
            __android_log_print(ANDROID_LOG_INFO, LOG_TAG, "Loaded %s via real android_load_sphal_library: %p", base, handle);
            return handle;
        }
        if (base != name) {
            handle = real_fn(name, flag);
            if (handle) {
                __android_log_print(ANDROID_LOG_INFO, LOG_TAG, "Loaded %s via real android_load_sphal_library (full path): %p", name, handle);
                return handle;
            }
        }
    }

    // 2. Try standard dlopen by basename (for system / system_ext libs)
    handle = dlopen(base, flag);
    if (handle) {
        __android_log_print(ANDROID_LOG_INFO, LOG_TAG, "Loaded %s via dlopen(base): %p", base, handle);
        return handle;
    }

    // 3. If system/system_ext absolute path, direct dlopen is allowed by linker namespace
    if (name[0] == '/' && (strncmp(name, "/system/", 8) == 0 || strncmp(name, "/system_ext/", 12) == 0)) {
        handle = dlopen(name, flag);
        if (handle) {
            __android_log_print(ANDROID_LOG_INFO, LOG_TAG, "Loaded %s directly: %p", name, handle);
            return handle;
        }
    }

    // 4. Fallback for libAlgoProcess.so to prevent NULL function pointer crash in APSClient
    if (strstr(name, "libAlgoProcess.so")) {
        // shortcut: provide self as fallback provider when libAlgoProcess cannot be loaded
        __android_log_print(ANDROID_LOG_WARN, LOG_TAG, "libAlgoProcess.so failed to load, falling back to shim stubs");
        handle = dlopen("libgui_shim_opluscamera.so", RTLD_NOW);
        if (handle) {
            return handle;
        }
    }

    return NULL;
}

int android_unload_sphal_library(void* handle) {
    if (!handle) return 0;
    if (!s_real_unload_sphal) {
        if (!s_vndk_handle) {
            s_vndk_handle = dlopen("libvndksupport.so", RTLD_NOW);
        }
        if (s_vndk_handle) {
            s_real_unload_sphal = (unload_sphal_fn)dlsym(s_vndk_handle, "android_unload_sphal_library");
        }
    }
    if (s_real_unload_sphal) {
        return s_real_unload_sphal(handle);
    }
    return dlclose(handle);
}
