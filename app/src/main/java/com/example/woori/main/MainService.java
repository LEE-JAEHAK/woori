package com.example.woori.main;

import android.content.Context;

import androidx.annotation.NonNull;

import com.example.woori.main.interfaces.MainActivityView;
import com.example.woori.main.interfaces.MainInterface;
import com.example.woori.main.model.DataResponse;
import com.example.woori.main.request.DataRequest;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.woori.src.ApplicationClass.getRetrofit;


public class MainService {

    Context mContext;
    private MainActivityView mView;

    public MainService(final MainActivityView view, Context context) {
        this.mView = view;
        this.mContext = context;
    }

    // 계좌 조회
    public void postData(DataRequest dataRequest) {
        final MainInterface mainInterface = getRetrofit().create(MainInterface.class);
        mainInterface.postData(dataRequest).enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                final DataResponse dataResponse = response.body();
                if (dataResponse == null) {
                    mView.failure("빈 값");
                    return;
                }
                mView.success(dataResponse.getBody());
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                mView.failure("서버 연결 실패");
            }
        });
    }
}
