package android.graphics;

public class OplusBaseRenderNode {
    public static final int USAGE_OPLUS_FORCE_UNKNOWN = 8;
    public static final int USAGE_OPLUS_FORCE_BACKGROUND = 9;
    public static final int USAGE_OPLUS_FORCE_FOREGROUND = 10;

    private int mAlgorithmType = 0;
    private int mBackgroundUsageHint = 1;

    public OplusBaseRenderNode() {}

    public int getBackgroundUsageHint() {
        return mBackgroundUsageHint;
    }

    public void setBackgroundUsageHint(int usageHint) {
        mBackgroundUsageHint = usageHint;
    }

    public void setUsageForceDarkAlgorithmType(int algorithmType) {
        mAlgorithmType = algorithmType;
    }
}
