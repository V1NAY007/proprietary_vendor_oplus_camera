package android.widget;

import android.content.Context;
import android.util.AttributeSet;

public class OplusResolverGallery extends RelativeLayout {
    public interface OnGalleryScrollListener {
        void onScroll();
    }

    public OplusResolverGallery(Context context) {
        super(context);
    }

    public OplusResolverGallery(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setAdapter(SpinnerAdapter adapter) {}
    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {}
    public void setOnScrollListener(OnGalleryScrollListener listener) {}
    public void setSelection(int position) {}
    public void setSpacing(int spacing) {}
}
