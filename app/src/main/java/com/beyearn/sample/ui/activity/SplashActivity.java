package com.beyearn.sample.ui.activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.beyearn.sample.R;
import com.beyearn.sample.app.Constants;
import com.beyearn.sample.app.service.SplashDownLoadService;
import com.beyearn.sample.base.BaseActivity;
import com.beyearn.sample.bean.Splash;
import com.beyearn.sample.utils.SerializableUtils;
import com.bumptech.glide.Glide;

import java.io.File;
import java.io.IOException;

import butterknife.BindView;

/**
 * Created by beyearn on 2017/9/1.
 * 闪屏页面
 */

public class SplashActivity extends BaseActivity {

    @BindView(R.id.btn_sp_btn)
    Button mBtnSp;
    @BindView(R.id.iv_sp_bg)
    ImageView mIvSp;
    private Splash mSplash;


    //由于CountDownTimer有一定的延迟，所以这里设置3400
    private CountDownTimer countDownTimer = new CountDownTimer(3400, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            mBtnSp.setText("跳过(" + millisUntilFinished / 1000 + "s)");
        }

        @Override
        public void onFinish() {
            mBtnSp.setText("跳过(" + 0 + "s)");
            gotoLoginOrMainActivity();
        }
    };

    @Override
    protected int getContentResId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {
        showAndDownSplash();
    }

    @Override
    public void initPresenter() {

    }

    private void showAndDownSplash() {
        showSplash();
        startImageDownLoad();
    }

    private void showSplash() {
        mSplash = getLocalSplash();
        if (mSplash != null && !TextUtils.isEmpty(mSplash.savePath)) {
            Log.d("SplashDemo","SplashActivity 获取本地序列化成功" + mSplash);
            Glide.with(this).load(mSplash.savePath).dontAnimate().into(mIvSp);
            startClock();
        } else {
            //否则就是默认图片加载两秒后消失(不给取消的机会)
            mBtnSp.setVisibility(View.INVISIBLE);
            mBtnSp.postDelayed(new Runnable() {
                @Override
                public void run() {
                    gotoLoginOrMainActivity();
                }
            }, 2000);
        }
    }


    private void startClock() {
        mBtnSp.setVisibility(View.VISIBLE);
        countDownTimer.start();
    }


    private void startImageDownLoad() {
        SplashDownLoadService.startDownLoadSplashImage(this, Constants.DOWNLOAD_SPLASH);
    }


    private Splash getLocalSplash() {
        Splash splash = null;
        try {
            Log.d("存储路径",Constants.SPLASH_PATH);//修改为存储到内存卡中，不需要动态申请权限
            // /data/user/0/com.example.wsj.splashdemo/files/alpha/splash
            File serializableFile = SerializableUtils.getSerializableFile(Constants.SPLASH_PATH,
                    Constants.SPLASH_FILE_NAME);
            splash = (Splash) SerializableUtils.readObject(serializableFile);
        } catch (IOException e) {
            Log.d("SplashDemo","SplashActivity 获取本地序列化闪屏失败" + e.getMessage());
        }
        return splash;
    }

    private void gotoLoginOrMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
