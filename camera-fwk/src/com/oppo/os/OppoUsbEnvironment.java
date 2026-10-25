package com.oppo.os;

import android.content.Context;
import com.oplus.os.OplusUsbEnvironment;
import java.io.File;
import java.util.List;

public class OppoUsbEnvironment {
    public static final int NONE = OplusUsbEnvironment.NONE;
    public static final int INTERNAL = OplusUsbEnvironment.INTERNAL;
    public static final int EXTERNAL = OplusUsbEnvironment.EXTERNAL;
    public static final int OTG = OplusUsbEnvironment.OTG;
    public static final String MEDIA_MOUNTED = OplusUsbEnvironment.MEDIA_MOUNTED;

    public static File getInternalSdDirectory(Context context) {
        return OplusUsbEnvironment.getInternalSdDirectory(context);
    }

    public static String getInternalSdState(Context context) {
        return OplusUsbEnvironment.getInternalSdState(context);
    }

    public static String getInternalPath(Context context) {
        return OplusUsbEnvironment.getInternalPath(context);
    }

    public static File getExternalSdDirectory(Context context) {
        return OplusUsbEnvironment.getExternalSdDirectory(context);
    }

    public static String getExternalSdState(Context context) {
        return OplusUsbEnvironment.getExternalSdState(context);
    }

    public static String getExternalPath(Context context) {
        return OplusUsbEnvironment.getExternalPath(context);
    }

    public static File getExternalStorageDirectory() {
        return OplusUsbEnvironment.getExternalStorageDirectory();
    }

    public static List<String> getOtgPath(Context context) {
        return OplusUsbEnvironment.getOtgPath(context);
    }

    public static boolean isVolumeMounted(Context context, String path) {
        return OplusUsbEnvironment.isVolumeMounted(context, path);
    }

    public static boolean isExternalSDRemoved(Context context) {
        return OplusUsbEnvironment.isExternalSDRemoved(context);
    }

    public static boolean isNestMounted() {
        return OplusUsbEnvironment.isNestMounted();
    }

    public static int getPathType(Context context, String path) {
        return OplusUsbEnvironment.getPathType(context, path);
    }

    public static String getMultiappSdDirectory() {
        return "/storage/emulated/999";
    }
}
