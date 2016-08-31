package com.ldxx.dmvpr.presenter.impl;

import com.ldxx.dmvpr.base.IBaseRequestCallBack;
import com.ldxx.dmvpr.model.bean.MenuList;
import com.ldxx.dmvpr.presenter.MainPresenter;

import java.util.List;

/**
 * Created by wangzhuo-neu
 * on 2016/8/31.
 */

public class MainPresenterImpl implements MainPresenter, IBaseRequestCallBack<List<MenuList>> {

    @Override
    public void onResume() {

    }

    @Override
    public void requestError(Throwable e) {

    }

    @Override
    public void requestComplete() {

    }

    @Override
    public void requestSuccess(List<MenuList> callBack) {

    }
}
