package com.oplus.ocs.camera;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UxThreadPool {
    private static final UxThreadPool sInstance = new UxThreadPool();
    private final ExecutorService mExecutor = Executors.newCachedThreadPool();

    public static UxThreadPool getInstance() {
        return sInstance;
    }

    public void initCoreThread() {
    }

    public void execute(Runnable runnable) {
        if (runnable != null) {
            mExecutor.execute(runnable);
        }
    }

    public void execute(String name, Runnable runnable) {
        if (runnable != null) {
            mExecutor.execute(runnable);
        }
    }

    public Future<?> submit(Runnable runnable) {
        if (runnable != null) {
            return mExecutor.submit(runnable);
        }
        return null;
    }
}
