package com.oplus.uah;

import android.content.Context;
import android.view.MotionEvent;

public class UAHResClient {
    private static final UAHResClient sInstance = new UAHResClient();

    public static UAHResClient get(Context context) {
        return sInstance;
    }

    public static UAHResClient getInstance() {
        return sInstance;
    }

    public int acquireEvent(Object request) {
        return 0;
    }

    public void releaseEvent(int handle, int action) {}
    public int acquireAction(int action) { return 0; }
    public void releaseAction(int action) {}
    public void acquireTouch(MotionEvent ev, int duration) {}
}
