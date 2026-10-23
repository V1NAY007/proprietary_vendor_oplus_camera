package com.oplus.ocrclient;

import android.content.Context;

public class OcrClient {
    private static final OcrClient sInstance = new OcrClient();

    public static OcrClient getInstance() {
        return sInstance;
    }

    public void init(Context context) {}
    public int getAllowedEngineTypes() { return 0; }
    public void setAllowedEngineTypes(int types) {}
}
