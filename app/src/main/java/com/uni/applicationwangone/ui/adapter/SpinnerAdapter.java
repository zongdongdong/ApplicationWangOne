package com.uni.applicationwangone.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.uni.applicationwangone.R;
import com.uni.applicationwangone.data.model.SpinnerBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joe on 2016/5/19.
 * Email-joe.zong@xiaoniubang.com
 */
public class SpinnerAdapter extends BaseAdapter {
    List<SpinnerBean> spinnerList = new ArrayList<>();

    public void refreshData(List<SpinnerBean> ls){
        if(ls == null){
            spinnerList = new ArrayList<>();
        }else {
            spinnerList = ls;
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return spinnerList.size();
    }

    @Override
    public Object getItem(int i) {
        return spinnerList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if(convertView == null){
            convertView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.spinner_item,null);
        }
        TextView txtvSpinerValue = (TextView)convertView.findViewById(R.id.txtvSpinerValue);
        SpinnerBean spinnerBean = spinnerList.get(position);
        txtvSpinerValue.setText(spinnerBean.mz);
        return convertView;
    }
}
