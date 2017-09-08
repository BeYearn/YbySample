package com.beyearn.sample.presenter.http;


import com.beyearn.sample.api.CommonApi;
import com.beyearn.sample.base.BaseRequestor;
import com.beyearn.sample.bean.Splash;
import com.beyearn.sample.interfaces.RequestResponse;
import com.beyearn.sample.rx.RequestResponseSubscriber;

/**
 * Created by beyearn on 2017/9/1.
 */

public class CommonRequestor extends BaseRequestor {
    private CommonApi commonApi;

    @Override
    protected void initService() {
        commonApi = getService(CommonApi.class);
    }

    public void getSplashInfo(final RequestResponse<Splash> response, String appid, String channelId) {
        sycSubscribe(convertResponse(commonApi.getSplashInfo(appid, channelId)), new RequestResponseSubscriber<Splash>() {
            @Override
            public void onNext(Splash splash) {
                response.onCallBack(splash);
            }
        });
    }
}
