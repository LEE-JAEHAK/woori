package com.example.woori.main.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DataResponse {

    @SerializedName("dataHeader")
    private Header headers;

    @SerializedName("dataBody")
    private Body bodies;


    public Header getHeader() {
        return headers;
    }

    public Body getBody() {
        return bodies;
    }

}
