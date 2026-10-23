package com.oplus.wrapper.hardware.camera2;

public class CaptureRequest {
    public CaptureRequest() {}

    public static class Key<T> {
        private final android.hardware.camera2.CaptureRequest.Key<T> mKey;

        public Key(String name, Class<T> type) {
            mKey = new android.hardware.camera2.CaptureRequest.Key<>(name, type);
        }

        public Key(String name, Class<T> type, long vendorId) {
            mKey = new android.hardware.camera2.CaptureRequest.Key<>(name, type);
        }

        public android.hardware.camera2.CaptureRequest.Key<T> getKey() {
            return mKey;
        }
    }
}
