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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.gwtravel.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CarBillDetailsActivity extends BaseActivity {
    @BindView(R.id.back_btn)
    ImageView back_btn;

    @BindView(R.id.cancel_tv)
    TextView cancel_tv;
    @BindView(R.id.start_tv)
    TextView start_tv;
    @BindView(R.id.way_tv)
    TextView way_tv;
    @BindView(R.id.end_tv)
    TextView end_tv;

    @BindView(R.id.ticket_time)
    TextView ticket_time;
    @BindView(R.id.state_tv)
    TextView state_tv;
    @BindView(R.id.number_tv)
    TextView number_tv;
    @BindView(R.id.charge_tv)
    TextView charge_tv;
    @BindView(R.id.bill_time)
    TextView bill_time;
    @BindView(R.id.usecar_num)
    TextView usecar_num;
    @BindView(R.id.usecartype_tv)
    TextView usecartype_tv;
    @BindView(R.id.people_tv)
    TextView people_tv;
    @BindView(R.id.phone_tv)
    TextView phone_tv;
    @BindView(R.id.problem_tv)
    TextView problem_tv;

    private LayoutInflater ml;
    private PopupWindow ppw;
    private static final int CALL_PHONE_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_bill_details);
        ButterKnife.bind(this);
    }
    @OnClick({R.id.back_btn, R.id.cancel_tv, R.id.problem_tv})
    public void onClick(View view){
        switch(view.getId()){
            case R.id.back_btn:
                finish();
                break;
            case R.id.cancel_tv:
                startActivity(new Intent(CarBillDetailsActivity.this,BuyTicketActivity.class));
                break;
            case R.id.problem_tv:
                show_dialog();
                ppw.showAtLocation(problem_tv, Gravity.CENTER,0,0);
                break;

        }

    }
    //客服的弹出框
    private void show_dialog() {
        //实例化ml
        ml = LayoutInflater.from(CarBillDetailsActivity.this);
        //将自定义布局转换为View对象
        final View viewtwo = ml.inflate(R.layout.calltoservice_popwindow, null);
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        Rect outRect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(outRect);
        //实例化ppw
        ppw = new PopupWindow(viewtwo, WindowManager.LayoutParams.MATCH_PARENT, dm.heightPixels , true);
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
        LinearLayout no_ll= (LinearLayout) viewtwo.findViewById(R.id.no_ll);
        no_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ppw.dismiss();
            }
        });
        LinearLayout yes_ll= (LinearLayout) viewtwo.findViewById(R.id.yes_ll);
        yes_ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(CarBillDetailsActivity.this, Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {
                    //申请WRITE_EXTERNAL_STORAGE权限
                    ActivityCompat.requestPermissions(CarBillDetailsActivity.this,new String[]{Manifest.permission.CALL_PHONE},
                            CALL_PHONE_REQUEST_CODE);
                }else {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:027-87122688"));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    ppw.dismiss();
                }
            }
        });

    }
}
