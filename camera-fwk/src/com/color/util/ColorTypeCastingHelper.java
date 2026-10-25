package com.color.util;

import com.oplus.util.OplusTypeCastingHelper;

public final class ColorTypeCastingHelper {
    public static <T> T typeCasting(Class<T> type, Object object) {
        return OplusTypeCastingHelper.typeCasting(type, object);
    }
}
