package android.os.customize;

import android.content.Context;

public class OplusCustomizeContactManager {
    private static final OplusCustomizeContactManager sInstance = new OplusCustomizeContactManager();

    public static OplusCustomizeContactManager getInstance(Context context) {
        return sInstance;
    }

    public int getContactBlockPattern() {
        return 0;
    }

    public int getContactMatchPattern() {
        return 0;
    }

    public int getContactNumberHideMode() {
        return 0;
    }

    public int getContactNumberMaskEnable() {
        return 0;
    }

    public int getContactOutgoOrIncomePattern() {
        return 0;
    }

    public boolean isContactBlackListEnable() {
        return false;
    }

    public boolean isForbidCallLogEnable() {
        return false;
    }
}
