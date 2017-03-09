package com.gwtravel.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gwtravel.R;
import com.gwtravel.view.bean.ShutleBusEntity;

import java.util.List;

/**
 * Created by 一合鱼 on 2017,3,8,0008.
 */

public class ShuttleBusAdapter extends BaseAdapter {


    Context context;
    List<ShutleBusEntity> datas;

    public ShuttleBusAdapter(Context context, List<ShutleBusEntity> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas==null ? 0 : datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas == null ? null : datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {

            convertView = LayoutInflater.from(context).inflate(R.layout.item_shuttle_bus,null);
            holder = new ViewHolder();

            holder.tv_start = (TextView) convertView.findViewById(R.id.tv_start);
            holder.tv_start1 = (TextView) convertView.findViewById(R.id.tv_start1);
            holder.tv_startT = (TextView) convertView.findViewById(R.id.tv_starttime);
            holder.tv_end = (TextView) convertView.findViewById(R.id.tv_end);
            holder.tv_end1 = (TextView) convertView.findViewById(R.id.tv_end1);
            holder.tv_endT= (TextView) convertView.findViewById(R.id.tv_endtime);
            holder.tv_buy= (TextView) convertView.findViewById(R.id.tv_go_buy);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ShutleBusEntity entity = datas.get(position);

        holder.tv_start.setText(entity.getStartstation());
        holder.tv_start1.setText(entity.getStartstation());
        holder.tv_startT.setText(entity.getStarttime());
        holder.tv_end.setText(entity.getEndstation());
        holder.tv_end1.setText(entity.getEndstation());
        holder.tv_endT.setText(entity.getEndtime());

        return convertView;
    }

    class ViewHolder {
        TextView tv_start,tv_end,tv_start1,tv_end1,tv_startT,tv_endT,tv_buy;
    }


}
