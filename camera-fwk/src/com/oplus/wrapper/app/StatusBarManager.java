package com.oplus.wrapper.app;

public class StatusBarManager {
    private final android.app.StatusBarManager mStatusBarManager;

    public StatusBarManager(android.app.StatusBarManager statusBarManager) {
        mStatusBarManager = statusBarManager;
    }

    public void collapsePanels() {
        if (mStatusBarManager != null) {
            mStatusBarManager.collapsePanels();
        }
    }

    public void expandNotificationsPanel() {
        if (mStatusBarManager != null) {
            mStatusBarManager.expandNotificationsPanel();
        }
    }
}
