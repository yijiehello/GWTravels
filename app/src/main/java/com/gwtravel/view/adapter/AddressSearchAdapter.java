package com.gwtravel.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.gwtravel.R;
import com.gwtravel.view.bean.AddressEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 一合鱼 on 2017,3,8,0008.
 */

public class AddressSearchAdapter extends BaseAdapter implements Filterable {

    private ArrayFilter mFilter;
    private ArrayList<AddressSearchEntity> mUnfilteredData;
    Context context;
    List<AddressSearchEntity> datas;

    public AddressSearchAdapter(Context context, List<AddressSearchEntity> datas) {
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

            convertView = LayoutInflater.from(context).inflate(R.layout.activity_address_search_listview_item,null);
            holder = new ViewHolder();

            holder.location_tv = (TextView) convertView.findViewById(R.id.location_tv);
            holder.location_img= (ImageView) convertView.findViewById(R.id.location_img);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        AddressSearchEntity entity = datas.get(position);
        holder.location_tv.setText(entity.getAddress());
        holder.location_img.setImageResource(entity.getIcon());
        return convertView;
    }

    @Override
    public Filter getFilter() {
        if (mFilter == null) {
            mFilter = new ArrayFilter();
        }
        return mFilter;
    }

    class ViewHolder {
        TextView location_tv;
        ImageView location_img;
    }
    private class ArrayFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence prefix) {
            FilterResults results = new FilterResults();

            if (mUnfilteredData == null) {
                mUnfilteredData = new ArrayList<AddressSearchEntity>(datas);
            }

            if (prefix == null || prefix.length() == 0) {
                ArrayList<AddressSearchEntity> list = mUnfilteredData;
                results.values = list;
                results.count = list.size();
            } else {
                String prefixString = prefix.toString().toLowerCase();

                ArrayList<AddressSearchEntity> unfilteredValues = mUnfilteredData;
                int count = unfilteredValues.size();

                ArrayList<AddressSearchEntity> newValues = new ArrayList<AddressSearchEntity>(count);
                for (int i = 0; i < count; i++) {
                    AddressSearchEntity pc = unfilteredValues.get(i);
                    if (pc != null) {
                        if(String.valueOf(pc.getIcon())!=null && String.valueOf(pc.getIcon()).startsWith(prefixString)){

                            newValues.add(pc);
                        }else if(pc.getAddress()!=null && pc.getAddress().startsWith(prefixString)){

                            newValues.add(pc);
                        }
                    }
                }

                results.values = newValues;
                results.count = newValues.size();
            }

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {
            //noinspection unchecked
            datas = (List<AddressSearchEntity>) results.values;
            if (results.count > 0) {
                notifyDataSetChanged();
            } else {
                notifyDataSetInvalidated();
            }
        }

    }


}
