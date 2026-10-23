package com.oplus.inner.os.storage;

public class StorageEventListenerWrapper {
    public StorageEventListenerWrapper() {}
    public void onStorageStateChanged(String path, String oldState, String newState) {}
    public void onVolumeStateChanged(VolumeInfoWrapper vol, int state, int envKey) {}
}
