package android.os;

public class PerformanceManager {
    public static void enableMultiThreadOptimize() {}
    public static void disableMultiThreadOptimize() {}
    public static String getCpuLoading() {
        return "";
    }
    public static String getHICpuLoading() {
        return "";
    }
    public static String readJankCpuInfo() {
        return "";
    }
    public static Object readMemoryByPids(int[] pids, int flags) {
        return null;
    }
}
