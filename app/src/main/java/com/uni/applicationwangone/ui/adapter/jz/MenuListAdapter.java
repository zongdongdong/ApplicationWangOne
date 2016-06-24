package com.uni.applicationwangone.ui.adapter.jz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.uni.applicationwangone.R;
import com.uni.applicationwangone.data.model.jz_bean.MenuInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Joe on 2016/6/23.
 * Email-joe.zong@xiaoniubang.com
 */
public class MenuListAdapter extends BaseAdapter {
    ArrayList<MenuInfo> listData = new ArrayList<>();
    int selectPosition = 0;

    public void refresh(ArrayList<MenuInfo> ls){
        if(ls == null){
            ls = new ArrayList<>();
        }
        listData = ls;
        notifyDataSetChanged();
    }

    public void selectItem(int i){
        if(i<getCount()){
            selectPosition = i;
            notifyDataSetChanged();
        }
    }

    public int getSelectPosition(){
        return selectPosition;
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_menu_list, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        MenuInfo menuInfo = listData.get(position);
        viewHolder.txtvMenu.setText((position+1)+"."+menuInfo.value);
        if(selectPosition == position){
            viewHolder.txtvMenu.setSelected(true);
        }else{
            viewHolder.txtvMenu.setSelected(false);
        }
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.txtvMenu)
        TextView txtvMenu;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
