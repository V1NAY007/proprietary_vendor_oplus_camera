package com.oplus.uah.info;

import java.util.ArrayList;

public class UAHEventRequest {
    public UAHEventRequest() {}
    public UAHEventRequest(int a, String b, int c, ArrayList<?> d) {}
    public UAHEventRequest(int a, String b, int c, int d) {}
    public UAHEventRequest(int a, String b, int c) {}
    public UAHEventRequest(int a, int b) {}

    public int acquireEvent(UAHEventRequest request) {
        return 0;
    }
}
