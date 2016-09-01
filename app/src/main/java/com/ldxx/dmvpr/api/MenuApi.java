package com.ldxx.dmvpr.api;

import com.ldxx.dmvpr.model.bean.MenuList;
import com.ldxx.dmvpr.model.bean.ResultBean;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by wangzhuo-neu on
 * 2016/8/31.
 */

public interface MenuApi {
    @Headers({
            "Content-type: application/json", "apikey: d6e91c2b841ef37858964106aa83749c"
    })

    //"id=0&page=1&rows=20
    @GET("/tngou/cook/list?id=0&rows=10")
    Observable<ResultBean<List<MenuList>>> getMenuList(@Query("page") int page);
}
