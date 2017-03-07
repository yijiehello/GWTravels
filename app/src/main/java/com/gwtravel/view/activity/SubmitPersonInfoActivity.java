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

public class SubmitPersonInfoActivity extends BaseActivity {

    @BindView(R.id.submit_tv)
    TextView submit_tv;

    @BindView(R.id.back_btn)
    ImageView back_btn;

    @BindView(R.id.name_et)
    EditText name_et;
    @BindView(R.id.connect_et)
    EditText connect_et;
    @BindView(R.id.department_et)
    EditText department_et;
    @BindView(R.id.job_et)
    EditText job_et;
    @BindView(R.id.company_et)
    EditText company_et;
    @BindView(R.id.home_et)
    EditText home_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_person_info);
        ButterKnife.bind(this);
        name_et.setFocusable(false);
        connect_et.setFocusable(false);
        department_et.setFocusable(false);
        job_et.setFocusable(false);
        company_et.setFocusable(false);
        home_et.setFocusable(false);
        init();
    }

    private void init() {

    }
    @OnClick({R.id.submit_tv,R.id.back_btn,R.id.name_et,R.id.connect_et,R.id.department_et,
    R.id.job_et,R.id.company_et,R.id.home_et})

    public void onClick(View view){
        switch (view.getId()){
            case R.id.submit_tv:
                startActivity(new Intent(SubmitPersonInfoActivity.this,LoginActivity.class));
                break;
            case R.id.back_btn:
                finish();
                break;
            case R.id.name_et:
                name_et.setFocusable(true);
                name_et.setFocusableInTouchMode(true);
                name_et.requestFocus();
                name_et.requestFocusFromTouch();
                break;
            case R.id.connect_et:
                connect_et.setFocusable(true);
                connect_et.setFocusableInTouchMode(true);
                connect_et.requestFocus();
                connect_et.requestFocusFromTouch();
                break;
            case R.id.department_et:
                department_et.setFocusable(true);
                department_et.setFocusableInTouchMode(true);
                department_et.requestFocus();
                department_et.requestFocusFromTouch();
                break;
            case R.id.job_et:
                job_et.setFocusable(true);
                job_et.setFocusableInTouchMode(true);
                job_et.requestFocus();
                job_et.requestFocusFromTouch();
                break;
            case R.id.company_et:
                company_et.setFocusable(true);
                company_et.setFocusableInTouchMode(true);
                company_et.requestFocus();
                company_et.requestFocusFromTouch();
                break;
            case R.id.home_et:
                home_et.setFocusable(true);
                home_et.setFocusableInTouchMode(true);
                home_et.requestFocus();
                home_et.requestFocusFromTouch();
                break;

        }
    }
}
