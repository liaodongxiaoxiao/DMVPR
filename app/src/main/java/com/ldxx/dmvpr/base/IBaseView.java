package com.ldxx.dmvpr.base;

/**
 * Created by wangzhuo-neu
 * on 2016/8/29.
 */

public interface IBaseView<T> {
    /**
     * 通过toast提示用户
     *
     * @param msg 提示的信息
     */
    void toast(String msg);

    /**
     * 显示进度
     */
    void showProgress();

    /**
     * 隐藏进度
     */
    void hideProgress();

    /**
     * 基础的请求的返回
     *
     * @param data 返回数据
     */
    void requestSuccess(T data, int tag);

    /**
     * 基础请求的错误
     *
     * @param e 异常信息
     */
    void requestError(Throwable e, int tag);
}
