package com.oplus.os;

import android.content.Context;
import android.os.Build;

public class OplusBuild {
    public static final String MARKET = null;
    public static final String REVISE_DEVICE_NAME = "revise_device_name";
    public static final String SECURE_SETTINGS_BLUETOOTH_NAME = "bluetooth_name";
    public static final int UNKNOWN = 0;

    public static final int OplusOS_1_0 = 1;
    public static final int OplusOS_1_2 = 2;
    public static final int OplusOS_1_4 = 3;
    public static final int OplusOS_2_0 = 4;
    public static final int OplusOS_2_1 = 5;
    public static final int OplusOS_3_0 = 6;
    public static final int OplusOS_3_1 = 7;
    public static final int OplusOS_3_2 = 8;
    public static final int OplusOS_5_0 = 9;
    public static final int OplusOS_5_1 = 10;
    public static final int OplusOS_5_2 = 11;
    public static final int OplusOS_6_0 = 12;
    public static final int OplusOS_6_1 = 13;
    public static final int OplusOS_6_2 = 14;
    public static final int OplusOS_6_7 = 15;
    public static final int OplusOS_7_0 = 16;
    public static final int OplusOS_7_1 = 17;
    public static final int OplusOS_7_2 = 18;
    public static final int OplusOS_11_0 = 19;
    public static final int OplusOS_11_1 = 20;
    public static final int OplusOS_11_2 = 21;
    public static final int OplusOS_11_3 = 22;
    public static final int OplusOS_12_0 = 23;
    public static final int OplusOS_12_1 = 24;
    public static final int OplusOS_12_2 = 25;
    public static final int OplusOS_13_0 = 26;
    public static final int OplusOS_13_1 = 27;

    public static class VERSION {
        public static final String RELEASE = "14.0";
        public static final int SDK_SUB_VERSION = 0;
        public static final int SDK_VERSION = 30;
    }

    public static class OsdkVersionCodes {
        public static final int OS_13_0 = 26;
        public static final int OS_13_1 = 27;
        public static final int OS_13_1_1 = 28;
        public static final int OS_13_2 = 29;
        public static final int OS_14_0 = 30;
        public static final int OS_14_0_1 = 31;
        public static final int OS_14_0_2 = 32;
        public static final int OS_14_1_0 = 33;
        public static final int OS_15_0_0 = 34;
        public static final int OS_15_0_1 = 35;
        public static final int OS_15_0_2 = 36;
        public static final int OS_16_0 = 37;
    }

    public static int getOplusOSVERSION() {
        return VERSION.SDK_VERSION;
    }

    public static int getOsVersion() {
        return VERSION.SDK_VERSION;
    }

    public static String getDeviceName() {
        return Build.MODEL;
    }

    public static String getDeviceName(Context context) {
        return Build.MODEL;
    }

    public static void putDeviceName(Context context, String name) {}
    public static void setDeviceName(Context context, String name) {}
    public static boolean setDeviceName(String name) {
        return true;
    }
}
