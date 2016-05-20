package com.uni.applicationwangone.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.uni.applicationwangone.R;
import com.uni.applicationwangone.data.model.ReferenceBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Joe on 2016/5/19.
 * Email-joe.zong@xiaoniubang.com
 */
public class QXSearchResultAdapter extends BaseAdapter {
    ArrayList<ReferenceBean> referenceBeanArrayList = new ArrayList<>();
    Map<Integer,Boolean> map = new HashMap<>();

    public QXSearchResultAdapter(ArrayList<ReferenceBean> referenceBeanArrayList) {
        this.referenceBeanArrayList = referenceBeanArrayList;
    }

    public void refreshData(ArrayList<ReferenceBean> ls){
        if(ls == null){
            ls = new ArrayList<>();
        }
        referenceBeanArrayList = ls;
        notifyDataSetChanged();
    }

    public void showMore(int position){
        if(map.containsKey(position)){
            map.put(position,!map.get(position));
        }else {
            map.put(position,true);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return referenceBeanArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return referenceBeanArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listitem_qx_search_result, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        ReferenceBean bean = referenceBeanArrayList.get(position);
        viewHolder.txtvBDZMC.setText(bean.bdzmc);
        viewHolder.txtvJGMC.setText(bean.jgmc);
        viewHolder.txtvQXLX.setText(bean.qxlx);
        viewHolder.txtvQXDX.setText(bean.qxdx);
        viewHolder.txtvQXMS.setText(bean.qxms);
        viewHolder.txtvCLGC.setText(bean.clgc);
        viewHolder.txtvCLRY.setText(bean.clry);
        viewHolder.txtvCLSJ.setText(bean.clsj);
        if(map.containsKey(position)&&map.get(position)){
            viewHolder.llMore.setVisibility(View.VISIBLE);
        }else {
            viewHolder.llMore.setVisibility(View.GONE);
        }
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.txtvBDZMC)
        TextView txtvBDZMC;
        @Bind(R.id.txtvJGMC)
        TextView txtvJGMC;
        @Bind(R.id.txtvQXLX)
        TextView txtvQXLX;
        @Bind(R.id.txtvQXDX)
        TextView txtvQXDX;
        @Bind(R.id.txtvQXMS)
        TextView txtvQXMS;
        @Bind(R.id.txtvCLGC)
        TextView txtvCLGC;
        @Bind(R.id.txtvCLRY)
        TextView txtvCLRY;
        @Bind(R.id.txtvCLSJ)
        TextView txtvCLSJ;
        @Bind(R.id.llMore)
        LinearLayout llMore;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
