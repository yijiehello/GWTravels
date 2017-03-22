package com.gwtravel.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gwtravel.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyETicketActivity extends BaseActivity {

    @BindView(R.id.btn_back)
    ImageView btn_back;

    @BindView(R.id.record_tv)
    TextView record_tv;
    @BindView(R.id.start_tv)
    TextView start_tv;
    @BindView(R.id.end_tv)
    TextView end_tv;
    @BindView(R.id.date_tv)
    TextView date_tv;
    @BindView(R.id.time_tv)
    TextView time_tv;
    @BindView(R.id.confirm_tv)
    TextView confirm_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_eticket);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_back, R.id.confirm_tv,R.id.record_tv})

    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_back:
                finish();
                break;
            case R.id.confirm_tv:

                break;
            case R.id.record_tv:

                break;

        }
    }
}
