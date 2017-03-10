package com.gwtravel.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.gwtravel.R;
import com.gwtravel.view.adapter.HelpAdapter;
import com.gwtravel.view.bean.HelpEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HelpActivity extends BaseActivity {

    @BindView(R.id.lv_problem)
    ListView lv_problem;

    List<HelpEntity> helpEntities;

    HelpAdapter helpAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        ButterKnife.bind(this);

        init();

    }

    private void init() {

        helpEntities = new ArrayList<>();
        helpEntities.add(new HelpEntity("如何注册"));
        helpEntities.add(new HelpEntity("如何购票"));
        helpEntities.add(new HelpEntity("如何设置地址线路"));
        helpEntities.add(new HelpEntity("如何取消订单"));
        helpEntities.add(new HelpEntity("如何注册"));
        helpEntities.add(new HelpEntity("如何注册"));
        helpEntities.add(new HelpEntity("如何购票"));
        helpEntities.add(new HelpEntity("如何设置地址线路"));
        helpEntities.add(new HelpEntity("如何取消订单"));
        helpEntities.add(new HelpEntity("如何注册"));
        helpEntities.add(new HelpEntity("如何注册"));
        helpEntities.add(new HelpEntity("如何购票"));
        helpEntities.add(new HelpEntity("如何设置地址线路"));
        helpEntities.add(new HelpEntity("如何取消订单"));
        helpEntities.add(new HelpEntity("如何注册"));



        View headerView = View.inflate(HelpActivity.this, R.layout.help_header_view, null);

        LinearLayout search = (LinearLayout) headerView.findViewById(R.id.linear_search_s);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HelpActivity.this,SearchActivity.class));
            }
        });

        lv_problem.addHeaderView(headerView);
//        ArrayAdapter<String> carAdapter = new ArrayAdapter<>(HelpActivity.this, android.R.layout.simple_spinner_item, problem);

        helpAdapter = new HelpAdapter(HelpActivity.this,helpEntities);

        lv_problem.setAdapter(helpAdapter);


        lv_problem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(HelpActivity.this,HelpDetialActivity.class));
            }
        });




    }

    @OnClick({R.id.iv_back})

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }

}
