package com.oplus.wrapper.telephony;

public class SubscriptionManager {
    public static int getPhoneId(int subId) {
        return android.telephony.SubscriptionManager.getPhoneId(subId);
    }

    public static int getSlotIndex(int subId) {
        return android.telephony.SubscriptionManager.getSlotIndex(subId);
    }

    public static int getSubId(int slotIndex) {
        int[] subIds = android.telephony.SubscriptionManager.getSubId(slotIndex);
        if (subIds != null && subIds.length > 0) {
            return subIds[0];
        }
        return -1;
    }
}
