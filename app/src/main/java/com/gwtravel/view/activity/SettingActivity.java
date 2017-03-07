package com.gwtravel.view.activity;

import android.os.Bundle;
import android.view.View;

import com.gwtravel.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.rl_setting_modify_psw, R.id.rl_setting_about, R.id.rl_setting_clear_the_cache, R.id.rl_setting_msg, R.id.rl_setting_suggestion})

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rl_setting_msg:
                break;
            case R.id.rl_setting_modify_psw:
                break;
            case R.id.rl_setting_about:
                break;
            case R.id.rl_setting_suggestion:
                break;
            case R.id.rl_setting_clear_the_cache:
                break;
        }
    }

}
