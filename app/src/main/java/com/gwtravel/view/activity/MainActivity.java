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

    @OnClick({R.id.iv_user,R.id.iv_message})

    public void onClick(View view){
        switch (view.getId()){
            case R.id.iv_user:
                mDrawerLayout.openDrawer(Gravity.LEFT);
                break;
            case R.id.iv_message:
                startActivity(new Intent(MainActivity.this,MessageActivity.class));
                break;

        }
    }


}
