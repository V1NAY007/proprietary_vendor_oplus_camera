package com.oplus.wrapper.os;

import java.util.Map;

public class Debug {
    public static Map<String, String> getVmFeatureList() {
        return null;
    }

    public static String getCallers(int depth) {
        return android.os.Debug.getCallers(depth);
    }
}
