package com.uni.applicationwangone.ui.adapter.jz;

import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.uni.applicationwangone.R;
import com.uni.applicationwangone.data.model.jz_bean.ContentListInfoBean;
import com.uni.applicationwangone.data.model.jz_bean.MenuInfo;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.BindInt;
import butterknife.ButterKnife;

/**
 * Created by Joe on 2016/6/24.
 * Email-joe.zong@xiaoniubang.com
 */
public class ContentListAdapter extends BaseAdapter {
    ArrayList<ContentListInfoBean.ContentListValueBean> listData = new ArrayList<>();
    int selectPosition = 0;

    public void refresh(ArrayList<ContentListInfoBean.ContentListValueBean> ls){
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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_content, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ContentListInfoBean.ContentListValueBean contentListValueBean = listData.get(position);
        if(!TextUtils.isEmpty(contentListValueBean.value1)&&!TextUtils.isEmpty(contentListValueBean.value2)){
            viewHolder.txtvValue3.setVisibility(View.GONE);
            viewHolder.llBg.setVisibility(View.VISIBLE);
            viewHolder.txtvValue1.setText(contentListValueBean.value1);
            viewHolder.txtvValue2.setText(contentListValueBean.value2);
        }else{
            viewHolder.txtvValue3.setVisibility(View.VISIBLE);
            viewHolder.llBg.setVisibility(View.GONE);
            viewHolder.txtvValue3.setText(contentListValueBean.value1);
        }
        if(selectPosition == position){
            viewHolder.llBg.setSelected(true);
            viewHolder.txtvValue3.setSelected(true);
        }else{
            viewHolder.llBg.setSelected(false);
            viewHolder.txtvValue3.setSelected(false);
        }

        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.llBg)
        LinearLayout llBg;
        @Bind(R.id.txtvValue1)
        TextView txtvValue1;
        @Bind(R.id.txtvValue2)
        TextView txtvValue2;
        @Bind(R.id.txtvValue3)
        TextView txtvValue3;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
