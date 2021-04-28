package com.example.woori.main;

import android.os.Bundle;
import android.widget.TextView;

import com.example.woori.R;
import com.example.woori.main.interfaces.MainActivityView;
import com.example.woori.main.model.Body;
import com.example.woori.main.request.DataRequest;
import com.example.woori.main.request.RequestBody;
import com.example.woori.main.request.RequestHeader;
import com.example.woori.src.BaseActivity;

public class MainActivity extends BaseActivity implements MainActivityView {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.main);

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
        textView.setText("계좌 번호 : " + result.getACNO()+ "\n통화 코드 : " +result.getCUCD() + "\n현재 잔액 : "+result.getCT_BAL()
        +"\n개설 일자 : "+result.getNEW_DT());
        showCustomToast(result.getACNO());
    }

    @Override
    public void failure(String msg) {
        showCustomToast(msg);
    }
}