package com.oplus.log;

import android.content.Context;
import com.oplus.log.uploader.IHttpDelegate;
import com.oplus.log.uploader.UploadManager;

public class Logger {
    public static class Builder {
        public Builder withHttpDelegate(IHttpDelegate delegate) { return this; }
        public Builder logFilePath(String path) { return this; }
        public Builder mmapCacheDir(String dir) { return this; }
        public Builder fileLogLevel(int level) { return this; }
        public Builder consoleLogLevel(int level) { return this; }
        public Builder fileExpireDays(int days) { return this; }
        public Builder setTracePkg(String pkg) { return this; }
        public Builder setImeiProvider(Settings.IImeiProvider provider) { return this; }
        public Builder setOpenIdProvider(Settings.IOpenIdProvider provider) { return this; }
        public Builder setProcessName(String name) { return this; }
        public Logger create(Context context) { return new Logger(); }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public void setUploaderListener(UploadManager.UploaderListener listener) {}

    public void checkUpload(String s1, String s2, UploadManager.UploadCheckerListener listener) {}

    public ISimpleLog getSimpleLog() {
        return new ISimpleLog() {
            @Override
            public void d(String tag, String msg) {}
        };
    }
}
