package com.oplus.oiface;

public class OifaceManager {
    private static final OifaceManager sInstance = new OifaceManager();

    public static OifaceManager getInstance(String name) {
        return sInstance;
    }

    public String getSupportGameStartPackage() {
        return null;
    }

    public boolean registerOifaceCallback(IOIfaceCallback callback) {
        return false;
    }
}
