package com.oplus.wrapper.hardware.camera2;

public class CameraCharacteristics {
    private final android.hardware.camera2.CameraCharacteristics mCameraCharacteristics;

    public CameraCharacteristics(android.hardware.camera2.CameraCharacteristics cameraCharacteristics) {
        mCameraCharacteristics = cameraCharacteristics;
    }

    public com.oplus.wrapper.hardware.camera2.impl.CameraMetadataNative getNativeMetadata() {
        if (mCameraCharacteristics != null && mCameraCharacteristics.getNativeMetadata() != null) {
            return new com.oplus.wrapper.hardware.camera2.impl.CameraMetadataNative(mCameraCharacteristics.getNativeMetadata());
        }
        return null;
    }
}
