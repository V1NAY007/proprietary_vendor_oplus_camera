package com.oppo.util;

import com.oplus.util.OplusChineseDateAndSolarDate;

public class OppoChineseDateAndSolarDate {
    public static int[] ChineseDateToSunDate(int year, int month, int day) {
        return OplusChineseDateAndSolarDate.ChineseDateToSunDate(year, month, day);
    }

    public static int GetChLeapMonth(int year) {
        return OplusChineseDateAndSolarDate.GetChLeapMonth(year);
    }

    public static int GetChMonthDays(int year, int month) {
        return OplusChineseDateAndSolarDate.GetChMonthDays(year, month);
    }

    public static int GetSolarMonthDays(int year, int month) {
        return OplusChineseDateAndSolarDate.GetSolarMonthDays(year, month);
    }

    public static int[] SunDateToChineseDate(int year, int month, int day) {
        return OplusChineseDateAndSolarDate.SunDateToChineseDate(year, month, day);
    }
}
