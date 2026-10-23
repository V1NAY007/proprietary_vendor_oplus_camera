package com.oplus.osense.eventinfo;

public abstract class OsenseEventCallback {
    public OsenseEventCallback() {}
    public void onEvent(OsenseEventResult result) {}
    public void onEventSceneChanged(OsenseEventResult result) {}
}

