package com.gwtravel.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.gwtravel.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyBillsActivity extends BaseActivity {


    @BindView(R.id.tv_shuttle_bus)
    TextView tv_shuttle_bus;
    @BindView(R.id.tv_Chartered)
    TextView tv_Chartered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bills);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.iv_back,R.id.tv_Chartered,R.id.tv_shuttle_bus})

    public void onClick(View view){
        switch (view.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_Chartered:

                if (!tv_Chartered.isTextSelectable())
                tv_Chartered.setSelected(true);
                tv_Chartered.setSelected(false);

                break;
            case R.id.tv_shuttle_bus:

                break;

        }
    }

}
