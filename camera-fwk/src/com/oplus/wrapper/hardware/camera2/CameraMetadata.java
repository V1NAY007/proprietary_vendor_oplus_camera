package com.oplus.wrapper.hardware.camera2;

public class CameraMetadata {
    private final android.hardware.camera2.CameraMetadata mCameraMetadata;

    public CameraMetadata(android.hardware.camera2.CameraMetadata cameraMetadata) {
        mCameraMetadata = cameraMetadata;
    }

    public long getNativeMetadataPtr() {
        return 0L;
    }
}
