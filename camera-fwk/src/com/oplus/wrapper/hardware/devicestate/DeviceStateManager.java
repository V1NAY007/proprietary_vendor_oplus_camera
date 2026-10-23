package com.oplus.wrapper.hardware.devicestate;

import android.content.Context;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

public class DeviceStateManager {
    public interface DeviceStateCallback {
        void onStateChanged(int state);
    }

    private final android.hardware.devicestate.DeviceStateManager mDeviceStateManager;
    private final Map<DeviceStateCallback, android.hardware.devicestate.DeviceStateManager.DeviceStateCallback> mCallbackMap =
            new ConcurrentHashMap<>();

    public DeviceStateManager(Context context) {
        if (context != null) {
            mDeviceStateManager = context.getSystemService(android.hardware.devicestate.DeviceStateManager.class);
        } else {
            mDeviceStateManager = null;
        }
    }

    public DeviceStateManager(android.hardware.devicestate.DeviceStateManager manager) {
        mDeviceStateManager = manager;
    }

    public void registerCallback(Executor executor, DeviceStateCallback callback) {
        if (mDeviceStateManager == null || callback == null || executor == null) {
            return;
        }
        android.hardware.devicestate.DeviceStateManager.DeviceStateCallback proxy =
                state -> callback.onStateChanged(state.getIdentifier());
        mCallbackMap.put(callback, proxy);
        try {
            mDeviceStateManager.registerCallback(executor, proxy);
        } catch (Throwable ignored) {
        }
    }

    public void unregisterCallback(DeviceStateCallback callback) {
        if (mDeviceStateManager == null || callback == null) {
            return;
        }
        android.hardware.devicestate.DeviceStateManager.DeviceStateCallback proxy =
                mCallbackMap.remove(callback);
        if (proxy != null) {
            try {
                mDeviceStateManager.unregisterCallback(proxy);
            } catch (Throwable ignored) {
            }
        }
    }
}
