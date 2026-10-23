package com.oplus.uifirst;

public class OplusUIFirstManager {
    private static OplusUIFirstManager sInstance = null;

    public static synchronized OplusUIFirstManager getInstance() {
        if (sInstance == null) {
            sInstance = new OplusUIFirstManager();
        }
        return sInstance;
    }

    public void setUxThreadValue(int pid, int tid, String value) {}
    public void setUxThreadValue(int pid, int tid, int value) {}
    public void setUxThreadValueByFile(int pid, int tid, int value) {}
    public void setProcessUxValue(int pid, int value) {}
    public void setBinderThreadUxFlag(int pid, int flag) {}
    public void acquireLaunchBoost() {}
    public void acquireUxSceneBoost(String scene, int timeout) {}
}
