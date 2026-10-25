package com.oplus.confinemode;

import android.content.Context;
import java.util.List;

public class OplusConfineModeManager {
    public interface ConfineModeObserver {
        void onChange();
    }

    private static final OplusConfineModeManager sInstance = new OplusConfineModeManager();

    public static OplusConfineModeManager getInstance() {
        return sInstance;
    }

    public int getConfineMode() {
        return 0;
    }

    public boolean registerConfineModeObserver(Context context, ConfineModeObserver observer) {
        return false;
    }

    public void setConfineMode(int mode, boolean enable) {}

    public void setPermitList(int mode, int type, List<String> list, boolean enable) {}
}
