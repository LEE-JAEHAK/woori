package com.example.woori.main.interfaces;

import com.example.woori.main.model.Body;

import java.util.ArrayList;

public interface MainActivityView {

    void success(Body result);
    void failure(String msg);

}
