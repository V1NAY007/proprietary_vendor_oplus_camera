package com.color.app;

public class ColorAppSwitchManager {
    public interface OnAppSwitchObserver {
        void onAppEnter(ColorAppEnterInfo info);
        void onAppExit(ColorAppExitInfo info);
    }

    private static final ColorAppSwitchManager sInstance = new ColorAppSwitchManager();

    public static ColorAppSwitchManager getInstance() {
        return sInstance;
    }

    public boolean setAppSwitchObserver(String pkg, OnAppSwitchObserver observer, ColorAppSwitchConfig config) {
        return false;
    }
}
