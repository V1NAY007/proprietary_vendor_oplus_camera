package android.telephony;

import android.content.Context;

public class ColorOSTelephonyManager extends OplusOSTelephonyManager {
    private static final ColorOSTelephonyManager sColorInstance = new ColorOSTelephonyManager();

    public static ColorOSTelephonyManager getDefault(Context context) {
        return sColorInstance;
    }

    public String colorGetScAddressGemini(int simId, int type) { return ""; }
    public int colorGetSoftSimCardSlotId() { return -1; }
    public boolean colorIsQcomSubActive(int simId) { return false; }
    public boolean colorIsVtEnabledByPlatform(Context context, int simId) { return false; }
    public void colorSetDataRoamingEnabled(int simId, boolean enable) {}
    public void colorSetScAddressGemini(int simId, String address, int type) {}
    public int colorgetDefaultDataPhoneId(Context context) { return 0; }
    public int colorgetSlotId(Context context, int subId) { return 0; }
    public int colorgetSubId(Context context, int slotId) { return 0; }
    public boolean isColorHasSoftSimCard() { return false; }
    public boolean isOppoSingleSimCard() { return false; }
}
