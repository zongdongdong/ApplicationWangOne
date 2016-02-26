package com.uni.applicationwangone.ui.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.uni.applicationwangone.R;

/**
 * 定值区号
 */
public class DingZhiQuHaoFragment extends BaseFragment {
    private View mRootView;

    private LinearLayout layoutSetting;
    private TextView txtvOne;

    public static DingZhiQuHaoFragment newInstance() {
        DingZhiQuHaoFragment fragment = new DingZhiQuHaoFragment();
        return fragment;
    }

    public DingZhiQuHaoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_ding_zhi_qu_hao, container, false);
        layoutSetting = (LinearLayout)mRootView.findViewById(R.id.layoutSetting);
        layoutSetting.setVisibility(View.VISIBLE);

        txtvOne = (TextView)mRootView.findViewById(R.id.txtvOne);
        txtvOne.setSelected(true);
        return mRootView;
    }
    public void topOrBottom(boolean isTop){
        TextView view = txtvOne;
        int minValue = 0;
        int maxvalue = 99;
        int value = Integer.parseInt(view.getText().toString());
        if(isTop){
            if(value == maxvalue){
                view.setText(String.format("%02d",minValue));
            }else{
                value++;
                view.setText(String.format("%02d",value));
            }
        }else{
            if(value == minValue){
                view.setText(String.format("%02d",maxvalue));
            }else{
                value--;
                view.setText(String.format("%02d",value));
            }
        }
    }
}
