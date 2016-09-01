package com.ldxx.dmvpr.model.bean;

import java.util.List;

/**
 * Created by wangzhuo-neu
 * on 2016/9/1.
 */

public class ResultBean<T> {

    /**
     * status : true
     * total : 101254
     * tngou : []
     */

    private boolean status;
    private int total;
    private T tngou;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public T getTngou() {
        return tngou;
    }

    public void setTngou(T tngou) {
        this.tngou = tngou;
    }
}
