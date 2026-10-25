package com.oplus.util;

import android.content.Context;
import android.text.format.Formatter;

public class OplusUnitConversionUtils {
    private final Context mContext;

    public OplusUnitConversionUtils(Context context) {
        mContext = context;
    }

    public String getUnitValue(long bytes) {
        if (mContext != null) {
            return Formatter.formatFileSize(mContext, bytes);
        }
        return String.valueOf(bytes);
    }
}
