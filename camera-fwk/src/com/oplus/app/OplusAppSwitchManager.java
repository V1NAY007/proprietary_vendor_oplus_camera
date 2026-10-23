package com.oplus.app;

import android.content.Context;

public class OplusAppSwitchManager {
    public interface OnAppSwitchObserver {
        default void onActivityEnter(OplusAppEnterInfo info) {}
        default void onActivityExit(OplusAppExitInfo info) {}
        default void onAppEnter(OplusAppEnterInfo info) {}
        default void onAppExit(OplusAppExitInfo info) {}
    }

    private static final OplusAppSwitchManager sInstance = new OplusAppSwitchManager();

    public static OplusAppSwitchManager getInstance() {
        return sInstance;
    }

    public boolean registerAppSwitchObserver(Context context, OnAppSwitchObserver observer, OplusAppSwitchConfig config) {
        return false;
    }

    public boolean unregisterAppSwitchObserver(Context context, OnAppSwitchObserver observer) {
        return false;
    }
}
