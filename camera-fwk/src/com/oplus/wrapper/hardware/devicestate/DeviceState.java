package com.oplus.wrapper.hardware.devicestate;

public class DeviceState {
    private final int mIdentifier;

    public DeviceState(int identifier) {
        mIdentifier = identifier;
    }

    public DeviceState(android.hardware.devicestate.DeviceState state) {
        mIdentifier = state != null ? state.getIdentifier() : 0;
    }

    public int getIdentifier() {
        return mIdentifier;
    }
}
