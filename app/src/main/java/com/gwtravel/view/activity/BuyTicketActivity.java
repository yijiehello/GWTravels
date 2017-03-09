package com.gwtravel.view.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import android.widget.Toast;

import com.gwtravel.R;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class BuyTicketActivity extends BaseActivity implements OnMonthChangedListener,OnDateSelectedListener {
    @BindView(R.id.back_btn)
    ImageView back_btn;
    @BindView(R.id.call_img)
    ImageView call_img;

    @BindView(R.id.ticketway_tv)
    TextView ticketway_tv;
    @BindView(R.id.moneytimes_tv)
    TextView moneytimes_tv;
    @BindView(R.id.refund_instructions)
    TextView refund_instructions;
    @BindView(R.id.money_tv)
    TextView money_tv;
    @BindView(R.id.buy_ticket)
    TextView buy_ticket;

    @BindView(R.id.calendarView)
    MaterialCalendarView calendarView;

    private LayoutInflater ml;
    private PopupWindow ppw;
    private static final int CALL_PHONE_REQUEST_CODE = 1;
    private static final DateFormat FORMATTER = SimpleDateFormat.getDateInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_ticket);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        //设置滑动选择改变月份事件
        calendarView.setOnMonthChangedListener(this);
        calendarView.setOnDateChangedListener(this);

        calendarView.addDecorator(new PrimeDayDisableDecorator());
        calendarView.addDecorator(new EnableOneToTenDecorator());

    }

    /**
     * 监听月份改变函数
     * @param materialCalendarView the view associated with this listener
     * @param calendarDay   the month picked, as the first day of the month
     */
    @Override
    public void onMonthChanged(MaterialCalendarView materialCalendarView, CalendarDay calendarDay) {
//        getSupportActionBar().setTitle(FORMATTER.format(calendarDay.getDate()));
    }

    @Override
    public void onDateSelected(@NonNull MaterialCalendarView widget, @Nullable CalendarDay date, boolean selected) {
        Toast.makeText(this, getSelectedDatesString(), Toast.LENGTH_SHORT).show();
//        Log.e("TAG----",date.getDate().toString());
    }

    private String getSelectedDatesString() {
        CalendarDay date = calendarView.getSelectedDate();
        if (date == null) {
            return "No Selection";
        }
        return FORMATTER.format(date.getDate());
    }

    @OnClick({R.id.back_btn, R.id.call_img, R.id.buy_ticket})
    public void onClick(View view){
        switch(view.getId()){
            case R.id.back_btn:
                finish();
                break;
            case R.id.call_img:
                show_dialog();
                ppw.showAtLocation(call_img, Gravity.CENTER,0,0);
                break;
            case R.id.buy_ticket:

                break;

        }

    }
    //客服的弹出框
    private void show_dialog() {
        //实例化ml
        ml = LayoutInflater.from(BuyTicketActivity.this);
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
                if (ContextCompat.checkSelfPermission(BuyTicketActivity.this, Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {
                    //申请WRITE_EXTERNAL_STORAGE权限
                    ActivityCompat.requestPermissions(BuyTicketActivity.this,new String[]{Manifest.permission.CALL_PHONE},
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

    //对日历的item进行效果处理
    private static class EnableOneToTenDecorator implements DayViewDecorator {

        /**
         * 对<=10的日期，设置解除无法点击的效果
         * @param day {@linkplain CalendarDay} to possibly decorate
         *
         * @return
         */
        @Override
        public boolean shouldDecorate(CalendarDay day) {
            return day.getDay() <= 2;//2表示小于它天数即使设置了无法点击，也可以解除
        }

        /**
         * 具体实现的效果
         * @param view View to decorate
         */
        @Override
        public void decorate(DayViewFacade view) {
            view.setDaysDisabled(false);
        }
    }
    //效果二
    private static class PrimeDayDisableDecorator implements DayViewDecorator {

        /**
         * 需要实现效果的天数返回true
         * @param day {@linkplain CalendarDay} to possibly decorate
         *
         * @return
         */
        @Override
        public boolean shouldDecorate(CalendarDay day) {
            return PRIME_TABLE[day.getDay()];
        }

        /**
         * 上面方法返回true的天，会设置无法选择
         * @param view View to decorate
         */
        @Override
        public void decorate(DayViewFacade view) {
            view.setDaysDisabled(true);
        }

        private static boolean[] PRIME_TABLE = {
                false,  // 0?
                false,
                true, // 2
                true, // 3
                false,
                true, // 5
                false,
                true, // 7
                false,
                false,
                false,
                true, // 11
                false,
                true, // 13
                false,
                false,
                false,
                true, // 17
                false,
                true, // 19
                false,
                false,
                false,
                true, // 23
                false,
                false,
                false,
                false,
                false,
                true, // 29
                false,
                true, // 31
                false,
                false,
                false, //PADDING
        };
    }



}
