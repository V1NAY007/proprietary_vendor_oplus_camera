package com.oplus.ocs.camera;

import com.oplus.camera.combinelut.CombineLutJNI;

public class CombineLutHelper {
    private CombineLutJNI mCombineLutJNI;

    public CombineLutHelper() {
        this.mCombineLutJNI = new CombineLutJNI();
    }

    public String getVersion() {
        return this.mCombineLutJNI.getVersion();
    }

    public int init(String str, String str2, String str3, int i) {
        return this.mCombineLutJNI.init(str, str2, str3, i);
    }

    public int init(String str, String str2, String str3, int i, int i2) {
        return this.mCombineLutJNI.initV2(str, str2, str3, i, i2);
    }

    public float[] process(int i, int i2, int i3, int i4, int[] iArr) {
        return this.mCombineLutJNI.process(i, i2, i3, i4, iArr);
    }

    public float[] process(int i, int i2, int i3, int i4, float f, float f2, float f3, int[] iArr) {
        return this.mCombineLutJNI.processV2(i, i2, i3, i4, f, f2, f3, iArr);
    }

    public float[] process(int i, int i2, int i3, int i4, float f, float f2, float f3, int[] iArr, int i5) {
        return this.mCombineLutJNI.processV3(i, i2, i3, i4, f, f2, f3, iArr, i5);
    }

    public float[] process(int i, int i2, int i3, int i4, float f, float f2, float f3, String[] strArr, int[] iArr) {
        return this.mCombineLutJNI.processV3(i, i2, i3, i4, f, f2, f3, strArr, iArr);
    }

    public void release() {
        this.mCombineLutJNI.release();
    }
}
