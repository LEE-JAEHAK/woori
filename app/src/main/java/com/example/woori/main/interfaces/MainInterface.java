package com.example.woori.main.interfaces;

import com.example.woori.main.model.DataResponse;
import com.example.woori.main.request.DataRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MainInterface {

    @POST("/oai/wb/v1/finance/getAccBasicInfo")
    Call<DataResponse> postData(@Body DataRequest dataRequest);

}
