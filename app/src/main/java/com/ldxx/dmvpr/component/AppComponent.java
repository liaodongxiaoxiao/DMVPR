package com.ldxx.dmvpr.component;


import com.ldxx.dmvpr.app.DemoApplication;
import com.ldxx.dmvpr.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                AppModule.class
        }
)
public interface AppComponent {
    void inject(DemoApplication app);
}