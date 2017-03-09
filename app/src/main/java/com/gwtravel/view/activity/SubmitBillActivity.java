package com.gwtravel.view.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gwtravel.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SubmitBillActivity extends BaseActivity {

    @BindView(R.id.back_btn)
    ImageView back_btn;
    @BindView(R.id.look_tv)
    TextView look_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_bill);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back_btn, R.id.look_tv})
    public void onClick(View view){
        switch(view.getId()){
            case R.id.back_btn:
                finish();
                break;
            case R.id.look_tv:
                startActivity(new Intent(SubmitBillActivity.this,CarBillDetailsActivity.class));
                break;

        }

    }

}
