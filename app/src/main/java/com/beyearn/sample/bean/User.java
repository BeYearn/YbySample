package com.beyearn.sample.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;

/**
 * Created by Administrator on 2017/1/10.
 */
@Entity
public class User {
    @Id
    private Long id;

    private String userToken = "";
    private String userName = "";

    @Property(nameInDb = "sex")     //设置一个非默认关系映射所对应的列名，默认是的使用字段名
    private String userSex = "";

    @Transient                       //添加此标记之后不会生成数据库表的列
    private String userData = "";

    @Generated(hash = 530591236)
    public User(Long id, String userToken, String userName, String userSex) {
        this.id = id;
        this.userToken = userToken;
        this.userName = userName;
        this.userSex = userSex;
    }

    @Generated(hash = 586692638)
    public User() {}

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserToken() {
        return this.userToken;
    }
    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }
    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserSex() {
        return this.userSex;
    }
    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userToken='" + userToken + '\'' +
                ", userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userData='" + userData + '\'' +
                '}';
    }
}
