package com.gwtravel.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.gwtravel.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yiheyu on 2017/3/6.
 */

public class LoginActivity extends BaseActivity {

    @BindView(R.id.login_tv)
    TextView login_tv;
    @BindView(R.id.forget_tv)
    TextView forget_tv;

    @BindView(R.id.back_btn)
    ImageView back_btn;
    @BindView(R.id.eye_img)
    ImageView eye_img;

    @BindView(R.id.phone_et)
    EditText phone_et;
    @BindView(R.id.password_et)
    EditText password_et;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        phone_et.setFocusable(false);
        password_et.setFocusable(false);
        init();
    }

    private void init() {

    }
    @OnClick({R.id.login_tv, R.id.back_btn, R.id.forget_tv, R.id.phone_et, R.id.password_et})

    public void onClick(View view){
        switch (view.getId()){
            case R.id.login_tv:
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                break;
            case R.id.forget_tv:
                startActivity(new Intent(LoginActivity.this,QueryCompanyActivity.class));
                break;
            case R.id.back_btn:
                finish();
                break;
            case R.id.phone_et:
                phone_et.setFocusable(true);
                phone_et.setFocusableInTouchMode(true);
                phone_et.requestFocus();
                phone_et.requestFocusFromTouch();
                break;
            case R.id.password_et:
                password_et.setFocusable(true);
                password_et.setFocusableInTouchMode(true);
                password_et.requestFocus();
                password_et.requestFocusFromTouch();
                if(!phone_et.getText().toString().equals("")){
                    login_tv.setBackground(getResources().getDrawable(R.drawable.background_yellow_text));
                }else{
                    login_tv.setBackground(getResources().getDrawable(R.drawable.background_grey_text));
                }
                break;

        }
    }
}
