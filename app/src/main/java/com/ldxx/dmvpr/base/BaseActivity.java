package com.ldxx.dmvpr.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ldxx.dmvpr.app.DemoApplication;
import com.ldxx.dmvpr.component.AppComponent;


public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent(DemoApplication.get(this).component());
    }


    protected abstract void setupComponent(AppComponent appComponent);
}
