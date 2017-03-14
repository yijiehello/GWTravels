package com.gwtravel.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;

import com.gwtravel.R;
import com.gwtravel.view.adapter.AddressSearchAdapter;
import com.gwtravel.view.adapter.AddressSearchEntity;
import com.gwtravel.view.bean.AddressEntity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddressSearchActivity extends BaseActivity {

    @BindView(R.id.cancel_tv)
    TextView cancel_tv;
    @BindView(R.id.search_tv)
    AutoCompleteTextView search_tv;
    @BindView(R.id.clear_img)
    ImageView clear_img;
    private AddressSearchAdapter searchadapter;
    List<AddressSearchEntity> entity =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_search);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        entity.add(new AddressSearchEntity(R.mipmap.locations,"贵州航天林泉科技园"));
        entity.add(new AddressSearchEntity(R.mipmap.locations,"贵州航天林泉科技园二"));
        entity.add(new AddressSearchEntity(R.mipmap.locations,"贵州航天林泉科技园三"));
        searchadapter=new AddressSearchAdapter(AddressSearchActivity.this,entity);
        search_tv.setAdapter(searchadapter);
        search_tv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                search_tv.setText(entity.get(position).getAddress());
            }
        });

    }
    @OnClick({R.id.cancel_tv,R.id.clear_img})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.cancel_tv:
                finish();
                break;
            case R.id.clear_img:
                search_tv.setText("");
                break;

        }
    }


}
