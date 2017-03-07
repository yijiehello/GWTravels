package com.gwtravel.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import com.gwtravel.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yiheyu on 2017/3/6.
 */

public class QueryCompanyActivity extends BaseActivity{
    @BindView(R.id.company_tv)
    AutoCompleteTextView company_tv;

    @BindView(R.id.login_tv)
    TextView login_tv;

    @BindView(R.id.query_tv)
    TextView query_tv;

    List<String> cityNames = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_company);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        //设置字体前景色
        SpannableString spannableString = new SpannableString("已有账号密码,点击登录");
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#e8b82d"));
        spannableString.setSpan(colorSpan, 9, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        login_tv.setText(spannableString);

        //获取公司名称下拉列表
        for(int i=0;i<10;i++){
            cityNames.add(i,"武"+i);
        }
        ArrayAdapter<String> carAdapter = new ArrayAdapter<String>(QueryCompanyActivity.this,
                android.R.layout.simple_spinner_item, cityNames);
        company_tv.setAdapter(carAdapter);
        company_tv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                company_tv.setText(cityNames.get(position));
            }
        });

    }
    @OnClick({R.id.login_tv,R.id.query_tv})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.login_tv:
                startActivity(new Intent(QueryCompanyActivity.this,LoginActivity.class));
                break;
            case R.id.query_tv:
                startActivity(new Intent(QueryCompanyActivity.this,SubmitPersonInfoActivity.class));
                break;

        }
    }
}
