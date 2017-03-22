package com.gwtravel.view.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.gwtravel.R;
import com.gwtravel.view.bean.AddressEntity;
import com.gwtravel.view.bean.ShutleBusEntity;

import java.util.List;

/**
 * Created by 一合鱼 on 2017,3,8,0008.
 */

public class AddressAdapter extends BaseAdapter {


    Context context;
    List<AddressEntity> datas;

    public AddressAdapter(Context context, List<AddressEntity> datas) {
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

            convertView = LayoutInflater.from(context).inflate(R.layout.activity_address_listview_item,null);
            holder = new ViewHolder();

            holder.name_address = (TextView) convertView.findViewById(R.id.name_address);
            holder.address_tv = (TextView) convertView.findViewById(R.id.address_tv);
            holder.img= (ImageView) convertView.findViewById(R.id.img);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        AddressEntity entity = datas.get(position);
        holder.name_address.setText(entity.getName());
        holder.address_tv.setText(entity.getAddress());
//        holder.img.setImageBitmap(BitmapFactory.decodeFile(entity.getIcon()));
        holder.img.setImageResource(entity.getIcon());
        return convertView;
    }

    class ViewHolder {
        TextView name_address,address_tv;
        ImageView img;
    }


}
