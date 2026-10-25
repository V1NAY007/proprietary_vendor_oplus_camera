package com.oplus.miragewindow;

import java.util.ArrayList;
import java.util.List;

public class OplusMirageWindowManager {
    private static final OplusMirageWindowManager sInstance = new OplusMirageWindowManager();

    public static OplusMirageWindowManager getInstance() {
        return sInstance;
    }

    public List<OplusCastScreenState> getCastScreenStateList() {
        return new ArrayList<>();
    }
}
