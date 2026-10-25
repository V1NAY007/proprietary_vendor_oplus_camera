package com.oplus.wrapper.os.storage;

import android.os.storage.StorageVolume;
import java.util.List;

public class StorageManager {
    private final android.os.storage.StorageManager mStorageManager;

    public StorageManager(android.os.storage.StorageManager storageManager) {
        mStorageManager = storageManager;
    }

    public StorageVolume[] getVolumeList() {
        if (mStorageManager != null) {
            List<StorageVolume> volumes = mStorageManager.getStorageVolumes();
            if (volumes != null) {
                return volumes.toArray(new StorageVolume[0]);
            }
        }
        return new StorageVolume[0];
    }
}
