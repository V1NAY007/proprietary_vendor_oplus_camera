package com.oplus.multiapp;

import java.util.ArrayList;
import java.util.List;

public class OplusMultiAppManager {
    private static final OplusMultiAppManager sInstance = new OplusMultiAppManager();

    public static OplusMultiAppManager getInstance() {
        return sInstance;
    }

    public String getMultiAppAlias(String pkg) {
        return null;
    }

    public List<String> getMultiAppList(int userId) {
        return new ArrayList<>();
    }
}
