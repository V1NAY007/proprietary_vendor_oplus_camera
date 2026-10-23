package com.oplus.wrapper.media;

public class AudioManager {
    private final android.media.AudioManager mAudioManager;

    public AudioManager(android.media.AudioManager audioManager) {
        mAudioManager = audioManager;
    }

    public String getParameters(String keys) {
        return mAudioManager != null ? mAudioManager.getParameters(keys) : "";
    }

    public void setParameters(String keyValuePairs) {
        if (mAudioManager != null) {
            mAudioManager.setParameters(keyValuePairs);
        }
    }
}
