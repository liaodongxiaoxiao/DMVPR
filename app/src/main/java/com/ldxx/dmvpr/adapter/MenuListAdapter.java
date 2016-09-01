package com.ldxx.dmvpr.adapter;

import android.net.Uri;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ldxx.dmvpr.BuildConfig;
import com.ldxx.dmvpr.R;
import com.ldxx.dmvpr.model.bean.MenuList;

import java.util.List;

/**
 * Created by wangzhuo-neu
 * on 2016/9/1.
 */

public class MenuListAdapter  extends BaseQuickAdapter<MenuList> {
    public MenuListAdapter(List<MenuList> data) {
        super(R.layout.item_menu_list,data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, MenuList menuList) {
        baseViewHolder.setText(R.id.menu_name,menuList.getName())
                .setText(R.id.menu_description,menuList.getDescription())
                .setText(R.id.menu_keywords,menuList.getKeywords());
        setImageUri(baseViewHolder,R.id.menu_img,menuList.getImg());
    }

    private void setImageUri(BaseViewHolder holder,int viewId, String url) {
        Uri uri = Uri.parse(BuildConfig.BASE_HOST+url);
        SimpleDraweeView view = holder.getView(viewId);
        view.setImageURI(uri);
    }
}
