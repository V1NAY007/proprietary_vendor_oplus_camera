package com.oplus.wrapper.app;

import android.graphics.Rect;

public class WindowConfiguration {
    public static final int ACTIVITY_TYPE_STANDARD = 1;
    public static final int WINDOWING_MODE_FULLSCREEN = 1;
    public static final int WINDOWING_MODE_PINNED = 2;
    public static final int WINDOWING_MODE_FREEFORM = 5;
    public static final int ROTATION_UNDEFINED = -1;

    private final android.app.WindowConfiguration mConfig;

    public WindowConfiguration(android.app.WindowConfiguration config) {
        mConfig = config;
    }

    public Rect getAppBounds() {
        return mConfig != null ? mConfig.getAppBounds() : new Rect();
    }

    public Rect getBounds() {
        return mConfig != null ? mConfig.getBounds() : new Rect();
    }

    public Rect getMaxBounds() {
        return mConfig != null ? mConfig.getMaxBounds() : new Rect();
    }

    public int getRotation() {
        return mConfig != null ? mConfig.getRotation() : ROTATION_UNDEFINED;
    }

    public int getWindowingMode() {
        return mConfig != null ? mConfig.getWindowingMode() : WINDOWING_MODE_FULLSCREEN;
    }

    public void setAppBounds(Rect rect) {
        if (mConfig != null) {
            mConfig.setAppBounds(rect);
        }
    }

    public void setBounds(Rect rect) {
        if (mConfig != null) {
            mConfig.setBounds(rect);
        }
    }

    public void setWindowingMode(int windowingMode) {
        if (mConfig != null) {
            mConfig.setWindowingMode(windowingMode);
        }
    }
}
