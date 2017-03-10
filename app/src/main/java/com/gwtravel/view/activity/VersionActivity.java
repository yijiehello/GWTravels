package com.gwtravel.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gwtravel.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class VersionActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btn_back,R.id.tv_skip})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.tv_skip:
                startActivity(new Intent(VersionActivity.this,WebActivity.class).putExtra("title","用户协议").putExtra("url","http://www.baidu.com"));
                break;
        }
    }
}
