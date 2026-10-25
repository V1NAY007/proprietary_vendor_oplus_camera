package com.color.splitscreen;

public class ColorSplitScreenManager {
    private static final ColorSplitScreenManager sInstance = new ColorSplitScreenManager();

    public static ColorSplitScreenManager getInstance() {
        return sInstance;
    }

    public boolean registerSplitScreenObserver(Object observer) {
        return false;
    }

    public boolean unregisterSplitScreenObserver(Object observer) {
        return false;
    }
}
