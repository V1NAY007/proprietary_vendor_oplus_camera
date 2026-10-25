package com.color.zoomwindow;

import android.content.Intent;
import android.os.Bundle;

public class ColorZoomWindowManager {
    private static final ColorZoomWindowManager sInstance = new ColorZoomWindowManager();

    public static ColorZoomWindowManager getInstance() {
        return sInstance;
    }

    public boolean isSupportZoomMode(String pkg, int mode, String str2, Bundle bundle) {
        return false;
    }

    public int startZoomWindow(Intent intent, Bundle bundle, int i, String str) {
        return 0;
    }

    public boolean isSupportZoomWindowMode() {
        return false;
    }

    public ColorZoomWindowInfo getCurrentZoomWindowState() {
        return new ColorZoomWindowInfo();
    }

    public boolean registerZoomWindowObserver(IColorZoomWindowObserver observer) {
        return false;
    }

    public boolean unregisterZoomWindowObserver(IColorZoomWindowObserver observer) {
        return false;
    }
}
