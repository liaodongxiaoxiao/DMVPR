package com.ldxx.dmvpr.app;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.ldxx.dmvpr.component.AppComponent;
import com.ldxx.dmvpr.component.DaggerAppComponent;
import com.ldxx.dmvpr.module.AppModule;

/**
 * Created by wangzhuo-neu
 * on 2016/8/31.
 */

public class DemoApplication extends Application {
    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        setupGraph();
    }

    private void setupGraph() {
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        component.inject(this);
    }

    public AppComponent component() {
        return component;
    }

    public static DemoApplication get(Context context) {
        return (DemoApplication) context.getApplicationContext();
    }
}
