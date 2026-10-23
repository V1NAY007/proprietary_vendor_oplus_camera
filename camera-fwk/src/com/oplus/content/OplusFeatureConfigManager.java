package com.oplus.content;

public class OplusFeatureConfigManager {
    private static final OplusFeatureConfigManager sInstance = new OplusFeatureConfigManager();

    public static OplusFeatureConfigManager getInstance() {
        return sInstance;
    }

    public boolean hasFeature(String feature) {
        return false;
    }

    public boolean hasFeature(String feature, int flag) {
        return false;
    }
}
