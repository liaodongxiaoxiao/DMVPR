package com.ldxx.dmvpr.api;

import com.ldxx.dmvpr.model.bean.MenuList;

import java.util.List;

import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by wangzhuo-neu on
 * 2016/8/31.
 */

public interface MenuApi {
    @Headers({
            "Content-type: application/json", "apikey: d6e91c2b841ef37858964106aa83749c"
    })

    @GET("/cook/list")
    public void getPets(Callback<List<MenuList>> callback);
}
