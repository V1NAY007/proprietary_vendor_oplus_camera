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

void* android_load_sphal_library(const char* name, int flag) {
    __android_log_print(ANDROID_LOG_INFO, LOG_TAG, "android_load_sphal_library intercept: %s", name ? name : "null");
    if (!name) return NULL;

    void* handle = NULL;

    // 1. If absolute path, try direct dlopen first
    if (name[0] == '/') {
        handle = dlopen(name, flag);
        if (handle) {
            __android_log_print(ANDROID_LOG_INFO, LOG_TAG, "Loaded %s directly: %p", name, handle);
            return handle;
        } else {
            __android_log_print(ANDROID_LOG_WARN, LOG_TAG, "dlopen(%s) direct failed: %s", name, dlerror());
        }
    }

    // 2. Try real android_load_sphal_library from libvndksupport
    load_sphal_fn real_fn = (load_sphal_fn)dlsym(RTLD_NEXT, "android_load_sphal_library");
    if (real_fn) {
        handle = real_fn(name, flag);
        if (handle) {
            __android_log_print(ANDROID_LOG_INFO, LOG_TAG, "Loaded %s via real android_load_sphal_library: %p", name, handle);
            return handle;
        }
    }

    // 3. Try candidate search directories with basename
    const char* base = strrchr(name, '/');
    base = base ? base + 1 : name;

    const char* search_dirs[] = {
        "/odm/lib64/",
        "/vendor/lib64/",
        "/system_ext/lib64/",
        "/system/lib64/",
        NULL
    };
    for (int i = 0; search_dirs[i] != NULL; i++) {
        char fullpath[256];
        snprintf(fullpath, sizeof(fullpath), "%s%s", search_dirs[i], base);
        handle = dlopen(fullpath, flag);
        if (handle) {
            __android_log_print(ANDROID_LOG_INFO, LOG_TAG, "Loaded %s from %s: %p", name, fullpath, handle);
            return handle;
        } else {
            __android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, "dlopen(%s) failed: %s", fullpath, dlerror());
        }
    }

    // 4. Try standard dlopen by basename
    handle = dlopen(base, flag);
    if (handle) {
        __android_log_print(ANDROID_LOG_INFO, LOG_TAG, "Loaded %s via dlopen(base): %p", base, handle);
        return handle;
    }

    // 5. Fallback for libAlgoProcess.so to prevent NULL function pointer crash in APSClient
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
