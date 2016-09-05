package com.ldxx.dmvpr.module;

import com.ldxx.dmvpr.model.MenuModel;
import com.ldxx.dmvpr.presenter.DetailPresenter;
import com.ldxx.dmvpr.presenter.impl.DetailPresenterImpl;
import com.ldxx.dmvpr.ui.view.DetailView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by liaodongxiaoxiao
 * on 2016/9/5.
 */
@Module
public class DetailModel {
    private DetailView detailView;

    public DetailModel(DetailView detailView) {
        this.detailView = detailView;
    }

    @Provides
    public DetailView provideDetailView(){
        return detailView;
    }

    @Provides
    public DetailPresenter provideDetailPresenter(DetailView detailView, MenuModel menuModel){
        return new DetailPresenterImpl(detailView,menuModel);
    }
}
