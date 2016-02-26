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
 * 差动保护，数值型定值，菜单(整定)
 */
public class ShuZhiXingDingZhiFragment extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private View mRootView;
    private TextView txtvOne,txtvTwo,txtvThree,txtvFour,txtvFive,txtvSix,txtvSeven,txtvEight;
    private int index = 0;

    public static ShuZhiXingDingZhiFragment newInstance() {
        ShuZhiXingDingZhiFragment fragment = new ShuZhiXingDingZhiFragment();
        return fragment;
    }

    public ShuZhiXingDingZhiFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_shu_zhi_xing_ding_zhi, container, false);
        txtvOne = (TextView)mRootView.findViewById(R.id.txtvOne);
        txtvTwo = (TextView)mRootView.findViewById(R.id.txtvTwo);
        txtvThree = (TextView)mRootView.findViewById(R.id.txtvThree);
        txtvFour = (TextView)mRootView.findViewById(R.id.txtvFour);
        txtvFive = (TextView)mRootView.findViewById(R.id.txtvFive);
        txtvSix = (TextView)mRootView.findViewById(R.id.txtvSix);
        txtvSeven = (TextView)mRootView.findViewById(R.id.txtvSeven);
        txtvEight = (TextView)mRootView.findViewById(R.id.txtvEight);
        return mRootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        refreshStyle();
    }

    public synchronized void leftOrRight(boolean isLeft){
        if(isLeft){
            if(index != 0){
                index--;
                refreshStyle();
            }
        }else{
            if(index != 7){
                index++;
                refreshStyle();
            }
        }
    }

    public synchronized void topOrBottom(boolean isTop){
        String value;
        int maxValue = 0;
        int minValue = 0;
        TextView view = null;
        switch (index){
            case 0:
                value = txtvOne.getText().toString();
                maxValue = 999;
                minValue = 0;
                view = txtvOne;
                break;
            case 1:
                value = txtvTwo.getText().toString();
                maxValue = 99;
                minValue = 0;
                view = txtvTwo;
                break;
            case 2:
                value = txtvThree.getText().toString();
                maxValue = 999;
                minValue = 0;
                view = txtvThree;
                break;
            case 3:
                value = txtvFour.getText().toString();
                maxValue = 99;
                minValue = 0;
                view = txtvFour;
                break;
            case 4:
                value = txtvFive.getText().toString();
                maxValue = 9;
                minValue = 0;
                view = txtvFive;
                break;
            case 5:
                value = txtvSix.getText().toString();
                maxValue = 99;
                minValue = 0;
                view = txtvSix;
                break;
            case 6:
                value = txtvSeven.getText().toString();
                maxValue = 9;
                minValue = 0;
                view = txtvSeven;
                break;
            case 7:
                value = txtvEight.getText().toString();
                maxValue = 99;
                minValue = 0;
                view = txtvEight;
                break;
        }
        int value1 = Integer.parseInt(view.getText().toString());
        if(isTop){
            if(value1 == maxValue){
                if(maxValue>99){
                    view.setText(String.format("%03d",minValue));
                }else if(maxValue>9){
                    view.setText(String.format("%02d",minValue));
                }else{
                    view.setText(minValue+"");
                }
            }else{
                value1++;
                if(maxValue>99){
                    view.setText(String.format("%03d",value1));
                }else if(maxValue>9){
                    view.setText(String.format("%02d",value1));
                }else{
                    view.setText(value1+"");
                }
            }
        }else{
            if(value1 == minValue){
                if(maxValue>99){
                    view.setText(String.format("%03d",maxValue));
                }else if(maxValue>9){
                    view.setText(String.format("%02d",maxValue));
                }else{
                    view.setText(maxValue+"");
                }
            }else{
                value1--;
                if(maxValue>99){
                    view.setText(String.format("%03d",value1));
                }else if(maxValue>9){
                    view.setText(String.format("%02d",value1));
                }else{
                    view.setText(value1+"");
                }
            }
        }
    }

    public void refreshStyle(){
        txtvOne.setSelected(false);
        txtvTwo.setSelected(false);
        txtvThree.setSelected(false);
        txtvFour.setSelected(false);
        txtvFive.setSelected(false);
        txtvSix.setSelected(false);
        txtvSeven.setSelected(false);
        txtvEight.setSelected(false);
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
            case 6:
                txtvSeven.setSelected(true);
                break;
            case 7:
                txtvEight.setSelected(true);
                break;

        }
    }
}
