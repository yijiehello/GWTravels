package com.gwtravel.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gwtravel.R;
import com.gwtravel.view.bean.BusLineEntity;

import java.util.List;

import static com.gwtravel.R.id.tv_name;
import static com.gwtravel.R.id.tv_tag;

/**
 * Created by 一合鱼 on 2017,3,9,0009.
 */

public class BusStationAdapter extends BaseAdapter {


    List<BusLineEntity.Station> stations;
    Context context;

    public BusStationAdapter(List<BusLineEntity.Station> stations, Context context) {
        this.stations = stations;
        this.context = context;
    }

    @Override
    public int getCount() {
        return stations == null?0:stations.size() ;
    }

    @Override
    public Object getItem(int position) {
        return stations == null?null:stations.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

ViewHolder holder;
        if (convertView == null) {

            convertView = LayoutInflater.from(context).inflate(R.layout.item_bus_line,null);
            holder = new ViewHolder();

            holder.tv_name = (TextView) convertView.findViewById(tv_name);
            holder.tv_tag = (TextView) convertView.findViewById(tv_tag);
            holder.iv_show = (ImageView) convertView.findViewById(R.id.iv_show);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        BusLineEntity.Station entity = stations.get(position);

        holder.tv_name.setText(entity.getName());



        if (position == 0 ){
            holder.iv_show.setImageResource(R.mipmap.rolldot);
            holder.tv_tag.setText("重新设置");
        } else if (position == stations.size()-1 ){
            holder.iv_show.setImageResource(R.mipmap.rolldot);
            holder.tv_tag.setText("重新设置");
        }else {
            holder.iv_show.setImageBitmap(null);
            holder.tv_tag.setText("");
        }



        return convertView;
    }

    class ViewHolder {
        TextView tv_name,tv_tag;
        ImageView iv_show;
    }


}
