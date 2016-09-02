package com.ldxx.dmvpr.module;

import com.ldxx.dmvpr.api.MenuApi;
import com.ldxx.dmvpr.model.MenuListModel;
import com.ldxx.dmvpr.model.impl.MenuListModelImpl;
import com.ldxx.dmvpr.utils.RetrofitManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by liaodongxiaoxiao
 * on 2016/9/1.
 */
@Module
public class MenuListModule {
    private String baseUrl;

    public MenuListModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    public MenuListModel provideMenuListModel(MenuApi api) {
        return new MenuListModelImpl(api);
    }

    @Provides
    public MenuApi provideMyApi(RetrofitManager manager) {
        return manager.getService(MenuApi.class);
    }

    @Provides
    public RetrofitManager provideRetrofitManager() {
        return new RetrofitManager(baseUrl);
    }

}
