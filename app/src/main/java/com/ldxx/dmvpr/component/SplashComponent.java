package com.ldxx.dmvpr.component;

import com.ldxx.dmvpr.module.SplashModule;
import com.ldxx.dmvpr.scope.ActivityScope;
import com.ldxx.dmvpr.ui.activity.SplashActivity;

import dagger.Component;

/**
 * Created by liaodongxiaoxiao
 * on 2016/9/5.
 */
@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = {SplashModule.class}
)
public interface SplashComponent {
    void inject(SplashActivity activity);
}
