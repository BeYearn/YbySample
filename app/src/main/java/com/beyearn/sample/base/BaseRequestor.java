package com.beyearn.sample.base;


import com.beyearn.sample.app.ApiManager;
import com.beyearn.sample.bean.JsonResponse;
import com.beyearn.sample.rx.JsonResponseFunc;

import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Created by beyearn on 2017/9/1.
 * 单独的网络请求
 * 对应于 BasePresenter
 */

public abstract class BaseRequestor {

    public BaseRequestor() {
        initService();
    }

    protected abstract void initService();

    public <T> T getService(Class<T> clazz) {
        ApiManager apiManager = ApiManager.getInstance();
        return apiManager.getService(clazz);
    }

    /**
     * 转换响应实体的类型
     *
     * @param observable
     * @param <T>
     * @return
     */
    public <T> Observable<T> convertResponse(Observable<JsonResponse<T>> observable) {
        return observable.map(new JsonResponseFunc<T>());
    }

    /**
     * 绑定请求和响应
     *
     * @param observable
     * @param subscriber
     * @param <T>
     */
    public <T> void sycSubscribe(Observable<T> observable, Subscriber<T> subscriber) {
        observable
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(subscriber);
    }



}
