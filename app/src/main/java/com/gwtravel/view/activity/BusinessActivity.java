package com.gwtravel.view.activity;

import android.os.Bundle;

import com.gwtravel.R;

import butterknife.ButterKnife;

/**
 * 公务包车
 * Created by yiheyu on 2017/3/7.
 */

public class BusinessActivity extends BaseActivity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_charter);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
    }
}
