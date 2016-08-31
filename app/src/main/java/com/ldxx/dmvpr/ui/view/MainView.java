package com.ldxx.dmvpr.ui.view;

import com.ldxx.dmvpr.base.IBaseView;
import com.ldxx.dmvpr.model.bean.MenuList;

import java.util.List;

/**
 * Created by wangzhuo-neu on
 * 2016/8/31.
 */

public interface MainView extends IBaseView {
    
    void setItems(List<MenuList> items);
}
