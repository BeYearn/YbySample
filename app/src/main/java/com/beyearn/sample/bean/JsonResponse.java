package com.beyearn.sample.bean;

/**
 * 服务器响应实体类
 *
 * @param <T>
 * @author Hunter
 */
public class JsonResponse<T> {
    public final static String SUCCESS = "0";

    //private SystemInfo.Config config;  忽略
    private T data;
    private String message;
    private String status;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
