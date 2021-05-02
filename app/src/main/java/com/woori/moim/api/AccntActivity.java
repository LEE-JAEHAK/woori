package com.woori.moim.api;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.woori.moim.R;
import com.woori.moim.SendActivity;
import com.woori.moim.api.interfaces.MainActivityView;
import com.woori.moim.api.model.Body;
import com.woori.moim.api.request.DataRequest;
import com.woori.moim.api.request.RequestBody;
import com.woori.moim.api.request.RequestHeader;
import com.woori.moim.src.BaseActivity;

public class AccntActivity extends BaseActivity implements MainActivityView {

    TextView textView;
    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accnt);

        button1 = findViewById(R.id.accnt_btn_cert);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomToast("인증되었습니다\n계좌번호 : 10026288*****");
            }
        });

        button2 = findViewById(R.id.accnt_btn_next);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SendActivity.class);
                startActivity(intent);
                finish();
            }
        });

        getData();
    }

    public void getData() {
        RequestBody requestBody = new RequestBody();
        requestBody.setINQ_ACNO("1002123456789");
        requestBody.setINQ_BAS_DT("20210220");
        requestBody.setACCT_KND("P");
        requestBody.setINQ_CUCD("KRW");

        RequestHeader requestHeader = new RequestHeader();
        requestHeader.setUTZ_MCHR_APP_VER_NM("");
        requestHeader.setUTZ_MCHR_MDL_NM("");
        requestHeader.setUTZ_MCHR_OS_DSCD("");
        requestHeader.setUTZ_MCHR_OS_VER_NM("");
        requestHeader.setUTZPE_CNCT_IPAD("");
        requestHeader.setUTZPE_CNCT_MCHR_IDF_SRNO("");
        requestHeader.setUTZPE_CNCT_MCHR_UNQ_ID("");
        requestHeader.setUTZPE_CNCT_TEL_NO_TXT("");

        DataRequest dataRequest = new DataRequest();
        dataRequest.setRequestBodies(requestBody);
        dataRequest.setRequestHeaders(requestHeader);

        final MainService service = new MainService(this, this);
        service.postData(dataRequest);

    }

    @Override
    public void success(Body result) {
    }

    @Override
    public void failure(String msg) {
        showCustomToast(msg);
    }
}