package com.gwtravel.view.activity;

import android.os.Bundle;
import android.view.View;

import com.gwtravel.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class NotifyActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.iv_back})

    public void onClick(View view){
        switch (view.getId()){
            case R.id.iv_back:
                finish();
                break;

        }
    }
}
