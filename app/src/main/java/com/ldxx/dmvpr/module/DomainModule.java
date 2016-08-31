package com.ldxx.dmvpr.module;

import com.ldxx.dmvpr.app.DemoApplication;
import com.ldxx.dmvpr.utils.RetrofitManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DomainModule {


    @Provides
    @Singleton public RetrofitManager provideAnalyticsManager(DemoApplication app){
        return new RetrofitManager(app);
    }

}