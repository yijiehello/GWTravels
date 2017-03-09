package com.gwtravel.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.gwtravel.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 注册页面
 * Created by yiheyu on 2017/3/6.
 */

public class RegisterActivity extends BaseActivity {
    @BindView(R.id.login_tv)
    TextView login_tv;

    @BindView(R.id.register_tv)
    TextView register_tv;

    @BindView(R.id.et_code)
    EditText et_code;

    @BindView(R.id.et_phone)
    EditText et_phone;

    @BindView(R.id.send_btn)
    Button send_btn;
    //计时器
    private Handler handler ;
    private int time =0;
    private boolean flag = false ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        //设置字体前景色
        SpannableString spannableString = new SpannableString("已有账号密码,点击登录");
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#e8b82d"));
        spannableString.setSpan(colorSpan, 9, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        login_tv.setText(spannableString);

        //实例化handler
        handler = new Handler()
        {
            public void handleMessage(Message msg) {

                //更新UI
                send_btn.setText(time+"s后重试");
                if(time<=0){
                    send_btn.setTextSize(12);
                    send_btn.setText("重新获取验证码");
                    send_btn.setClickable(true);

                }
            }
        };


    }

    @OnClick({R.id.login_tv, R.id.register_tv, R.id.send_btn})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.login_tv:
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                break;
            case R.id.register_tv:
                startActivity(new Intent(RegisterActivity.this,QueryCompanyActivity.class));
                break;
            case R.id.send_btn:
                if (!flag) {
                    //获取验证码
                    send_btn.setClickable(false);
                    time = 30;
                    //启动计时线程
                    new TimeThread().start();
                    flag = !flag;

                } else {
                    time = 0;
                    flag = !flag;
                }
                break;
        }
    }
    //计时线程
    class TimeThread extends Thread
    {
        @Override
        public void run() {

            while(time >= 0)
            {
                handler.sendEmptyMessage(1);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                time -= 1 ;
            }

        }
    }
}
