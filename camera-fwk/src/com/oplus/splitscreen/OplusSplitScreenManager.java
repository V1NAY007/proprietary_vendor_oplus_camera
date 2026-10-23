package com.oplus.splitscreen;

import com.oplus.app.IOplusSplitScreenObserver;

public class OplusSplitScreenManager {
    private static final OplusSplitScreenManager sInstance = new OplusSplitScreenManager();

    public static OplusSplitScreenManager getInstance() {
        return sInstance;
    }

    public boolean registerSplitScreenObserver(IOplusSplitScreenObserver observer) {
        return false;
    }

    public boolean unregisterSplitScreenObserver(IOplusSplitScreenObserver observer) {
        return false;
    }
}
