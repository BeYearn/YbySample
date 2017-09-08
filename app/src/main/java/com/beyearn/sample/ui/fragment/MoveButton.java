package com.beyearn.sample.ui.fragment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by beyearn on 2017/8/25.
 */

public class MoveButton extends Button {


    public MoveButton(Context context) {
        super(context);
    }

    public MoveButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoveButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        this.getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(event);
    }
}
