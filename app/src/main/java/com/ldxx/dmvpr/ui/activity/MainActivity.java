package com.ldxx.dmvpr.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ldxx.dmvpr.R;
import com.ldxx.dmvpr.model.bean.MenuList;
import com.ldxx.dmvpr.ui.view.MainView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void setItems(List<MenuList> items) {

    }

    @Override
    public void toast(String msg) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void requestSuccess(Object data, int tag) {

    }

    @Override
    public void requestError(Throwable e, int tag) {

    }
}
