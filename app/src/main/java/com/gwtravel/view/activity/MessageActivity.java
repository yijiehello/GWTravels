package com.gwtravel.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.gwtravel.R;
import com.gwtravel.view.adapter.MsgAdapter;
import com.gwtravel.view.bean.MsgEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MessageActivity extends BaseActivity {

    @BindView(R.id.lv_msg)
    ListView lv_msg;

    List<MsgEntity> msgEntities;

    MsgAdapter msgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ButterKnife.bind(this);

        init();
    }

    private void init() {

        msgEntities = new ArrayList<>();
        msgEntities.add(new MsgEntity("您的订单已经成功支付？","似水流年，我匆匆的有过所有的年华，在最精彩的一刻总是有你们的出现。只是我不知道，" +
                "我们到底能坚持多久，有一天，我不再年轻，有一天，我们好久没有联系，有一天，我落魄的像是逃亡的亡命之徒","2017/02/29 7:30","1"));
        msgEntities.add(new MsgEntity("发车提醒？","似水流年，我匆匆的有过所有的年华，在最精彩的一刻总是有你们的出现。只是我不知道，" +
                "我们到底能坚持多久，有一天，我不再年轻，有一天，我们好久没有联系，有一天，我落魄的像是逃亡的亡命之徒","2017/02/29 7:30","0"));
        msgEntities.add(new MsgEntity("您的订单已经成功支付？","似水流年，我匆匆的有过所有的年华，在最精彩的一刻总是有你们的出现。只是我不知道，" +
                "我们到底能坚持多久，有一天，我不再年轻，有一天，我们好久没有联系，有一天，我落魄的像是逃亡的亡命之徒","2017/02/29 7:30","1"));

        msgEntities.add(new MsgEntity("您的订单已经成功支付？","似水流年，我匆匆的有过所有的年华，在最精彩的一刻总是有你们的出现。只是我不知道，" +
                "我们到底能坚持多久，有一天，我不再年轻，有一天，我们好久没有联系，有一天，我落魄的像是逃亡的亡命之徒","2017/02/29 7:30","1"));
        msgEntities.add(new MsgEntity("发车提醒？","似水流年，我匆匆的有过所有的年华，在最精彩的一刻总是有你们的出现。只是我不知道，" +
                "我们到底能坚持多久，有一天，我不再年轻，有一天，我们好久没有联系，有一天，我落魄的像是逃亡的亡命之徒","2017/02/29 7:30","0"));
        msgEntities.add(new MsgEntity("您的订单已经成功支付？","似水流年，我匆匆的有过所有的年华，在最精彩的一刻总是有你们的出现。只是我不知道，" +
                "我们到底能坚持多久，有一天，我不再年轻，有一天，我们好久没有联系，有一天，我落魄的像是逃亡的亡命之徒","2017/02/29 7:30","1"));

        msgAdapter = new MsgAdapter(msgEntities,MessageActivity.this);
        lv_msg.setAdapter(msgAdapter);


    }


    @OnClick({R.id.iv_back, R.id.tv_del})

    public void onClick(View view){
        switch (view.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_del:

                break;

        }
    }


}
