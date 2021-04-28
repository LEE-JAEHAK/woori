package com.example.woori.main.request;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DataRequest {

    @SerializedName("dataHeader")
    private RequestHeader RequestHeaders;

    @SerializedName("dataBody")
    private RequestBody requestBodies;

    public void setRequestHeaders(RequestHeader RequestHeaders) {
        this.RequestHeaders = RequestHeaders;
    }

    public void setRequestBodies(RequestBody requestBodies) {
        this.requestBodies = requestBodies;
    }
}
