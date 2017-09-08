package com.beyearn.sample.interfaces;

/**
 * Created by beyearn on 2017/9/1.
 */

public interface RequestResponse<T> {
    public void onCallBack(T t);
}
