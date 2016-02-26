package com.uni.applicationwangone.ui.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uni.applicationwangone.R;

/**
 * 装置编号
 */
public class DeviceNumberFragment extends BaseFragment {

    private View mRootView;

    private TextView txtvOne;

    public static DeviceNumberFragment newInstance() {
        DeviceNumberFragment fragment = new DeviceNumberFragment();
        return fragment;
    }

    public DeviceNumberFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_device_number, container, false);
        txtvOne = (TextView)mRootView.findViewById(R.id.txtvOne);
        txtvOne.setSelected(true);
        return mRootView;
    }

    public void topOrBottom(boolean isTop){
        TextView view = txtvOne;
        int minValue = 0;
        int maxvalue = 999;
        int value = Integer.parseInt(view.getText().toString());
        if(isTop){
            if(value == maxvalue){
                view.setText(String.format("%03d",minValue));
            }else{
                value++;
                view.setText(String.format("%03d",value));
            }
        }else{
            if(value == minValue){
                view.setText(String.format("%03d",maxvalue));
            }else{
                value--;
                view.setText(String.format("%03d",value));
            }
        }
    }

}
