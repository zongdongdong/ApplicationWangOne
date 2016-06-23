package com.uni.applicationwangone.ui.adapter;

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
    List<MenuInfo> listData = new ArrayList<>();

    int selectPosition = 0;

    public void refresh(List<MenuInfo> ls){
        if(ls == null){
            ls = new ArrayList<>();
        }
        listData = ls;
        notifyDataSetChanged();
    }

    public void checkItem(int i){
        selectPosition = i;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
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
