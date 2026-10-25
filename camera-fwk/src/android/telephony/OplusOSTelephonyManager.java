package android.telephony;

import android.content.Context;

public class OplusOSTelephonyManager {
    private static final OplusOSTelephonyManager sInstance = new OplusOSTelephonyManager();

    public static OplusOSTelephonyManager getDefault(Context context) {
        return sInstance;
    }

    public int getCallStateGemini(int simId) { return 0; }
    public String getIccCardTypeGemini(int simId) { return ""; }
    public String getLine1NumberGemini(int simId) { return ""; }
    public String getNetworkOperatorGemini(int simId) { return ""; }
    public String getSimOperatorGemini(int simId) { return ""; }
    public int getSimStateGemini(int simId) { return 0; }
    public int getSubState(int simId) { return 0; }
    public String getSubscriberIdGemini(int simId) { return ""; }
    public String getVoiceMailNumberGemini(int simId) { return ""; }
    public boolean handlePinMmiForSubscriber(int simId, String dialString) { return false; }
    public boolean hasIccCardGemini(int simId) { return false; }
    public boolean isDualLteSupportedByPlatform() { return false; }
    public boolean isNetworkRoamingGemini(int simId) { return false; }
    public boolean isOplusHasSoftSimCard() { return false; }
    public boolean isOplusSingleSimCard() { return false; }
    public void listenGemini(Context context, PhoneStateListener listener, int events, int simId) {}
    public String oplusGetScAddressGemini(int simId, int type) { return ""; }
    public int oplusGetSoftSimCardSlotId() { return -1; }
    public boolean oplusIsQcomSubActive(int simId) { return false; }
    public boolean oplusIsVtEnabledByPlatform(Context context, int simId) { return false; }
    public void oplusSetDataRoamingEnabled(int simId, boolean enable) {}
    public void oplusSetScAddressGemini(int simId, String address, int type) {}
    public int oplusgetDefaultDataPhoneId(Context context) { return 0; }
    public int oplusgetSlotId(Context context, int subId) { return 0; }
    public int oplusgetSubId(Context context, int slotId) { return 0; }
    public void setDefaultApplication(String pkg, Context context) {}
}
