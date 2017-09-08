package com.beyearn.sample.api;


import com.beyearn.sample.app.URLs;
import com.beyearn.sample.bean.JsonResponse;
import com.beyearn.sample.bean.Splash;
import com.beyearn.sample.bean.SystemInfo;

import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;


/**
 * Created by Administrator on 2017/5/26.
 */

public interface CommonApi {

    /**
     *获取systemInfo
     */
    @POST(URLs.SYSTEM_INFO)
    Observable<JsonResponse<SystemInfo>> getSysInfo(@Query("appId") String appId,
                                                    @Query("channelId") String channelId,
                                                    @Query("channelTag") String channelTag,
                                                    @Query("deviceId") String deviceId,
                                                    @Query("sign") String sign);

    /**
     * 获取splash闪屏信息
     */
    @POST(URLs.SPLASH_INFO)
    Observable<JsonResponse<Splash>> getSplashInfo(@Query("xxx1") String xxx1,
                                                   @Query("xxx2") String xxx2);

}
