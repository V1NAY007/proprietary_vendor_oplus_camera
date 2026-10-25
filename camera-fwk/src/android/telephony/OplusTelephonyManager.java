package android.telephony;

import android.content.Context;

public class OplusTelephonyManager {
    private static final OplusTelephonyManager sInstance = new OplusTelephonyManager();

    public static OplusTelephonyManager getInstance(Context context) {
        return sInstance;
    }

    public int setVsimId(int id) {
        return 0;
    }
}
