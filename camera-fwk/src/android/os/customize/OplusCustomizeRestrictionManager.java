package android.os.customize;

import android.content.ComponentName;
import android.content.Context;

public class OplusCustomizeRestrictionManager {
    private static final OplusCustomizeRestrictionManager sInstance = new OplusCustomizeRestrictionManager();

    public static OplusCustomizeRestrictionManager getInstance(Context context) {
        return sInstance;
    }

    public boolean getForbidRecordScreenState() {
        return false;
    }

    public boolean isFloatTaskDisabled(ComponentName componentName) {
        return false;
    }

    public boolean setFloatTaskDisabled(ComponentName componentName, boolean disabled) {
        return false;
    }
}
