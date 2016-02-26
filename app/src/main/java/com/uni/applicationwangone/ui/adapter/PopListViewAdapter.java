package com.uni.applicationwangone.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.uni.applicationwangone.R;

/**
 * Created by Administrator on 2015/10/15.
 */
public class PopListViewAdapter extends BaseAdapter {
    private String[] datas;
    private LayoutInflater inflater;
    private int defaultSelectedPosition = 0;

    public PopListViewAdapter(Context aContext,String[] datas){
        inflater = LayoutInflater.from(aContext);
        this.datas = datas;
    }

    public void refreshStyle(int position){
        defaultSelectedPosition = position;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas.length;
    }

    @Override
    public Object getItem(int i) {
        return datas[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        TextView txtvValue;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.adapter_pop_listview_view,null);
        }
        txtvValue = (TextView)convertView.findViewById(R.id.txtvValue);
        txtvValue.setText(datas[i]);
        if(defaultSelectedPosition == i){
            txtvValue.setTextColor(Color.WHITE);
            convertView.setBackgroundColor(Color.BLACK);
        }else{
            txtvValue.setTextColor(Color.BLACK);
            convertView.setBackgroundColor(Color.WHITE);
        }
        return convertView;
    }
}
