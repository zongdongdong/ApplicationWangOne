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

public class TimeSettingFragment extends BaseFragment {

    private View mRootView;
    private TextView txtvOne,txtvTwo,txtvThree,txtvFour,txtvFive,txtvSix;
    private int index = 0;

    public static TimeSettingFragment newInstance() {
        TimeSettingFragment fragment = new TimeSettingFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    public TimeSettingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.fragment_time_setting, container, false);
        txtvOne = (TextView)mRootView.findViewById(R.id.txtvOne);
        txtvTwo = (TextView)mRootView.findViewById(R.id.txtvTwo);
        txtvThree = (TextView)mRootView.findViewById(R.id.txtvThree);
        txtvFour = (TextView)mRootView.findViewById(R.id.txtvFour);
        txtvFive = (TextView)mRootView.findViewById(R.id.txtvFive);
        txtvSix = (TextView)mRootView.findViewById(R.id.txtvSix);
        return mRootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        refreshStyle();
    }

    public void topOrBottom(boolean isTop){
        TextView view = null;
        int minValue = 0;
        int maxvalue = 99;
        switch (index){
            case 0:
                view = txtvOne;
                minValue = 0;
                maxvalue = 99;
                break;
            case 1:
                view = txtvTwo;
                minValue = 1;
                maxvalue = 12;
                break;
            case 2:
                view = txtvThree;
                minValue = 1;
                maxvalue = 31;
                break;
            case 3:
                view = txtvFour;
                minValue = 0;
                maxvalue = 12;
                break;
            case 4:
                view = txtvFive;
                minValue = 0;
                maxvalue = 59;
                break;
            case 5:
                view = txtvSix;
                minValue = 0;
                maxvalue = 59;
                break;
        }
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

    public void leftOrRight(boolean isLeft){
        if(isLeft){
            if(index == 0){
                index = 5;
            }else{
                index --;
            }
        }else{
            if(index == 5){
                index = 0;
            }else{
                index ++;
            }
        }
        refreshStyle();
    }


    public synchronized void refreshStyle(){
        txtvOne.setSelected(false);
        txtvTwo.setSelected(false);
        txtvThree.setSelected(false);
        txtvFour.setSelected(false);
        txtvFive.setSelected(false);
        txtvSix.setSelected(false);
        switch (index){
            case 0:
                txtvOne.setSelected(true);
                break;
            case 1:
                txtvTwo.setSelected(true);
                break;
            case 2:
                txtvThree.setSelected(true);
                break;
            case 3:
                txtvFour.setSelected(true);
                break;
            case 4:
                txtvFive.setSelected(true);
                break;
            case 5:
                txtvSix.setSelected(true);
                break;
        }
    }

}
