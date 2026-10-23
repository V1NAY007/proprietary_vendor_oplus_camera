package com.oplus.wrapper.hardware.camera2;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import java.util.concurrent.Executor;

public class CameraManager {
    private final android.hardware.camera2.CameraManager mCameraManager;

    public CameraManager(android.hardware.camera2.CameraManager cameraManager) {
        mCameraManager = cameraManager;
    }

    public void openCamera(String cameraId, int oplusExt, Executor executor, CameraDevice.StateCallback callback)
            throws CameraAccessException {
        if (mCameraManager != null) {
            mCameraManager.openCamera(cameraId, executor, callback);
        }
    }
}
