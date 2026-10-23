package com.oplus.miscnode;

public class OplusMiscNodeManager {
    private static final OplusMiscNodeManager sInstance = new OplusMiscNodeManager();

    public static OplusMiscNodeManager getInstance() {
        return sInstance;
    }

    public void writeMiscNodeFile(int cmd, String value) {}
}
