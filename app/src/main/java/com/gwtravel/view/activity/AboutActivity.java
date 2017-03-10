package com.gwtravel.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gwtravel.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AboutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btn_back, R.id.rl_version, R.id.rl_gct})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.rl_version:
                //  上传
                startActivity(new Intent(AboutActivity.this, VersionActivity.class));
                break;
            case R.id.rl_gct:
                startActivity(new Intent(AboutActivity.this, GCTActivity.class));
                break;
        }
    }
}
