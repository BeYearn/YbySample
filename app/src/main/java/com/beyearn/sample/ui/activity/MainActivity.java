package com.beyearn.sample.ui.activity;

import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.beyearn.sample.R;
import com.beyearn.sample.adapter.CustomFragmentPagerAdapter;
import com.beyearn.sample.ui.fragment.Fragment1;
import com.beyearn.sample.ui.fragment.Fragment2;
import com.beyearn.sample.utils.ToastHelper;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.vp_content)
    ViewPager viewPager;

    @BindView(R.id.rg_main_tab)
    RadioGroup rgTab;

    @BindView(R.id.rb_main_1)
    RadioButton rb1;

    @BindView(R.id.rb_main_2)
    RadioButton rb2;

    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private long clickTime;

    @Override
    protected int getContentResId() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            //透明状态栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }
        return R.layout.activity_main;
    }

    @Override
    public boolean isImmersion() {
        //是否沉浸
        return true;
    }

    @Override
    public void initView() {

        rb1.setOnClickListener(this);
        rb2.setOnClickListener(this);

        CustomFragmentPagerAdapter fragmentPagerAdapter = new CustomFragmentPagerAdapter(getSupportFragmentManager());
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragmentPagerAdapter.addPager(fragment1);
        fragmentPagerAdapter.addPager(fragment2);

        viewPager.setAdapter(fragmentPagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                checkPage(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        /*rgTab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                L.e("dianjile "+checkedId);
                switch (checkedId) {
                    case R.id.rb_main_1:
                        checkPage(0);
                        break;
                    case R.id.rb_main_2:
                        checkPage(1);
                        break;
                }
            }
        });*/

        //rgTab.check(R.id.rb_main_1);
        rb1.setChecked(true);

        /*//第一页具有双击返回顶部的功能
        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - clickTime <= 500) {
                    if (rgTab.getCheckedRadioButtonId() == R.id.rb_main_1) {
                        //,,,,fragment1.scrollTop();
                    }
                }

                clickTime = currentTimeMillis;
            }
        });*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rb_main_1:
                checkPage(0);
                break;
            case R.id.rb_main_2:
                checkPage(1);
                break;
        }
    }

    @Override
    public void initPresenter() {

    }


    private void checkPage(int position) {
        ToastHelper.toast(this,"点击了 "+position);
        viewPager.setCurrentItem(position);
        switch (position) {
            case 0:
                //rgTab.check(R.id.rb_main_1);
                rb1.toggle();
                break;
            case 1:
                //rgTab.check(R.id.rb_main_2);
                rb2.toggle();
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0) {
                exitApp();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private long mExitTime;
    private void exitApp() {
        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            showToast("再按一次退出");
            mExitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }
}
