package com.oplus.zoomwindow;

import android.content.Intent;
import android.os.Bundle;

public class OplusZoomWindowManager {
    private static final OplusZoomWindowManager sInstance = new OplusZoomWindowManager();

    public static OplusZoomWindowManager getInstance() {
        return sInstance;
    }

    public boolean isSupportZoomMode(String pkg, int mode, String str2, Bundle bundle) {
        return false;
    }

    public int startZoomWindow(Intent intent, Bundle bundle, int i, String str) {
        return 0;
    }
}
