package com.ldxx.dmvpr.presenter.impl;

import com.ldxx.dmvpr.base.IBaseRequestCallBack;
import com.ldxx.dmvpr.model.MenuModel;
import com.ldxx.dmvpr.model.bean.MenuList;
import com.ldxx.dmvpr.presenter.MainPresenter;
import com.ldxx.dmvpr.ui.view.MainView;

import java.util.List;

/**
 * Created by liaodongxiaoxiao
 * on 2016/8/31.
 */

public class MainPresenterImpl implements MainPresenter, IBaseRequestCallBack<List<MenuList>> {
    private static final String TAG = "MainPresenterImpl";
    private MainView mainView;
    private MenuModel menuListModel;

    public MainPresenterImpl(MainView mainView, MenuModel menuListModel) {
        this.mainView = mainView;
        this.menuListModel = menuListModel;
    }

    @Override
    public void getMenuList(int page) {
        if (page == 1) {
            mainView.showProgress();
        }
        menuListModel.getMenus(page, this);
    }

    @Override
    public void requestError(Throwable e) {

    }

    @Override
    public void requestComplete() {

    }

    @Override
    public void requestSuccess(List<MenuList> callBack) {
        mainView.setItems(callBack);
        mainView.hideProgress();
    }
}
