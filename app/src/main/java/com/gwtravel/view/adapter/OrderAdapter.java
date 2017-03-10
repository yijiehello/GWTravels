package com.gwtravel.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gwtravel.R;
import com.gwtravel.view.bean.OrderEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 一合鱼 on 2017,3,10,0010.
 */

public class OrderAdapter extends BaseAdapter {

    List<OrderEntity> orderEntities;
    Context context;

    public OrderAdapter(List<OrderEntity> orderEntities, Context context) {
        this.orderEntities = orderEntities;
        this.context = context;
    }

    @Override
    public int getCount() {
        return orderEntities == null ? 0 : orderEntities.size();
    }

    @Override
    public Object getItem(int position) {
        return orderEntities == null ? null : orderEntities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_order, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {

            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (orderEntities.get(position).getStasue().equals("已完成")) {

            viewHolder.view.setBackgroundResource(R.color.grey);
        }else{
            viewHolder.view.setBackgroundResource(R.color.yellowroundbg);
        }

        if (orderEntities.get(position).getPrice().equals("")){
            viewHolder.tv_price.setText("未报价");
        }else{
            viewHolder.tv_price.setText("￥"+orderEntities.get(position).getPrice());
        }


        if (orderEntities.get(position).getPayed().equals("1")){
            viewHolder.tv_state.setText("已支付");
        }else{
            viewHolder.tv_state.setText("未支付");
        }


        viewHolder.tv_state_.setText(orderEntities.get(position).getStasue());
        viewHolder.tv_type.setText(orderEntities.get(position).getType());
        viewHolder.tv_num.setText(orderEntities.get(position).getDaynum());
        viewHolder.tv_day.setText(orderEntities.get(position).getDay());
        viewHolder.tv_time.setText(orderEntities.get(position).getTime());
        viewHolder.tv_start.setText(orderEntities.get(position).getsStation());
        viewHolder.tv_end.setText(orderEntities.get(position).geteStation());
        viewHolder.tv_car.setText(!orderEntities.get(position).getCar().equals("") ? orderEntities.get(position).getCar().toString() : "未安排");

        return convertView;
    }


    class ViewHolder {
        @BindView(R.id.v_tag)
        View view;

        @BindView(R.id.tv_type)
        TextView tv_type;
        @BindView(R.id.tv_state)
        TextView tv_state;
        @BindView(R.id.tv_time)
        TextView tv_time;
        @BindView(R.id.tv_day)
        TextView tv_day;
        @BindView(R.id.tv_num)
        TextView tv_num;
        @BindView(R.id.tv_start)
        TextView tv_start;
        @BindView(R.id.tv_end)
        TextView tv_end;
        @BindView(R.id.tv_price)
        TextView tv_price;
        @BindView(R.id.tv_car)
        TextView tv_car;
        @BindView(R.id.tv_state_)
        TextView tv_state_;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }


}
