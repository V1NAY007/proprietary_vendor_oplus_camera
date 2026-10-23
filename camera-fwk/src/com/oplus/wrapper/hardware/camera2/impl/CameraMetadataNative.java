package com.oplus.wrapper.hardware.camera2.impl;

public class CameraMetadataNative {
    private final android.hardware.camera2.impl.CameraMetadataNative mCameraMetadataNative;

    public CameraMetadataNative(android.hardware.camera2.impl.CameraMetadataNative cameraMetadataNative) {
        mCameraMetadataNative = cameraMetadataNative;
    }

    public int getTag(String key, long vendorId) {
        return mCameraMetadataNative != null ? android.hardware.camera2.impl.CameraMetadataNative.getTag(key, vendorId) : -1;
    }

    public long getMetadataPtr() {
        return mCameraMetadataNative != null ? mCameraMetadataNative.getMetadataPtr() : 0L;
    }

    public android.hardware.camera2.impl.CameraMetadataNative getNative() {
        return mCameraMetadataNative;
    }
}
