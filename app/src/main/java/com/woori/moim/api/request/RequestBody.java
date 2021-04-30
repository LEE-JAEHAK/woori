package com.woori.moim.api.request;

import com.google.gson.annotations.SerializedName;

public class RequestBody {
    @SerializedName("INQ_ACNO")
    private String INQ_ACNO;
    @SerializedName("INQ_BAS_DT")
    private String INQ_BAS_DT;
    @SerializedName("ACCT_KND")
    private String ACCT_KND;
    @SerializedName("INQ_CUCD")
    private String INQ_CUCD;

    public void setINQ_ACNO(String INQ_ACNO) {
        this.INQ_ACNO = INQ_ACNO;
    }

    public void setINQ_BAS_DT(String INQ_BAS_DT) {
        this.INQ_BAS_DT = INQ_BAS_DT;
    }

    public void setACCT_KND(String ACCT_KND) {
        this.ACCT_KND = ACCT_KND;
    }

    public void setINQ_CUCD(String INQ_CUCD) {
        this.INQ_CUCD = INQ_CUCD;
    }
}
