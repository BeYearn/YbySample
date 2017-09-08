package com.beyearn.sample.interfaces.view;


import com.beyearn.sample.base.IBaseView;
import com.beyearn.sample.bean.User;

/**
 * Created by beyearn on 2017/7/26.
 */
public interface GetUserView extends IBaseView {
    void getUserInfo(User user);
}
