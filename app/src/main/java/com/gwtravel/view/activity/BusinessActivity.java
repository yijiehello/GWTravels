package com.gwtravel.view.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.gwtravel.R;
import com.gwtravel.view.adapter.CarTypeAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 公务包车
 * Created by yiheyu on 2017/3/7.
 */

public class BusinessActivity extends BaseActivity{
    @BindView(R.id.back_btn)
    ImageView back_btn;
    @BindView(R.id.add_img)
    ImageView add_img;
    @BindView(R.id.monthone_img)
    ImageView monthone_img;
    @BindView(R.id.monthtwo_img)
    ImageView monthtwo_img;

    @BindView(R.id.start_et)
    EditText start_et;
    @BindView(R.id.end_et)
    EditText end_et;
    @BindView(R.id.car_et)
    EditText car_et;

    @BindView(R.id.time_tv)
    TextView time_tv;
    @BindView(R.id.cartype_tv)
    TextView cartype_tv;
    @BindView(R.id.call_tv)
    TextView call_tv;
    @BindView(R.id.put_tv)
    TextView put_tv;

    private Boolean flag=true;

    private Calendar calendar;
    private DatePickerDialog dialog;
    private LayoutInflater ml;
    private PopupWindow ppw;
    // 定义5个记录当前时间的变量
    private int years;
    private int month;
    private int day;
    private int hour;
    private int minutes;

