package com.gwtravel.view.activity;

import android.os.Bundle;
import android.view.View;

import com.gwtravel.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class GCTActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gct);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btn_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
        }
    }
}
