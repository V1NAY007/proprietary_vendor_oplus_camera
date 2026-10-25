package com.oplus.util;

public class OplusChineseDateAndSolarDate {
    public static int[] ChineseDateToSunDate(int year, int month, int day) {
        return new int[]{year, month, day};
    }

    public static int GetChLeapMonth(int year) {
        return 0;
    }

    public static int GetChMonthDays(int year, int month) {
        return 30;
    }

    public static int GetSolarMonthDays(int year, int month) {
        return 30;
    }

    public static int[] SunDateToChineseDate(int year, int month, int day) {
        return new int[]{year, month, day};
    }
}
