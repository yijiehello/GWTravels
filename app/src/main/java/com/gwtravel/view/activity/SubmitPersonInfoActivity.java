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
        init();
    }

    private void init() {

    }
    @OnClick({R.id.submit_tv,R.id.back_btn})

    public void onClick(View view){
        switch (view.getId()){
            case R.id.submit_tv:
//                startActivity(new Intent(SubmitPersonInfoActivity.this,QueryCompanyActivity.class));
                break;
            case R.id.back_btn:
                finish();
                break;

        }
    }
}
