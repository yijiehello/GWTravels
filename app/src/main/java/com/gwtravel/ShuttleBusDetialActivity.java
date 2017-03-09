package com.gwtravel;

import android.os.Bundle;
import android.view.View;

import com.gwtravel.view.activity.BaseActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShuttleBusDetialActivity extends BaseActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shuttle_bus_detial);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.iv_back})

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }

}
