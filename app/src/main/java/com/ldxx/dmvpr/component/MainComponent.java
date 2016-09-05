package com.ldxx.dmvpr.component;

import com.ldxx.dmvpr.model.MenuModel;
import com.ldxx.dmvpr.module.MainModule;
import com.ldxx.dmvpr.module.MenuListModule;
import com.ldxx.dmvpr.presenter.MainPresenter;
import com.ldxx.dmvpr.scope.ActivityScope;
import com.ldxx.dmvpr.ui.activity.MainActivity;

import dagger.Component;

/**
 * Created by ldxx
 * on 16/8/31.
 */
@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = {MainModule.class, MenuListModule.class}
)
public interface MainComponent {
    void inject(MainActivity activity);

    MainPresenter getMainPresenter();

    MenuModel MenuListModel();
}
