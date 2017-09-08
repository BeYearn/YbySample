package com.beyearn.sample.ui.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.beyearn.sample.R;

/**
 * Created by Administrator on 2017/5/25.
 */

public class CustomProgress extends ProgressDialog {
    private TextView tvMessage;
    private CharSequence mMessage;
    private View ivBg1;
    private View ivBg2;

    public CustomProgress(Context context) {
        super(context);
    }

    public CustomProgress(Context context, int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init(getContext());
    }

    private void init(Context context) {
        setContentView(R.layout.layout_progress_dialog);

        tvMessage = (TextView) findViewById(R.id.tv_load_dialog);
        ivBg1 = findViewById(R.id.iv_bg_1);
        ivBg2 = findViewById(R.id.iv_bg_2);


        if (mMessage != null) {
            tvMessage.setText(mMessage);
        }

        /*WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(params);*/
    }

    @Override
    public void setMessage(CharSequence message) {
        if (tvMessage != null) {
            tvMessage.setText(message);
        } else {
            mMessage = message;
        }
    }

    @Override
    public void show() {
        //开始两个圈的动画

        ObjectAnimator scaleX1 = ObjectAnimator.ofFloat(ivBg1, "scaleX", 0, 1);
        ObjectAnimator scaleY1 = ObjectAnimator.ofFloat(ivBg1, "scaleY", 0, 1);
        ObjectAnimator scaleX2 = ObjectAnimator.ofFloat(ivBg2, "scaleX", 0, 1);
        ObjectAnimator scaleY2 = ObjectAnimator.ofFloat(ivBg2, "scaleY", 0, 1);
        ObjectAnimator alpha1 = ObjectAnimator.ofFloat(ivBg1, "alpha", 1f, 0);
        ObjectAnimator alpha2 = ObjectAnimator.ofFloat(ivBg2, "alpha", 1f, 0);

        scaleX1.setRepeatCount(ValueAnimator.INFINITE);
        scaleX1.setRepeatMode(ValueAnimator.RESTART);
        scaleY1.setRepeatCount(ValueAnimator.INFINITE);
        scaleY1.setRepeatMode(ValueAnimator.RESTART);
        alpha1.setRepeatCount(ValueAnimator.INFINITE);
        alpha1.setRepeatMode(ValueAnimator.RESTART);

        scaleX2.setRepeatCount(ValueAnimator.INFINITE);
        scaleX2.setRepeatMode(ValueAnimator.RESTART);
        scaleY2.setRepeatCount(ValueAnimator.INFINITE);
        scaleY2.setRepeatMode(ValueAnimator.RESTART);
        alpha2.setRepeatCount(ValueAnimator.INFINITE);
        alpha2.setRepeatMode(ValueAnimator.RESTART);


        AnimatorSet animatorSet1 = new AnimatorSet();
        animatorSet1.setDuration(2 * 1000);
        animatorSet1.setStartDelay(1000);
        animatorSet1.playTogether(scaleX1, scaleY1,alpha1);
        animatorSet1.start();

        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(scaleX2, scaleY2,alpha2);
        animatorSet2.setDuration(2 * 1000);
        animatorSet2.start();

        super.show();
    }
}
