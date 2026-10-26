/*
 * Copyright (C) 2026 The LineageOS Project
 *
 * SPDX-License-Identifier: Apache-2.0
 */

#include <jni.h>
#include <android/log.h>

#define LOG_TAG "ArcSpotlightBeautyShim"
#define ALOGD(...) __android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, __VA_ARGS__)
#define ALOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)

static jobject createVersionObject(JNIEnv *env) {
    jclass verClass = env->FindClass("com/arcsoft/livebroadcast/ArcSpotlightVersion");
    if (!verClass) {
        if (env->ExceptionCheck()) env->ExceptionClear();
        return nullptr;
    }
    jmethodID init = env->GetMethodID(verClass, "<init>", "()V");
    if (!init) {
        if (env->ExceptionCheck()) env->ExceptionClear();
        return nullptr;
    }
    jobject verObj = env->NewObject(verClass, init);
    if (!verObj) return nullptr;

    jfieldID fBuild = env->GetFieldID(verClass, "Build", "J");
    if (fBuild) env->SetLongField(verObj, fBuild, 1);

    jfieldID fCodebase = env->GetFieldID(verClass, "Codebase", "J");
    if (fCodebase) env->SetLongField(verObj, fCodebase, 1);

    jfieldID fMajor = env->GetFieldID(verClass, "Major", "J");
    if (fMajor) env->SetLongField(verObj, fMajor, 1);

    jfieldID fMinor = env->GetFieldID(verClass, "Minor", "J");
    if (fMinor) env->SetLongField(verObj, fMinor, 0);

    jfieldID fVersion = env->GetFieldID(verClass, "Version", "Ljava/lang/String;");
    if (fVersion) env->SetObjectField(verObj, fVersion, env->NewStringUTF("1.0.0"));

    jfieldID fBuildDate = env->GetFieldID(verClass, "BuildDate", "Ljava/lang/String;");
    if (fBuildDate) env->SetObjectField(verObj, fBuildDate, env->NewStringUTF("2024-01-01"));

    jfieldID fCopyRight = env->GetFieldID(verClass, "CopyRight", "Ljava/lang/String;");
    if (fCopyRight) env->SetObjectField(verObj, fCopyRight, env->NewStringUTF("ArcSoft"));

    return verObj;
}

