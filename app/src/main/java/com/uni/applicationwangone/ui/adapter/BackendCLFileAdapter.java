package com.uni.applicationwangone.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.uni.applicationwangone.R;
import com.uni.applicationwangone.data.model.BackendCLBean;
import com.uni.applicationwangone.data.model.SMSBean;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Joe on 2016/5/19.
 * Email-joe.zong@xiaoniubang.com
 */
public class BackendCLFileAdapter extends BaseAdapter {

    public ArrayList<BackendCLBean> backendCLBeanArrayList = new ArrayList<>();

    public void refreshData(ArrayList<BackendCLBean> ls){
        if(ls ==null){
            ls = new ArrayList<>();
        }
        backendCLBeanArrayList = ls;
        notifyDataSetChanged();
    }

    public void clear(){
        refreshData(null);
    }


    @Override
    public int getCount() {
        return backendCLBeanArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return backendCLBeanArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listitem_file, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        BackendCLBean backendCLBean = backendCLBeanArrayList.get(position);
        viewHolder.txtvFileName.setText(backendCLBean.htgl);
        return convertView;
    }


    static class ViewHolder {
        @Bind(R.id.txtvFileName)
        TextView txtvFileName;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
