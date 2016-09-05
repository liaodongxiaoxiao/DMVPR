package com.ldxx.dmvpr.model.impl;

import com.ldxx.dmvpr.api.MenuApi;
import com.ldxx.dmvpr.base.IBaseRequestCallBack;
import com.ldxx.dmvpr.model.MenuModel;
import com.ldxx.dmvpr.model.bean.MenuDetail;
import com.ldxx.dmvpr.model.bean.MenuList;
import com.ldxx.dmvpr.model.bean.ResultBean;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ldxx on
 * 16/8/31.
 */

public class MenuModelImpl implements MenuModel {
    private MenuApi api;

    @Inject
    public MenuModelImpl(MenuApi api) {
        this.api = api;
    }

    @Override
    public void getMenus(final int page, final IBaseRequestCallBack<List<MenuList>> callBack) {
        api.getMenuList(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ResultBean<List<MenuList>>>() {
                    @Override
                    public void onCompleted() {
                        callBack.requestComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.requestError(e);
                    }

                    @Override
                    public void onNext(ResultBean<List<MenuList>> bean) {
                        if (!bean.getStatus()) {
                            callBack.requestError(new Exception("null"));
                        } else {
                            callBack.requestSuccess(bean.getTngou());
                        }
                    }
                });
    }

    @Override
    public void getDetails(String id, final IBaseRequestCallBack<MenuDetail> callBack) {
        api.getDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MenuDetail>() {
                    @Override
                    public void onCompleted() {
                        callBack.requestComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.requestError(e);
                    }

                    @Override
                    public void onNext(MenuDetail bean) {
                        if (bean == null) {
                            callBack.requestError(new Exception("null"));
                        } else {
                            callBack.requestSuccess(bean);
                        }
                    }
                });
    }
}