    private CarTypeAdapter typeAdapter;
    private ArrayList<Map<String,Object>> typedata=new ArrayList<>();
    private String[] name={"商务7座","商务15座","中巴22座","中巴33座","中巴39座"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_charter);
        ButterKnife.bind(this);
        select();
        init();
    }

    private void init() {
        //设置字体前景色
        SpannableString spannableString = new SpannableString("快捷下单,拨打包车热线：4000-123456");
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#ff0000"));
        spannableString.setSpan(colorSpan, 12, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        call_tv.setText(spannableString);

    }
    @OnClick({R.id.back_btn,R.id.add_img,R.id.monthone_img,R.id.monthtwo_img,
            R.id.time_tv,R.id.cartype_tv,R.id.call_tv,R.id.put_tv})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.back_btn:
                finish();
                break;
            case R.id.add_img:

                break;
            case R.id.monthone_img:
                flag=true;
                select();
                break;
            case R.id.monthtwo_img:
                flag=false;
                select();
                break;
            case R.id.time_tv:
//                calendar = Calendar.getInstance();
//                dialog = new DatePickerDialog(BusinessActivity.this, new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                        time_tv.setText(year + "/" + (monthOfYear+1) + "/" + dayOfMonth);
//                    }
//                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
//                dialog.show();
                timepopwindow();
                ppw.showAtLocation(time_tv, Gravity.BOTTOM,0,0);
                break;
            case R.id.cartype_tv:
                cartypepopwindow(cartype_tv);
                ppw.showAtLocation(cartype_tv,Gravity.BOTTOM,0,0);
                break;
            case R.id.call_tv:
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+"027-87122688"));
                startActivity(intent);
                break;
            case R.id.put_tv:

                break;

        }
    }
    //付费方式选择
    public void select(){
        if(flag){
            monthone_img.setImageDrawable(getResources().getDrawable(R.mipmap.redright));
            monthtwo_img.setImageDrawable(getResources().getDrawable(R.mipmap.greyright));
        }else{
            monthone_img.setImageDrawable(getResources().getDrawable(R.mipmap.greyright));
            monthtwo_img.setImageDrawable(getResources().getDrawable(R.mipmap.redright));
        }
    }
    //时间popuwindow
    private void timepopwindow() {
        //实例化ml
        ml = LayoutInflater.from(BusinessActivity.this);
        //将自定义布局转换为View对象
        final View view = ml.inflate(R.layout.time_popuwindow, null);
        //设置背景颜色
        //view.setBackgroundColor(getResources().getColor(R.color.view_color));
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        Rect outRect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(outRect);
        //实例化ppw
        ppw = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, dm.heightPixels, true);
        ppw.setBackgroundDrawable(new ColorDrawable(0));
        ppw.setOutsideTouchable(true);
        //为ppw设置可获取焦点
        ppw.setFocusable(true);
        // 设置点击背景消失
        RelativeLayout layout = (RelativeLayout) view.findViewById(R.id.popup_title_bg);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ppw.dismiss();
            }
        });
        //日期和时间
        DatePicker datepicker= (DatePicker) view.findViewById(R.id.datepicker);
        TimePicker timepicker= (TimePicker) view.findViewById(R.id.timepicker);
        final Calendar c = Calendar.getInstance();
        years = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        hour = c.get(Calendar.HOUR);
        minutes = c.get(Calendar.MINUTE);
        timepicker.is24HourView();
        timepicker.setCurrentHour(c.get(Calendar.HOUR_OF_DAY));
        timepicker.setCurrentMinute(c.get(Calendar.MINUTE));
        datepicker.init(c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                BusinessActivity.this.years = year;
                BusinessActivity.this.month = monthOfYear;
                BusinessActivity.this.day = dayOfMonth;
                // 显示当前日期、时间
                showDate(years, month, day, hour, minutes);
            }
        });
        timepicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                BusinessActivity.this.hour = hourOfDay;
                BusinessActivity.this.minutes = minute;
                // 显示当前日期、时间
                showDate(years, month, day, hour, minutes);
            }
        });
        //取消和确认按钮
        TextView cancel_tv= (TextView) view.findViewById(R.id.cancel_tv);
        TextView affirm_tv= (TextView) view.findViewById(R.id.affirm_tv);
        cancel_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ppw.dismiss();
            }
        });
        affirm_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ppw.dismiss();
            }
        });

    }
    // 定义在EditText中显示当前日期、时间的方法
    private void showDate(int year, int month
            , int day, int hour, int minute)
    {
        time_tv.setText( year + "年"
                + (month + 1) + "月" + day + "日  "
                + hour + "时" + minute + "分");
    }
    //用车类型和数量popuwindow
    private void cartypepopwindow(final TextView text) {
        //实例化ml
        ml = LayoutInflater.from(BusinessActivity.this);
        //将自定义布局转换为View对象
        final View view = ml.inflate(R.layout.cartype_popuwindow, null);
        ListView listview= (ListView) view.findViewById(R.id.listview);
        typedata.clear();
        getdata();
        typeAdapter=new CarTypeAdapter(BusinessActivity.this,typedata);
        listview.setAdapter(typeAdapter);
        //设置背景颜色
        //view.setBackgroundColor(getResources().getColor(R.color.view_color));
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        Rect outRect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(outRect);
        //实例化ppw
        ppw = new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT, dm.heightPixels, true);
        ppw.setBackgroundDrawable(new ColorDrawable(0));
        ppw.setOutsideTouchable(true);
        //为ppw设置可获取焦点
        ppw.setFocusable(true);
        // 设置点击背景消失
        RelativeLayout layout = (RelativeLayout) view.findViewById(R.id.popup_title_bg);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ppw.dismiss();
            }
        });
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                text.setText(name[position]);

            }
        });
        //取消和确认按钮
        TextView cancel_tv= (TextView) view.findViewById(R.id.cancel_tv);
        TextView affirm_tv= (TextView) view.findViewById(R.id.affirm_tv);
        cancel_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ppw.dismiss();
            }
        });
        affirm_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ppw.dismiss();
            }
        });
    }
    private ArrayList<Map<String,Object>> getdata() {
        for(int i=0;i<name.length;i++){
            Map<String, Object> data = new HashMap<String,Object>();
            data.put("item",name[i]);
            typedata.add(data);
        }
        return typedata;

    }

}
