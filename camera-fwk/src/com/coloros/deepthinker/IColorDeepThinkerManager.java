package com.coloros.deepthinker;

import com.coloros.deepthinker.sdk.aidl.proton.deepsleep.TotalPredictResult;
import com.coloros.eventhub.sdk.aidl.EventRequestConfig;
import com.coloros.eventhub.sdk.aidl.IEventCallback;

public interface IColorDeepThinkerManager {
    TotalPredictResult getDeepSleepTotalPredictResult();
    boolean registerCallback(IEventCallback callback, EventRequestConfig config);
    boolean unregisterCallback(IEventCallback callback);
}
