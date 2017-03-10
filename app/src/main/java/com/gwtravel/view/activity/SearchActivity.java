package com.gwtravel.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.gwtravel.R;
import com.gwtravel.view.adapter.HelpAdapter;
import com.gwtravel.view.bean.HelpEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *
 * Created by yiheyu on 2016/11/9.
 *
 */

public class SearchActivity extends BaseActivity {
    @BindView(R.id.tv_back)
    TextView tv_back;
    @BindView(R.id.et)
    EditText et;


    @BindView(R.id.lv_problem)
    ListView lv_problem;
    List<HelpEntity> helpEntities;

    HelpAdapter helpAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        init();

    }

    private void init() {
        helpEntities = new ArrayList<>();
        helpEntities.add(new HelpEntity("如何注册"));
        helpEntities.add(new HelpEntity("如何购票"));
        helpEntities.add(new HelpEntity("如何设置地址线路"));
        helpEntities.add(new HelpEntity("如何取消订单"));


        helpAdapter = new HelpAdapter(SearchActivity.this,helpEntities);
        lv_problem.setAdapter(helpAdapter);


        lv_problem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(SearchActivity.this,HelpDetialActivity.class));
            }
        });

    }
    @OnClick({R.id.tv_back,R.id.iv_back})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.tv_back:
                finish();
                break;
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
