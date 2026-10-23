package com.oplus.os;

import android.content.Context;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import java.io.File;
import java.util.List;

public class OplusUsbEnvironment {
    public static File getInternalSdDirectory(Context context) {
        return Environment.getExternalStorageDirectory();
    }

    public static String getInternalSdState(Context context) {
        return Environment.getExternalStorageState();
    }

    public static File getExternalSdDirectory(Context context) {
        if (context != null) {
            try {
                StorageManager sm = context.getSystemService(StorageManager.class);
                if (sm != null) {
                    List<StorageVolume> volumes = sm.getStorageVolumes();
                    if (volumes != null) {
                        for (StorageVolume volume : volumes) {
                            if (volume.isRemovable()) {
                                return volume.getDirectory();
                            }
                        }
                    }
                }
            } catch (Exception ignored) {
            }
        }
        return null;
    }

    public static String getExternalSdState(Context context) {
        if (context != null) {
            try {
                StorageManager sm = context.getSystemService(StorageManager.class);
                if (sm != null) {
                    List<StorageVolume> volumes = sm.getStorageVolumes();
                    if (volumes != null) {
                        for (StorageVolume volume : volumes) {
                            if (volume.isRemovable()) {
                                return volume.getState();
                            }
                        }
                    }
                }
            } catch (Exception ignored) {
            }
        }
        return Environment.MEDIA_REMOVED;
    }

    public static boolean isVolumeMounted(Context context, String path) {
        if (path == null) {
            return false;
        }

        File internal = getInternalSdDirectory(context);
        if (internal != null && (path.equals(internal.getPath()) || path.equals(internal.getAbsolutePath()))) {
            return Environment.MEDIA_MOUNTED.equals(getInternalSdState(context));
        }

        File external = getExternalSdDirectory(context);
        if (external != null && (path.equals(external.getPath()) || path.equals(external.getAbsolutePath()))) {
            return Environment.MEDIA_MOUNTED.equals(getExternalSdState(context));
        }

        if (context != null) {
            try {
                StorageManager sm = context.getSystemService(StorageManager.class);
                if (sm != null) {
                    StorageVolume sv = sm.getStorageVolume(new File(path));
                    if (sv != null) {
                        return Environment.MEDIA_MOUNTED.equals(sv.getState());
                    }
                }
            } catch (Exception ignored) {
            }
        }

        if (internal != null && path.startsWith(internal.getAbsolutePath())) {
            return Environment.MEDIA_MOUNTED.equals(getInternalSdState(context));
        }

        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState());
    }
}
