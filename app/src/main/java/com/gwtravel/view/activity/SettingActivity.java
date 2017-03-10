package com.gwtravel.view.activity;

import android.content.Intent;
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
                startActivity(new Intent(SettingActivity.this,NotifyActivity.class));
                break;
            case R.id.rl_setting_modify_psw:
                startActivity(new Intent(SettingActivity.this,ModifyPswActivity.class));
                break;
            case R.id.rl_setting_about:
                startActivity(new Intent(SettingActivity.this,AboutActivity.class));
                break;
            case R.id.rl_setting_suggestion:
                startActivity(new Intent(SettingActivity.this,SuggestionActivity.class));
                break;
            case R.id.rl_setting_clear_the_cache:
                break;
        }
    }

}
