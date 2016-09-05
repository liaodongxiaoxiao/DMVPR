package com.ldxx.dmvpr.component;

import com.ldxx.dmvpr.model.MenuModel;
import com.ldxx.dmvpr.module.DetailModel;
import com.ldxx.dmvpr.module.MenuListModule;
import com.ldxx.dmvpr.presenter.DetailPresenter;
import com.ldxx.dmvpr.scope.ActivityScope;
import com.ldxx.dmvpr.ui.activity.DetailActivity;

import dagger.Component;

/**
 * Created by liaodongxiaoxiao on 2016/9/5.
 */
@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = {DetailModel.class, MenuListModule.class}
)
public interface DetailComponent {
    void inject(DetailActivity activity);

    DetailPresenter getDetailPresenter();

    MenuModel MenuListModel();
}
