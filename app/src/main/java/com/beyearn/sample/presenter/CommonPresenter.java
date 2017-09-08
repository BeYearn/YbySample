package com.beyearn.sample.presenter;

import android.util.Log;

import com.beyearn.sample.api.CommonApi;
import com.beyearn.sample.base.BasePresenter;
import com.beyearn.sample.bean.SystemInfo;
import com.beyearn.sample.bean.User;
import com.beyearn.sample.interfaces.view.GetUserView;
import com.beyearn.sample.interfaces.view.SysInfoView;
import com.beyearn.sample.rx.ViewResponseSubscriber;

import rx.Observable;
import rx.Subscriber;


/**
 * Created by beyearn on 2017/7/20.
 * 可分类的   这是commonPresenter(公用的) 还可能是 xxxxxPresenter
 */
public class CommonPresenter extends BasePresenter {
    private CommonApi commonApi;

    @Override
    protected void initService() {
        commonApi = getService(CommonApi.class);
    }


    public void getSysInfo(final SysInfoView view, String appid, String channelId, String channelTag, String deviceId, final String sign) {
        subscribe(view, convertResponse(commonApi.getSysInfo(appid, channelId, channelTag, deviceId, sign)), new ViewResponseSubscriber<SystemInfo>(view, true) {
            @Override
            public void onNext(SystemInfo systemInfo) {
                Log.e("dd", systemInfo.toString());
                view.getSysInfo(systemInfo);
            }
        });
    }

    public void getUserInfo(final GetUserView view, final String name) {
        subscribe(view, Observable.create(new Observable.OnSubscribe<User>() {
            @Override
            public void call(Subscriber<? super User> subscriber) {
                User user = new User();
                user.setId(8888888L);
                user.setUserName(name);
                user.setUserSex("man");
                user.setUserToken("abcdefg");
                subscriber.onNext(user);
            }
        }), new ViewResponseSubscriber<User>(view, true) {
            @Override
            public void onNext(User user) {
                view.getUserInfo(user);
            }
        });
    }

}
