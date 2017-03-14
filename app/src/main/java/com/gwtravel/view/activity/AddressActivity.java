package com.gwtravel.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.gwtravel.R;
import com.gwtravel.view.adapter.AddressAdapter;
import com.gwtravel.view.bean.AddressEntity;
import com.gwtravel.view.bean.HelpEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddressActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView iv_back;
    @BindView(R.id.tv_del)
    TextView tv_del;
    @BindView(R.id.listview)
    ListView listview;
    private AddressAdapter addressadapter;
    List<AddressEntity> entity =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        entity.add(new AddressEntity(R.mipmap.home,"家","湖北省武汉市南湖大道XX号"));
        entity.add(new AddressEntity(R.mipmap.company,"公司","湖北省武汉市光谷软件园"));
        addressadapter=new AddressAdapter(AddressActivity.this,entity);
        listview.setAdapter(addressadapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(AddressActivity.this,AddressSearchActivity.class));
            }
        });
    }



    @OnClick({R.id.iv_back,R.id.tv_del})

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
