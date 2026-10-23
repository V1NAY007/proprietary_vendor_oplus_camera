package android.os;

import android.content.Context;
import android.util.ArrayMap;

public class OplusKeyEventManager {
    public interface OnKeyEventObserver {
        void onKeyEvent(int keyCode, boolean down);
    }

    private static OplusKeyEventManager sInstance = null;

    public static synchronized OplusKeyEventManager getInstance() {
        if (sInstance == null) {
            sInstance = new OplusKeyEventManager();
        }
        return sInstance;
    }

    public boolean registerKeyEventInterceptor(Context context, String name, OnKeyEventObserver observer, ArrayMap<?, ?> actions) {
        return false;
    }

    public boolean registerKeyEventObserver(Context context, OnKeyEventObserver observer, int flags) {
        return false;
    }

    public boolean unregisterKeyEventInterceptor(Context context, String name, OnKeyEventObserver observer) {
        return false;
    }

    public boolean unregisterKeyEventObserver(Context context, OnKeyEventObserver observer) {
        return false;
    }
}
