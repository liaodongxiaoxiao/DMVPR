package com.ldxx.dmvpr.module;

import android.content.Context;

import com.ldxx.dmvpr.api.MenuApi;
import com.ldxx.dmvpr.model.MenuModel;
import com.ldxx.dmvpr.model.impl.MenuModelImpl;
import com.ldxx.dmvpr.utils.RetrofitManager;

import dagger.Module;
import dagger.Provides;

/**
 * Created by liaodongxiaoxiao
 * on 2016/9/1.
 */
@Module
public class MenuListModule {
    private Context context;

    public MenuListModule(Context context) {
        this.context = context;
    }

    @Provides
    MenuModel provideMenuListModel(MenuApi api) {
        return new MenuModelImpl(api);
    }

    @Provides
    MenuApi provideMyApi(RetrofitManager manager) {
        return manager.getService(MenuApi.class);
    }

    @Provides
    RetrofitManager provideRetrofitManager() {
        return new RetrofitManager(context);
    }

}
