package com.oplus.orms;

import com.oplus.orms.info.OrmsSaParam;

public class OplusResourceManager {
    private static final OplusResourceManager sInstance = new OplusResourceManager();

    public static OplusResourceManager getInstance(Class<?> clazz) {
        return sInstance;
    }

    public long ormsSetSceneAction(OrmsSaParam param) {
        return 0L;
    }

    public void ormsClrSceneAction(long actionId) {}
}
