package com.gwtravel.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
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

public class RegisterActivity extends BaseActivity{
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


    }

    @OnClick({R.id.login_tv,R.id.register_tv,R.id.send_btn})

    public void onClick(View view){
        switch (view.getId()){
            case R.id.login_tv:

                break;
            case R.id.register_tv:
                startActivity(new Intent(RegisterActivity.this,QueryCompanyActivity.class));
                break;
            case R.id.send_btn:

                break;
        }
    }
}
