package com.ldxx.dmvpr.utils;


import com.ldxx.dmvpr.app.DemoApplication;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit管理类
 */
public class RetrofitManager {

    private OkHttpClient mOkHttpClient;

    private Retrofit retrofit;


    public RetrofitManager(DemoApplication app) {
        initOkHttpClient();

        retrofit = new Retrofit.Builder()
                .baseUrl(AppUtils.getBaseUrl(app))
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private void initOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (mOkHttpClient == null) {
            synchronized (RetrofitManager.class) {
                if (mOkHttpClient == null) {

                    mOkHttpClient = new OkHttpClient.Builder()
                            //.cache(cache)
                            //.addInterceptor(mRewriteCacheControlInterceptor)
                            //.addNetworkInterceptor(mRewriteCacheControlInterceptor)
                            .addInterceptor(interceptor)
                            //.addNetworkInterceptor(new StethoInterceptor())
                            .retryOnConnectionFailure(true)
                            .connectTimeout(15, TimeUnit.SECONDS)
                            .build();
                }
            }
        }
    }

    public <T> T getService(Class<T> clazz) {
        return retrofit.create(clazz);
    }

}
