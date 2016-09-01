package com.ldxx.dmvpr.module;

import android.app.Application;
import android.content.Context;

import com.ldxx.dmvpr.app.DemoApplication;
import com.ldxx.dmvpr.utils.AppUtils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private DemoApplication application;

    public AppModule(DemoApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    public AppUtils provideAppUtils() {
        return new AppUtils(application);
    }
}
