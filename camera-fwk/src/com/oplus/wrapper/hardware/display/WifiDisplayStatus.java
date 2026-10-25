package com.oplus.wrapper.hardware.display;

public class WifiDisplayStatus {
    public static final int DISPLAY_STATE_OFF = 0;
    public static final int DISPLAY_STATE_CONNECTING = 1;
    public static final int DISPLAY_STATE_CONNECTED = 2;

    public int getActiveDisplayState() {
        return DISPLAY_STATE_OFF;
    }
}
