package com.ldxx.dmvpr.model;

import com.ldxx.dmvpr.base.IBaseRequestCallBack;
import com.ldxx.dmvpr.model.bean.MenuList;

import java.util.List;

/**
 * Created by wangzhuo-neu
 * on 2016/8/31.
 */

public interface MenuListModel {
    void getMenus(IBaseRequestCallBack<List<MenuList>> callBack);
}
