package com.oplus.wrapper.view;

import android.os.IBinder;

public interface IWindowManager {
    int getInitialDisplayDensity(int displayId);

    boolean hasNavigationBar(int displayId);

    class Stub {
        public static IWindowManager asInterface(IBinder obj) {
            final android.view.IWindowManager wm =
                    obj != null ? android.view.IWindowManager.Stub.asInterface(obj) : null;
            return new IWindowManager() {
                @Override
                public int getInitialDisplayDensity(int displayId) {
                    if (wm != null) {
                        try {
                            return wm.getInitialDisplayDensity(displayId);
                        } catch (Throwable ignored) {
                        }
                    }
                    return 0;
                }

                @Override
                public boolean hasNavigationBar(int displayId) {
                    if (wm != null) {
                        try {
                            return wm.hasNavigationBar(displayId);
                        } catch (Throwable ignored) {
                        }
                    }
                    return false;
                }
            };
        }
    }
}

