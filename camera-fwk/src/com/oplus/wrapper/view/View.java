package com.oplus.wrapper.view;

public class View {
    private final android.view.View mView;

    public View(android.view.View view) {
        mView = view;
    }

    public ViewRootImpl getViewRootImpl() {
        return mView != null && mView.getViewRootImpl() != null
                ? new ViewRootImpl(mView.getViewRootImpl()) : null;
    }

    public static boolean isVisibleToUser(android.view.View view) {
        return view != null && view.isVisibleToUser();
    }
}
