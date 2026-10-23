package android.os.customize;

import android.content.Context;

public class OplusCustomizeStateManager {
    private static final OplusCustomizeStateManager sInstance = new OplusCustomizeStateManager();

    public static OplusCustomizeStateManager getInstance(Context context) {
        return sInstance;
    }
}
