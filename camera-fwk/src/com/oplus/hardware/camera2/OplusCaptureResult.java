package com.oplus.hardware.camera2;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

public interface OplusCaptureResult {

    @Retention(RetentionPolicy.SOURCE)
    public @interface CaptureResultType {
        int CAPTURE_RESULT = 1;
        int PREVIEW_RESULT = 0;
    }

    public static final class CloseHandle {
        public static final CloseHandle INVALID = new CloseHandle();

        private volatile boolean mIsValid;
        private volatile OplusCaptureResult mOPlusCaptureResult;
        private volatile OplusCaptureResultManager mOplusResultManager;
        private volatile String mReason;

        private CloseHandle() {
            this.mIsValid = false;
            this.mReason = "";
            this.mOPlusCaptureResult = null;
            this.mOplusResultManager = null;
        }

        public CloseHandle(OplusCaptureResultManager manager, OplusCaptureResult result, String reason) {
            this.mIsValid = false;
            this.mReason = "";
            this.mOPlusCaptureResult = null;
            this.mOplusResultManager = null;
            init(manager, result, reason);
        }

        public static CloseHandle close(CloseHandle handle) {
            if (isValid(handle)) {
                handle.onClose();
            }
            return INVALID;
        }

        public static boolean isValid(CloseHandle handle) {
            return handle != null && handle.mIsValid && handle.mOPlusCaptureResult != null;
        }

        public synchronized void init(OplusCaptureResultManager manager, OplusCaptureResult result, String reason) {
            this.mOPlusCaptureResult = result;
            this.mOplusResultManager = manager;
            this.mReason = reason;
            this.mIsValid = true;
        }

        public void onClose() {
            if (this.mOplusResultManager != null) {
                this.mOplusResultManager.reduceResultRefCount(this);
            }
        }

        public synchronized void reset() {
            this.mOPlusCaptureResult = null;
            this.mOplusResultManager = null;
            this.mReason = "";
            this.mIsValid = false;
        }

        public OplusCaptureResult getOPlusCaptureResult() {
            return this.mOPlusCaptureResult;
        }

        public OplusCaptureResultManager getOplusResultManager() {
            return this.mOplusResultManager;
        }

        public String getReason() {
            return this.mReason;
        }

        @Override
        public boolean equals(Object obj) {
            return Objects.hash(this) == Objects.hash(obj);
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("Reason:");
            sb.append(this.mReason);
            sb.append(", isValid: ");
            sb.append(isValid(this));
            sb.append(", ");
            if (this.mOPlusCaptureResult != null) {
                sb.append(this.mOPlusCaptureResult.toString());
            } else {
                sb.append("mOPlusCaptureResult is null");
            }
            return sb.toString();
        }
    }

    CloseHandle addResultRefCount(String reason);
    <T> T get(CaptureResult.Key<T> key);
    String getCameraId();
    CaptureRequest getCaptureRequest();
    CaptureResult getCaptureResult();
    long getFrameNumber();
    int getResultType();
    long getTimestamp();
    boolean isCloseable();
    boolean isClosed();
    boolean isPreviewResult();
}
