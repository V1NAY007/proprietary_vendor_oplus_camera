package android.widget;

import android.content.Context;
import android.util.AttributeSet;

public class ColorResolverGallery extends RelativeLayout {
    public interface OnColorGalleryScrollListener {
        void onScroll();
    }

    public ColorResolverGallery(Context context) {
        super(context);
    }

    public ColorResolverGallery(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setAdapter(SpinnerAdapter adapter) {}
    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {}
    public void setOnScrollListener(OnColorGalleryScrollListener listener) {}
    public void setSelection(int position) {}
    public void setSpacing(int spacing) {}
}
