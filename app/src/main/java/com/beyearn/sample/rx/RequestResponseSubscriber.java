package com.beyearn.sample.rx;


import com.beyearn.sample.bean.JsonResponse;
import com.beyearn.sample.exception.ApiException;
import com.beyearn.sample.utils.L;
import com.orhanobut.logger.Logger;

import rx.Subscriber;

/**
 * RxJava 自定义Subscriber
 * 用于独立请求响应的处理
 * @param <T>
 * @author Hunter
 */
public abstract class RequestResponseSubscriber<T> extends Subscriber<T> {

    public RequestResponseSubscriber() {
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onCompleted() {
    }

    @Override
    public void onError(Throwable e) {
        Logger.e(e.getMessage());
        if (e instanceof ApiException) {
            ApiException apiException = (ApiException) e;

            JsonResponse jsonResponse = apiException.getJsonResponse();

            L.e(jsonResponse.getMessage());

        }
    }
}
