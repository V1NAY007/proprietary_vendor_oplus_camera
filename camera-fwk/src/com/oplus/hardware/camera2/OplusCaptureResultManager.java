package com.oplus.hardware.camera2;

import android.hardware.camera2.CaptureResult;

public abstract class OplusCaptureResultManager {
    public OplusCaptureResultManager() {}

    public abstract OplusCaptureResult.CloseHandle addResultRefCount(OplusCaptureResult result, String reason);
    public abstract void clearOplusCaptureResults();
    public abstract OplusCaptureResult obtainOplusCaptureResult(CaptureResult result, int type);
    public abstract void reduceResultRefCount(OplusCaptureResult.CloseHandle handle);
    public abstract void removeOplusCaptureResult(OplusCaptureResult result);
}
