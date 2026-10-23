package com.oplus.inner.content.res;

import android.content.res.Configuration;

public class ConfigurationWrapper {
    public static int getAccessibleChanged(Configuration configuration) {
        return 0;
    }

    public static String getCustomThemePath(Configuration configuration) {
        return "";
    }

    public static long getUxIconConfig(Configuration configuration) {
        return 0L;
    }

    public static void setUxIconConfig(Configuration configuration, long val) {}

    public static long getThemeChangedFlags(Configuration configuration) {
        return 0L;
    }

    public static long getMaterialColor(Configuration configuration) {
        return 0L;
    }
}
