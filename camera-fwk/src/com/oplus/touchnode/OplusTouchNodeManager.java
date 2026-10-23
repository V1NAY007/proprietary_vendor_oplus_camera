package com.oplus.touchnode;

public class OplusTouchNodeManager {
    private static final OplusTouchNodeManager sInstance = new OplusTouchNodeManager();

    public static OplusTouchNodeManager getInstance() {
        return sInstance;
    }

    public boolean writeNodeFileByDevice(int dev, int node, String val) {
        return false;
    }
}
