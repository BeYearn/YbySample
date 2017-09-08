package com.beyearn.sample.app;

/**
 * 全局变量存储类
 *
 * @author Hunter
 */
public class Constants {

    // 数据库名称
    public static final String DATABASE_NAME = "COIN_WALLET";

    public static final String TOKEN_KEY = "X-User-Token";
    public static final String UID_KEY = "X-User-ID";

    public static final int HTTP_TIMEOUT_SECONDS = 60;

    // 城市名称
    public static final int SELECT_CITY_REQ_CODE = 0x01;
    public static final int SELECT_CITY_RES_CODE = 0x02;

    // 滑动变色的最大高度
    public static final int SCROLL = 150;

    // 定位间隔时间
    public static final int LOCATION_INTERVAL = 10000;

    // 收藏类型
    public static final String COLLECTION_TYPE = "collection_type";
    public static final int COLLECTION_PRODUCT = 1;
    public static final int COLLECTION_STORE = 2;

    // 获取相册图片或拍照
    public static final int IMAGE_REQUEST = 0x01;


    //------------------------------------------------

    public static final String DOWNLOAD_SPLASH = "download_splash";
    public static final String SERVICE_TASK = "intent_service_task";

    //动态闪屏序列化地址
    public static String SPLASH_PATH = BaseApplication.getInstance().getFilesDir().getAbsolutePath() + "/alpha/splash";

    public static final String SPLASH_FILE_NAME = "splash.srr";

}
