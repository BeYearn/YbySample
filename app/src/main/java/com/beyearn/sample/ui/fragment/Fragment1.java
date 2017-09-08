package com.beyearn.sample.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.beyearn.sample.R;
import com.beyearn.sample.app.UserManager;
import com.beyearn.sample.bean.SystemInfo;
import com.beyearn.sample.bean.User;
import com.beyearn.sample.interfaces.view.GetUserView;
import com.beyearn.sample.interfaces.view.SysInfoView;
import com.beyearn.sample.presenter.CommonPresenter;
import com.beyearn.sample.utils.L;

import java.util.Properties;

import butterknife.BindView;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by beyearn on 2017/7/19.
 */

public class Fragment1 extends BaseFragment implements SysInfoView, GetUserView {

    @BindView(R.id.bt_get_user)
    MoveButton btGetUser;
    private float mX;
    private float mY;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment1;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EventBus.getDefault().register(this);


        Properties properties = new Properties();
    }

    /*@Subscribe
    public void onSystemInfoGet(){

    }*/

    @Override
    public void initView() {

        btGetUser.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mX = motionEvent.getX();
                        mY = motionEvent.getY();
                        L.e("x,,y",mX+".."+mY);
                        break;
                    case MotionEvent.ACTION_MOVE:
                        //Log.e("rawX||X", motionEvent.getRawX() + "||" + motionEvent.getX() + "..." + mX);
                        //Log.e("rawY||Y", motionEvent.getRawY() + "||" + motionEvent.getY() + "..." + mY);

                        //view.setX(motionEvent.getRawX() - view.getWidth() / 2);
                        //view.setY(motionEvent.getRawY() - view.getHeight() / 2);

                        view.setX(motionEvent.getRawX() - mX);
                        view.setY(motionEvent.getRawY() - mY - getStatusBarHeight());
                        break;
                }
                return false;  // setontouchlister后返回false则进一步ontouchevent,否则不ontouchevent(该方法中才走onclicklister(如果有的话))
            }
        });


        btGetUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //这里获取也应该在子线程, 但是感觉在UserManager中真正读取数据库的时候进行子线程操作比较好(todo).
                User currentUser = UserManager.getInstance().getCurrentUser();
                L.e(currentUser.toString());
                showProgress("hahah");
            }
        });

        CommonPresenter commonPresenter = new CommonPresenter();
        commonPresenter.getSysInfo(this, "20012", "26", "1001", "863206035771707", "7F61206936AB2B2DC4D166ADD457F6A4");
        commonPresenter.getUserInfo(this, "hahahahaha");
    }

    @Override
    public void getSysInfo(SystemInfo systemInfo) {
        Log.e("getSysInfo", systemInfo.toString());
    }

    @Override
    public void getUserInfo(final User user) {
        // 获取user信息成功 存储也应该在子线程

        //貌似应该定义一个完成在子线程的startAsync,  还有定义用just,Action1这种简写的async方法 (todo)
        startAsync(Observable.create(new Observable.OnSubscribe<User>() {
            @Override
            public void call(Subscriber<? super User> subscriber) {
                subscriber.onNext(user);
            }
        }), new Subscriber<User>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(User user) {
                UserManager.getInstance().setCurrentUser(user);
            }
        });
    }
}
