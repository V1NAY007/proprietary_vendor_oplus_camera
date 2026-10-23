package com.oplus.wrapper.view;

import android.graphics.Rect;
import android.graphics.Region;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ViewTreeObserver {

    public interface OnComputeInternalInsetsListener {
        void onComputeInternalInsets(InternalInsetsInfo inoutInfo);
    }

    public static final class InternalInsetsInfo {
        public static final int TOUCHABLE_INSETS_FRAME = 0;
        public static final int TOUCHABLE_INSETS_CONTENT = 1;
        public static final int TOUCHABLE_INSETS_VISIBLE = 2;
        public static final int TOUCHABLE_INSETS_REGION = 3;

        private final android.view.ViewTreeObserver.InternalInsetsInfo mInternalInsetsInfo;

        public InternalInsetsInfo(android.view.ViewTreeObserver.InternalInsetsInfo internalInsetsInfo) {
            mInternalInsetsInfo = internalInsetsInfo;
        }

        public void setTouchableInsets(int val) {
            if (mInternalInsetsInfo != null) {
                mInternalInsetsInfo.setTouchableInsets(val);
            }
        }

        public Region getTouchableRegion() {
            return mInternalInsetsInfo != null ? mInternalInsetsInfo.touchableRegion : new Region();
        }

        public Rect getContentInsets() {
            return mInternalInsetsInfo != null ? mInternalInsetsInfo.contentInsets : new Rect();
        }

        public Rect getVisibleInsets() {
            return mInternalInsetsInfo != null ? mInternalInsetsInfo.visibleInsets : new Rect();
        }
    }

    private final android.view.ViewTreeObserver mViewTreeObserver;
    private final Map<OnComputeInternalInsetsListener, android.view.ViewTreeObserver.OnComputeInternalInsetsListener> mListenerMap =
            new ConcurrentHashMap<>();

    public ViewTreeObserver(android.view.ViewTreeObserver viewTreeObserver) {
        mViewTreeObserver = viewTreeObserver;
    }

    public void addOnComputeInternalInsetsListener(OnComputeInternalInsetsListener listener) {
        if (mViewTreeObserver == null || listener == null) {
            return;
        }
        android.view.ViewTreeObserver.OnComputeInternalInsetsListener proxy =
                inoutInfo -> listener.onComputeInternalInsets(new InternalInsetsInfo(inoutInfo));
        mListenerMap.put(listener, proxy);
        mViewTreeObserver.addOnComputeInternalInsetsListener(proxy);
    }

    public void removeOnComputeInternalInsetsListener(OnComputeInternalInsetsListener listener) {
        if (mViewTreeObserver == null || listener == null) {
            return;
        }
        android.view.ViewTreeObserver.OnComputeInternalInsetsListener proxy = mListenerMap.remove(listener);
        if (proxy != null) {
            mViewTreeObserver.removeOnComputeInternalInsetsListener(proxy);
        }
    }
}
