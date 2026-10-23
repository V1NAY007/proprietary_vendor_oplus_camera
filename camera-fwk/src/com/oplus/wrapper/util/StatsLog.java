package com.oplus.wrapper.util;

public class StatsLog {
    public static void write(StatsEvent event) {
        if (event != null && event.getStatsEvent() != null) {
            try {
                android.util.StatsLog.write(event.getStatsEvent());
            } catch (Throwable ignored) {
            }
        }
    }
}
