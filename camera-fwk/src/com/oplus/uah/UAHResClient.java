package com.oplus.uah;

import android.content.Context;
import android.view.MotionEvent;
import com.oplus.uah.info.UAHEventRequest;

public class UAHResClient {
    private static final UAHResClient sInstance = new UAHResClient();

    public UAHResClient() {}
    public UAHResClient(Class<?> clazz) {}
    public UAHResClient(Context context) {}

    public static synchronized UAHResClient get(Class<?> clazz) {
        return sInstance;
    }

    public static synchronized UAHResClient get(Context context) {
        return sInstance;
    }

    public static synchronized UAHResClient getInstance() {
        return sInstance;
    }

    public int acquireEvent(UAHEventRequest request) {
        return 0;
    }

    public int acquireEvent(Object request) {
        return 0;
    }

    public void release(int handle) {}
    public void releaseEvent(int handle, int action) {}
    public int acquireAction(int action) { return 0; }
    public void releaseAction(int action) {}
    public void acquireTouch(MotionEvent ev, int duration) {}
    public void acquireTouch(MotionEvent ev) {}
}
