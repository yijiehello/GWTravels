package com.gwtravel.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.gwtravel.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *
 * Created by yiheyu on 2016/11/9.
 *
 */

public class SearchActivity extends BaseActivity {
    @BindView(R.id.btn_back)
    TextView btn_back;
    @BindView(R.id.et)
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        init();

    }

    private void init() {

    }
    @OnClick({R.id.btn_back})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_back:
                finish();
                break;
        }
    }
}
