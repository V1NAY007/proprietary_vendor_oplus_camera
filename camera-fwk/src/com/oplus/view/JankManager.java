package com.oplus.view;

import android.content.Context;

public class JankManager {
    private static JankManager sInstance = null;

    public static synchronized JankManager getInstance() {
        if (sInstance == null) {
            sInstance = new JankManager();
        }
        return sInstance;
    }

    public void gfxSceneBegin(Context context, int sceneId, String sceneName, long time) {}
    public void gfxSceneEnd(Context context, int sceneId, String sceneName, long time) {}
}
