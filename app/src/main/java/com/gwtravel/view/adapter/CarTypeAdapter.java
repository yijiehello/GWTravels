package com.gwtravel.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gwtravel.R;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by yiheyu on 2016/11/8.
 */

public class CarTypeAdapter extends BaseAdapter implements View.OnClickListener{
    private LayoutInflater ml;
    private Context context;
    private ArrayList<Map<String,Object>> datas;
    private int nums=0;

    public CarTypeAdapter(Context context, ArrayList<Map<String, Object>> datas) {
        this.context = context;
        this.datas = datas;
        ml=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datas==null ? 0 : datas.size();

    }

    @Override
    public Object getItem(int i) {
        return datas==null ? null : datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view;
        final ViewHolder holder;
        if(convertView==null){
            view = ml.inflate(R.layout.popuwindow_car_type_item, null);
            holder=new ViewHolder();

            holder.name_tv=(TextView) view.findViewById(R.id.name_tv);
            holder.num_tv=(TextView) view.findViewById(R.id.num_tv);
            holder.add_img= (ImageView) view.findViewById(R.id.add_img);
            holder.subtract_img= (ImageView) view.findViewById(R.id.subtract_img);
            view.setTag(holder);
        }else{
            view = convertView;
            holder=(ViewHolder) view.getTag();
        }


        Map<String,Object> data=datas.get(i);
        holder.name_tv.setText(data.get("item").toString());
        holder.num_tv.setText(""+nums);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_img:
                nums+=1;
                break;
            case R.id.subtract_img:
                nums-=1;
                break;
        }
    }

    class ViewHolder{
       TextView name_tv,num_tv;
        ImageView add_img,subtract_img;

    }
}
