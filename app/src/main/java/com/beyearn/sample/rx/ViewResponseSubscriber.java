package com.beyearn.sample.rx;


import com.beyearn.sample.base.IBaseView;
import com.beyearn.sample.bean.JsonResponse;
import com.beyearn.sample.exception.ApiException;
import com.orhanobut.logger.Logger;

import rx.Subscriber;

/**
 * RxJava 自定义Subscriber
 * 用于activity和fragment的响应处理
 * @param <T>
 * @author Hunter
 */
public abstract class ViewResponseSubscriber<T> extends Subscriber<T> {
    private static final String TAG = "ViewResponseSubscriber";
    private IBaseView mBaseView;
    // 是否显示加载进度条
    private boolean mIsShowLoading = true;

    public ViewResponseSubscriber(IBaseView baseView) {
        mBaseView = baseView;
    }

    public ViewResponseSubscriber(IBaseView baseView, boolean isShowLoading) {
        mBaseView = baseView;
        mIsShowLoading = isShowLoading;
    }

    @Override
    public void onStart() {
        if (mIsShowLoading) mBaseView.showProgress("少年别着急...");
    }

    @Override
    public void onCompleted() {
        mBaseView.hideProgress();
    }

    @Override
    public void onError(Throwable e) {
        mBaseView.hideProgress();
        Logger.e(e.getMessage());
        if (e instanceof ApiException) {
            ApiException apiException = (ApiException) e;

            JsonResponse jsonResponse = apiException.getJsonResponse();

            mBaseView.showToast(jsonResponse.getMessage());

        }
    }
}
