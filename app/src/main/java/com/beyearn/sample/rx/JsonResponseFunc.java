package com.beyearn.sample.rx;


import com.beyearn.sample.bean.JsonResponse;
import com.beyearn.sample.exception.ApiException;

import rx.functions.Func1;

/**
 * RxJava map转换
 *
 * @param <T>
 * @author Hunter
 */
public class JsonResponseFunc<T> implements Func1<JsonResponse<T>, T> {
    @Override
    public T call(JsonResponse<T> tJsonResponse) {
        if (tJsonResponse == null) return null;

        T data = tJsonResponse.getData();
        if (data == null) return null;

        if (!tJsonResponse.getStatus().equals(JsonResponse.SUCCESS)) {
            //抛出个自定义的ApiException。这样就会进入到subscriber的onError中，可以在onError中处理错误信息
            throw new ApiException(tJsonResponse);
        }

        return data;
    }
}
