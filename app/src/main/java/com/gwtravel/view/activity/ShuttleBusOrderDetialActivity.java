package com.gwtravel.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gwtravel.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShuttleBusOrderDetialActivity extends BaseActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shuttle_bus_order_detial);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back,R.id.tv_buy,R.id.tv_refund})

    public void onClick(View view){
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_buy:
                startActivity(new Intent(ShuttleBusOrderDetialActivity.this,BuyTicketActivity.class));
                break;
            case R.id.tv_refund:

                break;
        }
    }



}
