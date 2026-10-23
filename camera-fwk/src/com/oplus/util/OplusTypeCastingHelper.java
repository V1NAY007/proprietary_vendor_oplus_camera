package com.oplus.util;

public final class OplusTypeCastingHelper {
    @SuppressWarnings("unchecked")
    public static <T> T typeCasting(Class<T> type, Object object) {
        if (object != null && type != null && type.isInstance(object)) {
            return (T) object;
        }
        if (type == android.content.res.OplusBaseConfiguration.class) {
            return (T) new android.content.res.OplusBaseConfiguration();
        }
        return null;
    }
}

