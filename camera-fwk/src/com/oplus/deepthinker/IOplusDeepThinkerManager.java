package com.oplus.deepthinker;

import com.oplus.deepthinker.sdk.aidl.proton.deepsleep.TotalPredictResult;
import com.oplus.eventhub.sdk.aidl.EventRequestConfig;
import com.oplus.eventhub.sdk.aidl.IEventCallback;

public interface IOplusDeepThinkerManager {
    TotalPredictResult getDeepSleepTotalPredictResult();
    boolean registerCallback(IEventCallback callback, EventRequestConfig config);
    boolean unregisterCallback(IEventCallback callback);
}
