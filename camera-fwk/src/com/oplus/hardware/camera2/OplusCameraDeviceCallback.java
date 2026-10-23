package com.oplus.hardware.camera2;

public class OplusCameraDeviceCallback extends IOplusCameraDeviceCallback.Stub {
    public OplusCameraDeviceCallback() {}

    @Override
    public void onDeviceOpened(int cameraId, String packageName) {}

    @Override
    public void onDisconnected(int cameraId, String packageName) {}

    @Override
    public void onInterceptOpen(int cameraId, String packageName, int errorCode) {}
}
