package com.gwtravel.view.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.gwtravel.R;

import butterknife.ButterKnife;
import butterknife.OnClick;




public class HelpDetialActivity extends BaseActivity {



    private LayoutInflater ml;
    private PopupWindow ppw;
    private static final int CALL_PHONE_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_detial);

        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back,R.id.tv_call})

    public void onClick(View view){
        switch (view.getId()){
            case R.id.iv_back:
                finish();
                break;

            case R.id.tv_call:
                show_dialog();
                ppw.showAtLocation(view, Gravity.CENTER, 0, 0);

                break;
        }
    }


    private void show_dialog() {
        //实例化ml
        ml = LayoutInflater.from(HelpDetialActivity.this);
        //将自定义布局转换为View对象
        final View viewtwo = ml.inflate(R.layout.calltoservice_popwindow, null);
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        Rect outRect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(outRect);
        //实例化ppw
        ppw = new PopupWindow(viewtwo, WindowManager.LayoutParams.MATCH_PARENT, dm.heightPixels, true);
        ppw.setBackgroundDrawable(new ColorDrawable(0));
        ppw.setOutsideTouchable(true);
        //为ppw设置可获取焦点
        ppw.setFocusable(true);
        // 设置点击背景消失
        LinearLayout layout = (LinearLayout) viewtwo.findViewById(R.id.popup_title_bg2);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ppw.dismiss();
            }
        });
        LinearLayout no_ll = (LinearLayout) viewtwo.findViewById(R.id.no_ll);
        no_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ppw.dismiss();
            }
        });
        LinearLayout yes_ll = (LinearLayout) viewtwo.findViewById(R.id.yes_ll);
        yes_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(HelpDetialActivity.this, Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {
                    //申请WRITE_EXTERNAL_STORAGE权限
                    ActivityCompat.requestPermissions(HelpDetialActivity.this, new String[]{Manifest.permission.CALL_PHONE}, CALL_PHONE_REQUEST_CODE);
                } else {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:4001001111"));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    ppw.dismiss();
                }
            }
        });
    }



}
