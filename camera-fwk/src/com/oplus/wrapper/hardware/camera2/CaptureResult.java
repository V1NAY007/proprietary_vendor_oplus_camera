package com.oplus.wrapper.hardware.camera2;

public class CaptureResult {
    private final android.hardware.camera2.CaptureResult mCaptureResult;

    public CaptureResult(android.hardware.camera2.CaptureResult captureResult) {
        mCaptureResult = captureResult;
    }

    public com.oplus.wrapper.hardware.camera2.impl.CameraMetadataNative getNativeCopy() {
        if (mCaptureResult != null && mCaptureResult.getNativeMetadata() != null) {
            return new com.oplus.wrapper.hardware.camera2.impl.CameraMetadataNative(
                    new android.hardware.camera2.impl.CameraMetadataNative(mCaptureResult.getNativeMetadata()));
        }
        return null;
    }

    public com.oplus.wrapper.hardware.camera2.impl.CameraMetadataNative getNativeMetadata() {
        if (mCaptureResult != null && mCaptureResult.getNativeMetadata() != null) {
            return new com.oplus.wrapper.hardware.camera2.impl.CameraMetadataNative(mCaptureResult.getNativeMetadata());
        }
        return null;
    }

    public static class Key<T> {
        private final android.hardware.camera2.CaptureResult.Key<T> mKey;

        public Key(android.hardware.camera2.CaptureResult.Key<T> key) {
            mKey = key;
        }

        public Key(String name, Class<T> type) {
            mKey = new android.hardware.camera2.CaptureResult.Key<>(name, type);
        }

        public Key(String name, Class<T> type, long vendorId) {
            mKey = new android.hardware.camera2.CaptureResult.Key<>(name, type);
        }

        public Key(String name, String fallbackName, Class<T> type) {
            mKey = new android.hardware.camera2.CaptureResult.Key<>(name, type);
        }

        public android.hardware.camera2.CaptureResult.Key<T> getKey() {
            return mKey;
        }

        public long getVendorId() {
            return 0L;
        }
    }
}
