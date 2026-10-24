package com.oplus.content;

public class OplusFeatureConfigManager {
    private static final OplusFeatureConfigManager sInstance = new OplusFeatureConfigManager();

    public interface OnFeatureActionObserver {
        void onFeaturesActionUpdate(String action, String feature, IOplusFeatureConfigManager.FeatureID featureID);
    }

    public static OplusFeatureConfigManager getInstance() {
        return sInstance;
    }

    public boolean hasFeature(String feature) {
        return false;
    }

    public boolean hasFeature(String feature, int flag) {
        return false;
    }

    public boolean isPermit(String feature) {
        return true;
    }

    public boolean registerFeatureActionObserver(OnFeatureActionObserver observer) {
        return true;
    }

    public boolean unregisterFeatureActionObserver(OnFeatureActionObserver observer) {
        return true;
    }
}
