package com.ldxx.dmvpr.presenter.impl;

import android.util.Log;

import com.ldxx.dmvpr.base.IBaseRequestCallBack;
import com.ldxx.dmvpr.model.MenuListModel;
import com.ldxx.dmvpr.model.bean.MenuList;
import com.ldxx.dmvpr.presenter.MainPresenter;
import com.ldxx.dmvpr.ui.view.MainView;

import java.util.List;

/**
 * Created by wangzhuo-neu
 * on 2016/8/31.
 */

public class MainPresenterImpl implements MainPresenter, IBaseRequestCallBack<List<MenuList>> {
    private static final String TAG = "MainPresenterImpl";
    private MainView mainView;
    private MenuListModel menuListModel;

    public MainPresenterImpl(MainView mainView, MenuListModel menuListModel) {
        this.mainView = mainView;
        this.menuListModel = menuListModel;
    }

    @Override
    public void onResume() {
        mainView.showProgress();
        menuListModel.getMenus(1, this);
    }

    @Override
    public void requestError(Throwable e) {
        Log.e(TAG, "requestError: "+e.getMessage() );
    }

    @Override
    public void requestComplete() {

    }

    @Override
    public void requestSuccess(List<MenuList> callBack) {
        mainView.toast("共查到：" + callBack.size() + "条数据");
        mainView.setItems(callBack);
        mainView.hideProgress();


    }
}
