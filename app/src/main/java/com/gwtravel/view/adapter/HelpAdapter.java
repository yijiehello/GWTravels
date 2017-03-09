package com.gwtravel.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gwtravel.R;
import com.gwtravel.view.bean.HelpEntity;

import java.util.List;

/**
 * Created by 一合鱼 on 2017,3,9,0009.
 */

public class HelpAdapter extends BaseAdapter {


    Context context;
    List<HelpEntity> helpEntities;


    public HelpAdapter(Context context, List<HelpEntity> helpEntities) {
        this.context = context;
        this.helpEntities = helpEntities;
    }

    @Override
    public int getCount() {
        return helpEntities == null? 0 : helpEntities.size();
    }

    @Override
    public Object getItem(int position) {
        return helpEntities == null? null : helpEntities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolde viewHolde;

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_help_title,null);
            viewHolde = new ViewHolde();
            viewHolde.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            convertView.setTag(viewHolde);
        }else{
            viewHolde = (ViewHolde) convertView.getTag();
        }

        viewHolde.tv_title.setText(helpEntities.get(position).getTitle());
        return convertView;
    }


    class ViewHolde{

        TextView tv_title;
    }


}
