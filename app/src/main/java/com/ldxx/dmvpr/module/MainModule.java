package com.ldxx.dmvpr.module;

import com.ldxx.dmvpr.model.MenuListModel;
import com.ldxx.dmvpr.presenter.MainPresenter;
import com.ldxx.dmvpr.presenter.impl.MainPresenterImpl;
import com.ldxx.dmvpr.ui.view.MainView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by liaodongxiaoxiao
 * on 2016/9/1.
 */
@Module
public class MainModule {
    private MainView view;

    public MainModule(MainView view) {
        this.view = view;
    }

    @Provides
    public MainView provideView() {
        return view;
    }

    @Provides
    public MainPresenter providePresenter(MainView mainView, MenuListModel menuListModel) {
        return new MainPresenterImpl(mainView, menuListModel);
    }
}
