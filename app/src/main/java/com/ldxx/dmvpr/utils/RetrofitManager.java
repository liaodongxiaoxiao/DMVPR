package com.ldxx.dmvpr.utils;

import android.content.Context;

import com.ldxx.dmvpr.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
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

    public RetrofitManager(Context context) {
        initOkHttpClient(context);

        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_HOST)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private void initOkHttpClient(Context context) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (mOkHttpClient == null) {
            synchronized (RetrofitManager.class) {
                if (mOkHttpClient == null) {

                    mOkHttpClient = new OkHttpClient.Builder()
                            .cache(new Cache(context.getCacheDir(), 1024 * 200))
                            .addNetworkInterceptor(new CacheInterceptor())
                            .addInterceptor(interceptor)
                            .retryOnConnectionFailure(true)
                            .connectTimeout(20, TimeUnit.SECONDS)
                            .readTimeout(20, TimeUnit.SECONDS)
                            .writeTimeout(30, TimeUnit.SECONDS)
                            .build();
                }
            }
        }
    }

    public <T> T getService(Class<T> clazz) {
        return retrofit.create(clazz);
    }

}
