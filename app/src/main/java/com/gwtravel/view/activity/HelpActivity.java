package com.gwtravel.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.gwtravel.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HelpActivity extends BaseActivity {

    @BindView(R.id.lv_problem)
    ListView lv_problem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        ButterKnife.bind(this);

        init();

    }

    private void init() {

        List<String> problem = new ArrayList<>();
        problem.add("如何注册");
        problem.add("如何注册");
        problem.add("如何注册");
        problem.add("如何注册");
        problem.add("如何注册");
        problem.add("如何注册");
        problem.add("如何注册");
        problem.add("如何注册");
        problem.add("如何注册");
        problem.add("如何注册");
        problem.add("如何注册");
        problem.add("如何注册");
        problem.add("如何注册");
        problem.add("如何注册");
        problem.add("如何注册");
        problem.add("如何注册");
        problem.add("如何注册");
        problem.add("如何注册");
        problem.add("如何注册");
        problem.add("如何注册");
        problem.add("如何注册");

        View headerView = View.inflate(HelpActivity.this, R.layout.help_header_view, null);

        LinearLayout search = (LinearLayout) headerView.findViewById(R.id.linear_search_s);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HelpActivity.this,SearchActivity.class));
            }
        });

        lv_problem.addHeaderView(headerView);
        ArrayAdapter<String> carAdapter = new ArrayAdapter<>(HelpActivity.this, android.R.layout.simple_spinner_item, problem);
        lv_problem.setAdapter(carAdapter);

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
