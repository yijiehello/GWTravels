package com.gwtravel.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.gwtravel.R;
import com.gwtravel.view.adapter.OrderAdapter;
import com.gwtravel.view.bean.OrderEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyBillsActivity extends BaseActivity {


    @BindView(R.id.tv_shuttle_bus)
    TextView tv_shuttle_bus;
    @BindView(R.id.tv_chartered)
    TextView tv_chartered;

    @BindView(R.id.lv_order)
    ListView lv_order;

    List<OrderEntity> orderEntities;

    OrderAdapter orderAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bills);
        ButterKnife.bind(this);
        init();

        tv_chartered.setSelected(false);
        tv_shuttle_bus.setSelected(true);

    }

    private void init() {

        orderEntities = new ArrayList<>();

        orderEntities.add(new OrderEntity("单程票","未完成","光谷广场","汉口火车站","5.00","1","鄂A8888"));
        orderEntities.add(new OrderEntity("单程票","未完成","光谷广场","汉口火车站","10.00","1",""));
        orderEntities.add(new OrderEntity("单程票","已完成","光谷广场","汉口火车站","50.00","1","鄂A8888"));

        orderAdapter = new OrderAdapter(orderEntities,MyBillsActivity.this);
        lv_order.setAdapter(orderAdapter);

        lv_order.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MyBillsActivity.this,ShuttleBusOrderDetialActivity.class));
            }
        });

    }


    private void init2() {

        orderEntities = new ArrayList<>();

        orderEntities.add(new OrderEntity("公务包车","未完成","光谷广场","汉口火车站","5000.00","1","鄂A8888"));
        orderEntities.add(new OrderEntity("公务包车","未完成","光谷广场","汉口火车站","10000.00","1",""));
        orderEntities.add(new OrderEntity("公务包车","已完成","光谷广场","汉口火车站","500.00","1","鄂A8888"));

        orderAdapter = new OrderAdapter(orderEntities,MyBillsActivity.this);
        lv_order.setAdapter(orderAdapter);

        lv_order.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MyBillsActivity.this,CarBillDetailsActivity.class));
            }
        });


    }

    @OnClick({R.id.iv_back, R.id.tv_chartered,R.id.tv_shuttle_bus})

    public void onClick(View view){
        switch (view.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_chartered:

//                if (!tv_chartered.isTextSelectable())
                tv_chartered.setSelected(true);
                tv_shuttle_bus.setSelected(false);
init2();
                break;
            case R.id.tv_shuttle_bus:

                tv_chartered.setSelected(false);
                tv_shuttle_bus.setSelected(true);
                init();
                break;

        }
    }

}
