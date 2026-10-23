package com.oplus.wrapper.content.res;

import com.oplus.wrapper.app.WindowConfiguration;

public class Configuration {
    private final android.content.res.Configuration mConfiguration;

    public Configuration(android.content.res.Configuration configuration) {
        mConfiguration = configuration;
    }

    public WindowConfiguration getWindowConfiguration() {
        return mConfiguration != null ? new WindowConfiguration(mConfiguration.windowConfiguration) : null;
    }

    public static Object getOplusExtraConfiguration(android.content.res.Configuration configuration) {
        return new oplus.content.res.OplusExtraConfiguration();
    }
}
