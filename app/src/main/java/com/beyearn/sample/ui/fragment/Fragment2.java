package com.beyearn.sample.ui.fragment;


import android.support.v7.widget.RecyclerView;

import com.beyearn.sample.R;

import butterknife.BindView;

/**
 * Created by beyearn on 2017/7/19.
 */

public class Fragment2 extends BaseFragment {

    @BindView(R.id.rv_main)
    RecyclerView rvMain;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment2;
    }

    @Override
    public void initView() {

    }
}
