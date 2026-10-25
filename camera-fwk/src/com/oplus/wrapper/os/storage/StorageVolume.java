package com.oplus.wrapper.os.storage;

import java.io.File;

public class StorageVolume {
    private final android.os.storage.StorageVolume mStorageVolume;

    public StorageVolume(android.os.storage.StorageVolume storageVolume) {
        mStorageVolume = storageVolume;
    }

    public String getPath() {
        if (mStorageVolume != null) {
            File dir = mStorageVolume.getDirectory();
            if (dir != null) {
                return dir.getAbsolutePath();
            }
        }
        return "";
    }
}
