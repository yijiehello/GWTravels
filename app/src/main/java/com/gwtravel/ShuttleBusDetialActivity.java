package com.gwtravel;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.gwtravel.view.activity.BaseActivity;
import com.gwtravel.view.adapter.BusStationAdapter;
import com.gwtravel.view.bean.BusLineEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShuttleBusDetialActivity extends BaseActivity {


    @BindView(R.id.lv_bus_station)
    ListView lv_bus_station;
    BusStationAdapter busStationAdapter;
    List<BusLineEntity.Station> stations ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shuttle_bus_detial);
        ButterKnife.bind(this);

        stations = new ArrayList<>();
        stations.add(new BusLineEntity.Station("光谷广场","1"));
        stations.add(new BusLineEntity.Station("杨家湾","1"));
        stations.add(new BusLineEntity.Station("虎泉","1"));
        stations.add(new BusLineEntity.Station("广埠屯","1"));
        stations.add(new BusLineEntity.Station("街道口","1"));
        stations.add(new BusLineEntity.Station("宝通寺","1"));
        stations.add(new BusLineEntity.Station("中南路","1"));
        stations.add(new BusLineEntity.Station("洪山广场","1"));
        stations.add(new BusLineEntity.Station("小龟山","1"));
        stations.add(new BusLineEntity.Station("螃蟹甲","1"));
        stations.add(new BusLineEntity.Station("积玉桥","1"));
        stations.add(new BusLineEntity.Station("江汉路","1"));
        stations.add(new BusLineEntity.Station("循礼门","1"));
        stations.add(new BusLineEntity.Station("中山公园","1"));
        stations.add(new BusLineEntity.Station("青年路","1"));
        stations.add(new BusLineEntity.Station("王家墩东","1"));
        stations.add(new BusLineEntity.Station("范湖","1"));
        stations.add(new BusLineEntity.Station("汉口火车站","1"));


        init();
    }

    private void init() {


        busStationAdapter = new BusStationAdapter(stations,ShuttleBusDetialActivity.this);
        lv_bus_station.setAdapter(busStationAdapter);

    }


    @OnClick({R.id.iv_back,R.id.tv_go_buy})

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_go_buy:

                break;
        }
    }

}