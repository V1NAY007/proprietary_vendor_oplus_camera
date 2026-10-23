package com.oplus.camera.combinelut;

public class CombineLutJNI {
    private static boolean sLoaded = false;

    static {
        try {
            System.loadLibrary("CombineLutJni");
            sLoaded = true;
        } catch (Throwable t) {
            sLoaded = false;
        }
    }

    public CombineLutJNI() {}

    public native String getVersion();

    public native int init(String str, String str2, String str3, int i);

    public int initV2(String str, String str2, String str3, int i, int i2) {
        if (sLoaded) {
            try {
                return init(str, str2, str3, i);
            } catch (Throwable t) {
                // ignore
            }
        }
        return -1;
    }

    public native float[] process(int i, int i2, int i3, int i4, int[] iArr);

    public float[] processV2(int i, int i2, int i3, int i4, float f, float f2, float f3, int[] iArr) {
        if (sLoaded) {
            try {
                return process(i, i2, i3, i4, iArr);
            } catch (Throwable t) {
                // ignore
            }
        }
        return null;
    }

    public float[] processV3(int i, int i2, int i3, int i4, float f, float f2, float f3, int[] iArr, int i5) {
        if (sLoaded) {
            try {
                return process(i, i2, i3, i4, iArr);
            } catch (Throwable t) {
                // ignore
            }
        }
        return null;
    }

    public float[] processV3(int i, int i2, int i3, int i4, float f, float f2, float f3, String[] strArr, int[] iArr) {
        if (sLoaded) {
            try {
                return process(i, i2, i3, i4, iArr);
            } catch (Throwable t) {
                // ignore
            }
        }
        return null;
    }

    public native void release();
}
