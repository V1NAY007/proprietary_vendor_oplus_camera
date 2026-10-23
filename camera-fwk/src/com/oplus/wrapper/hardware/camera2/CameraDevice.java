package com.oplus.wrapper.hardware.camera2;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.params.InputConfiguration;
import android.os.Handler;
import java.util.List;

public class CameraDevice {
    private final android.hardware.camera2.CameraDevice mCameraDevice;

    public CameraDevice(android.hardware.camera2.CameraDevice cameraDevice) {
        mCameraDevice = cameraDevice;
    }

    public void createCustomCaptureSession(InputConfiguration inputConfig, List outputs, int operatingMode,
            CameraCaptureSession.StateCallback callback, Handler handler) {
    }
}
