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
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.gwtravel.R;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;
import com.prolificinteractive.materialcalendarview.spans.DotSpan;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

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

    private String selectDate,selectyear,selectmonth,selectday;
    private String currentDate;
    private String currentyear;
    private String currentmonth;
    private static String currentday;
    private static int monthofday;
    HashSet<CalendarDay> dates=new HashSet<>();

    EventDecorator eventDecorator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_ticket);
        ButterKnife.bind(this);
        eventDecorator = new EventDecorator();
        init();
    }

    private void init() {
        //获取当前系统时间
        SimpleDateFormat  formatter = new  SimpleDateFormat("yyyy年MM月dd日");
        Date curDate= new  Date(System.currentTimeMillis());//获取当前时间
        currentDate= formatter.format(curDate);
        currentyear=currentDate.substring(0,4);
        currentmonth=currentDate.substring(currentDate.indexOf("年")+1,currentDate.indexOf("月"));
        //截取月份字段
        if(currentmonth.substring(0,1).equals("0")){
            currentmonth=currentmonth.substring(1,2);
        }
        //获取当月总的天数
        if(currentmonth.equals("1") || currentmonth.equals("3") ||currentmonth.equals("5") || currentmonth.equals("7")
                || currentmonth.equals("8") || currentmonth.equals("10") || currentmonth.equals("12")){
            monthofday=31;
        }else if(currentmonth.equals("4") || currentmonth.equals("6") || currentmonth.equals("9") ||currentmonth.equals("11") ){
            monthofday=30;
        }else{
            monthofday=28;
        }
        currentday=currentDate.substring(currentDate.indexOf("月")+1,currentDate.indexOf("日"));

        //设置滑动选择改变月份事件
        calendarView.setOnMonthChangedListener(this);
        calendarView.setOnDateChangedListener(this);

        //设置每月1-31都不可点击
        calendarView.addDecorator(new PrimeDayDisableDecorator());
        //设置每月的哪几号（可设置区段）可以点击
        calendarView.addDecorator(new EnableOneToTenDecorator());



    }

    /**
     * 监听月份改变函数
     * @param materialCalendarView the view associated with this listener
     * @param calendarDay   the month picked, as the first day of the month
     */
    @Override
    public void onMonthChanged(MaterialCalendarView materialCalendarView, CalendarDay calendarDay) {
        if(currentmonth.equals(calendarDay.getMonth()+1+"")){

            calendarView.addDecorator(new EnableOneToTenDecorator());//移动到本月时解绑

        }else{
            calendarView.addDecorator(new PrimeDayDisableDecorator());
            if(Integer.parseInt(currentday)+14>monthofday && currentmonth.equals(calendarDay.getMonth()+"")){
                calendarView.addDecorator(new EnableOverDecorator());//对超出本月的天数做解绑
            }

        }

    }
    /**
     * 监听日期改变函数
     *
     */
    @Override
    public void onDateSelected(@NonNull MaterialCalendarView widget, @Nullable CalendarDay date, boolean selected) {
        selectDate=getSelectedDatesString();
        selectyear=selectDate.substring(0,4);
        selectmonth=selectDate.substring(selectDate.indexOf("年")+1,selectDate.indexOf("月"));
        selectday=selectDate.substring(selectDate.indexOf("月")+1,selectDate.indexOf("日"));
        //收集每次点击的日期
        if(dates.contains(date)){
            dates.remove(date);
            HashSet<CalendarDay> data=new HashSet<>();
            data.add(date);
//            eventDecorator.setColor(R.color.white);
//            eventDecorator.setDates(data);
//            calendarView.removeDecorator(eventDecorator);
            calendarView.removeDecorator(new EventDecorator(getResources().getColor(R.color.white),data));
            money_tv.setText(5*dates.size()+".00");
        }else{
            dates.add(date);
            eventDecorator.setColor(R.color.red);
            eventDecorator.setDates(dates);
            calendarView.addDecorator(eventDecorator);
            money_tv.setText(5*dates.size()+".00");
//            calendarView.addDecorator(new EventDecorator(getResources().getColor(R.color.red),dates));
        }
        Log.e("dates----->",dates.toString());
        //给选中的日期加上红点



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
                startActivity(new Intent(BuyTicketActivity.this,PayActivity.class));
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

    //对日历的天数进行效果处理
    private static class EnableOneToTenDecorator implements DayViewDecorator {
        /**
         * 对<=10的日期，设置解除无法点击的效果
         * @param day {@linkplain CalendarDay} to possibly decorate
         *
         * @return
         */
        @Override
        public boolean shouldDecorate(CalendarDay day) {
            return day.getDay() <=Integer.parseInt(currentday)+14 && day.getDay()>=Integer.parseInt(currentday);//解除不可点击

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
    //对加上14天天数超过当月天数的处理
    private static class EnableOverDecorator implements DayViewDecorator {
        /**
         * 对<=10的日期，设置解除无法点击的效果
         * @param day {@linkplain CalendarDay} to possibly decorate
         *
         * @return
         */
        @Override
        public boolean shouldDecorate(CalendarDay day) {
            return day.getDay() <=Integer.parseInt(currentday)+14-monthofday ;//解除不可点击

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
    //天数进行锁定
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
                false,  // 0?false为可点击  true为不可点击
                true,
                true, // 2
                true, // 3
                true,
                true, // 5
                true,
                true, // 7
                true,
                true,
                true,
                true, // 11
                true,
                true, // 13
                true,
                true,
                true,
                true, // 17
                true,
                true, // 19
                true,
                true,
                true,
                true, // 23
                true,
                true,
                true,
                true,
                true,
                true, // 29
                true,
                true, // 31
                false,
                false,
                false, //PADDING
        };
    }
    /**
     * Decorate several days with a dot
     */
    public class EventDecorator implements DayViewDecorator {

        private int color;
        private HashSet<CalendarDay> dates;

        public HashSet<CalendarDay> getDates() {
            return dates;
        }

        public void setDates(HashSet<CalendarDay> dates) {
            this.dates = dates;
        }

        public int getColor() {

            return color;
        }

        public void setColor(int color) {
            this.color = color;
        }

        public EventDecorator() {
        }

        public EventDecorator(int color, Collection<CalendarDay> dates) {
            this.color = color;
            this.dates = new HashSet<>(dates);
        }
//
        @Override
        public boolean shouldDecorate(CalendarDay day) {
            return dates.contains(day) ;
        }

        @Override
        public void decorate(DayViewFacade view) {
            view.addSpan(new DotSpan(5, color));
            Log.e("TAG====",color+"");

        }
    }


}
