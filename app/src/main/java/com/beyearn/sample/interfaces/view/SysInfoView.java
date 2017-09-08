package com.beyearn.sample.interfaces.view;


import com.beyearn.sample.bean.SystemInfo;

/**
 * Created by beyearn on 2017/7/20.
 */
public interface SysInfoView extends IBaseView {
    void getSysInfo(SystemInfo systemInfo);
}
