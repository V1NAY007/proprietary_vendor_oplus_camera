package com.oplus.media;

public class OplusAudioManager {
    private static final OplusAudioManager sInstance = new OplusAudioManager();

    public static OplusAudioManager getInstance() {
        return sInstance;
    }

    public void setRingerModeInternal(int mode) {}
}
