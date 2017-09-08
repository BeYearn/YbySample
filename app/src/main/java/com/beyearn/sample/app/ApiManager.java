package com.beyearn.sample.app;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit Service管理器
 *
 * @author Hunter
 */
public class ApiManager {
    private Retrofit retrofit;
    private static ApiManager instance;

    private ApiManager() {

    }

    public static ApiManager getInstance() {
        if (instance == null) {
            instance = new ApiManager();
        }

        return instance;
    }

    public <T> T getService(Class<T> t) {
        return getService(URLs.BASE_URL, t);        //Retrofit2 的baseUlr必须以 / 结束，不然会抛出一个IllegalArgumentException
    }

    public <T> T getService(String baseUrl, Class<T> t) {
        if(retrofit == null){
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);          //不设置的话默认是NONE 不打印

            OkHttpClient.Builder builder = new OkHttpClient.Builder()
                    .connectTimeout(Constants.HTTP_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                    .readTimeout(Constants.HTTP_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                    .writeTimeout(Constants.HTTP_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request request = chain.request();
                            Request.Builder newBuilder = request.newBuilder();

                            UserManager userManager = UserManager.getInstance();
                            if(userManager.isLogin()){
                                newBuilder.addHeader(Constants.TOKEN_KEY, userManager.getCurrentUserToken())
                                        .addHeader(Constants.UID_KEY, userManager.getCurrentUserID());
                            }

                            return chain.proceed(newBuilder.build());
                        }
                    })
                    .addInterceptor(httpLoggingInterceptor);

            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(builder.build())
                            //这样Retrofit就会使用Gson将ResponseBody转换我们想要的类型。在默认情况下Retrofit只支持将HTTP的响应体转换换为ResponseBody,对于Call<T>中T的转换
                    .addConverterFactory(GsonConverterFactory.create())
                            //CallAdapter则可以对Call转换
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }

        return retrofit.create(t);
    }
}
