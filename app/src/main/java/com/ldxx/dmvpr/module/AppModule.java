package com.ldxx.dmvpr.module;

import android.app.Application;

import com.ldxx.dmvpr.app.DemoApplication;

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
}
