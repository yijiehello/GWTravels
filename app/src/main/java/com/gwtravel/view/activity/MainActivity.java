package com.gwtravel.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

import com.gwtravel.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.iv_user)
    ImageView iv_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_user,R.id.iv_message,R.id.linear_bills,R.id.linear_address,R.id.linear_help,R.id.linear_service,
            R.id.linear_setting,R.id.linear_Chartered,R.id.linear_inspect_ticket})

    public void onClick(View view){
        switch (view.getId()){
            case R.id.iv_user:
                mDrawerLayout.openDrawer(Gravity.LEFT);
                break;
            case R.id.iv_message:
                startActivity(new Intent(MainActivity.this,MessageActivity.class));
                break;
            case R.id.linear_bills:
                startActivity(new Intent(MainActivity.this,MyBillsActivity.class));
                break;
            case R.id.linear_address:
                startActivity(new Intent(MainActivity.this,AddressActivity.class));
                break;
            case R.id.linear_help:
                startActivity(new Intent(MainActivity.this,HelpActivity.class));
                break;
            case R.id.linear_service:

                break;
            case R.id.linear_setting:
                startActivity(new Intent(MainActivity.this,SettingActivity.class));
                break;
            case R.id.linear_Chartered:
                startActivity(new Intent(MainActivity.this,BusinessActivity.class));
                break;
            case R.id.linear_inspect_ticket:

                break;


        }
    }


}
