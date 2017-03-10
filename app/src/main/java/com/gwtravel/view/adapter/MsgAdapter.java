package com.gwtravel.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.gwtravel.R;
import com.gwtravel.view.bean.MsgEntity;

import java.util.List;

/**
 * Created by 一合鱼 on 2017,3,10,0010.
 */

public class MsgAdapter extends BaseAdapter {


    List<MsgEntity> msgEntities;
    Context context;

    public MsgAdapter(List<MsgEntity> msgEntities, Context context) {
        this.msgEntities = msgEntities;
        this.context = context;
    }

    @Override
    public int getCount() {
        return msgEntities == null? 0:msgEntities.size();
    }

    @Override
    public Object getItem(int position) {
        return msgEntities == null ? null:msgEntities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_msg,null);
            viewHolder = new ViewHolder();
            viewHolder.tv_time = (TextView) convertView.findViewById(R.id.tv_time);
            viewHolder.tv_content = (TextView) convertView.findViewById(R.id.tv_content);
            viewHolder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            viewHolder.tv_see = (TextView) convertView.findViewById(R.id.tv_see);

            convertView.setTag(viewHolder);
        }else{

            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.tv_title.setText(msgEntities.get(position).getTitle());
        viewHolder.tv_content.setText(msgEntities.get(position).getContent());
        viewHolder.tv_time.setText(msgEntities.get(position).getTime());


        if (msgEntities.get(position).getType().equals("1")){
            viewHolder.tv_see.setVisibility(View.VISIBLE);
            viewHolder.tv_see.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"查看详情",Toast.LENGTH_LONG).show();
                }
            });
        }else{
            viewHolder.tv_see.setVisibility(View.GONE);
        }



        return convertView;
    }


    class ViewHolder{

        TextView tv_title,tv_content,tv_time,tv_see;
    }


}
