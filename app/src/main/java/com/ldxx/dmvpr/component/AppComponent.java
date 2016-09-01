package com.ldxx.dmvpr.component;


import android.app.Application;

import com.ldxx.dmvpr.app.DemoApplication;
import com.ldxx.dmvpr.module.AppModule;
import com.ldxx.dmvpr.utils.AppUtils;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(DemoApplication app);

    Application getApplication();

    AppUtils getAppUtils();
}