extern "C" {

JNIEXPORT jint JNI_OnLoad(JavaVM *vm, void *reserved) {
    ALOGI("libarcsoft_beauty_ex loaded successfully");
    return JNI_VERSION_1_6;
}

// ArcSpotlightBase
JNIEXPORT jobject JNICALL
Java_com_arcsoft_livebroadcast_ArcSpotlightBase_nativeGetVersion(JNIEnv *env, jobject thiz, jlong handle) {
    return createVersionObject(env);
}

// ArcSpotlightBeautyGPU
JNIEXPORT jlong JNICALL
Java_com_arcsoft_livebroadcast_ArcSpotlightBeautyGPU_nativeCreateEngine(JNIEnv *env, jobject thiz) {
    ALOGD("ArcSpotlightBeautyGPU_nativeCreateEngine");
    return 1L;
}

JNIEXPORT void JNICALL
Java_com_arcsoft_livebroadcast_ArcSpotlightBeautyGPU_nativeDestroyEngine(JNIEnv *env, jobject thiz, jlong handle) {
    ALOGD("ArcSpotlightBeautyGPU_nativeDestroyEngine handle=%ld", (long)handle);
}

JNIEXPORT jobject JNICALL
Java_com_arcsoft_livebroadcast_ArcSpotlightBeautyGPU_nativeGetVersion(JNIEnv *env, jobject thiz, jlong handle) {
    return createVersionObject(env);
}

JNIEXPORT jint JNICALL
Java_com_arcsoft_livebroadcast_ArcSpotlightBeautyGPU_nativeInitial(JNIEnv *env, jobject thiz, jlong handle) {
    ALOGD("ArcSpotlightBeautyGPU_nativeInitial handle=%ld", (long)handle);
    return 0; // ASL_NO_ERROR
}

JNIEXPORT jint JNICALL
Java_com_arcsoft_livebroadcast_ArcSpotlightBeautyGPU_nativeRenderWithRGB10A2Texture(
        JNIEnv *env, jobject thiz, jlong handle, jint inTex, jint outTex,
        jint width, jboolean flag, jint height, jintArray arr, jlong param) {
    return 0;
}

JNIEXPORT jint JNICALL
Java_com_arcsoft_livebroadcast_ArcSpotlightBeautyGPU_nativeRenderWithTexture(
        JNIEnv *env, jobject thiz, jlong handle, jint inTex, jint outTex,
        jint width, jboolean flag, jint height, jintArray arr, jlong param) {
    return 0;
}

JNIEXPORT void JNICALL
Java_com_arcsoft_livebroadcast_ArcSpotlightBeautyGPU_nativeSetFeatureAdjustParamLevel(
        JNIEnv *env, jobject thiz, jint feature, jint level, jlong handle) {
}

JNIEXPORT void JNICALL
Java_com_arcsoft_livebroadcast_ArcSpotlightBeautyGPU_nativeSetFeatureLevel(
        JNIEnv *env, jobject thiz, jint feature, jint level, jlong handle) {
}

JNIEXPORT void JNICALL
Java_com_arcsoft_livebroadcast_ArcSpotlightBeautyGPU_nativeUninitial(JNIEnv *env, jobject thiz, jlong handle) {
    ALOGD("ArcSpotlightBeautyGPU_nativeUninitial handle=%ld", (long)handle);
}

// ArcSpotlightBeautyProccess
JNIEXPORT jlong JNICALL
Java_com_arcsoft_livebroadcast_ArcSpotlightBeautyProccess_nativeCreateEngine(JNIEnv *env, jobject thiz) {
    ALOGD("ArcSpotlightBeautyProccess_nativeCreateEngine");
    return 1L;
}

JNIEXPORT void JNICALL
Java_com_arcsoft_livebroadcast_ArcSpotlightBeautyProccess_nativeDestroyEngine(JNIEnv *env, jobject thiz, jlong handle) {
}

JNIEXPORT jobject JNICALL
Java_com_arcsoft_livebroadcast_ArcSpotlightBeautyProccess_nativeGetVersion(JNIEnv *env, jobject thiz, jlong handle) {
    return createVersionObject(env);
}

JNIEXPORT jint JNICALL
Java_com_arcsoft_livebroadcast_ArcSpotlightBeautyProccess_nativeInitial(JNIEnv *env, jobject thiz, jlong handle) {
    return 0;
}

JNIEXPORT jint JNICALL
Java_com_arcsoft_livebroadcast_ArcSpotlightBeautyProccess_nativeProcess(
        JNIEnv *env, jobject thiz, jobject offscreen, jboolean flag1, jboolean flag2, jlong handle) {
    return 0;
}

JNIEXPORT jint JNICALL
Java_com_arcsoft_livebroadcast_ArcSpotlightBeautyProccess_nativeProcessWithTexture(
        JNIEnv *env, jobject thiz, jint inTex, jint outTex, jint format, jfloat param,
        jboolean flag1, jboolean flag2, jlong handle) {
    return 0;
}

JNIEXPORT jint JNICALL
Java_com_arcsoft_livebroadcast_ArcSpotlightBeautyProccess_nativeProcessWithTextureBegin(
        JNIEnv *env, jobject thiz, jint inTex, jint outTex, jint format, jfloat param, jlong handle) {
    return 0;
}

JNIEXPORT jint JNICALL
Java_com_arcsoft_livebroadcast_ArcSpotlightBeautyProccess_nativeProcessWithTextureEnd(
        JNIEnv *env, jobject thiz, jboolean flag1, jboolean flag2, jlong handle) {
    return 0;
}

JNIEXPORT void JNICALL
Java_com_arcsoft_livebroadcast_ArcSpotlightBeautyProccess_nativeUninitial(JNIEnv *env, jobject thiz, jlong handle) {
}

} // extern "C"
