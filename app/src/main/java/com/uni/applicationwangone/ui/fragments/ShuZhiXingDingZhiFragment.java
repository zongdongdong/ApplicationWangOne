package com.uni.applicationwangone.ui.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.uni.applicationwangone.R;
import com.uni.applicationwangone.ui.activity.MainActivity;
import com.uni.applicationwangone.ui.util.RemainingCountUpTimer;

/**
 * 差动保护，数值型定值，菜单(整定)
 */
public class ShuZhiXingDingZhiFragment extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private View mRootView;
    private LinearLayout llPagerOne,llPagerTwo,llPagerThree;
    private LinearLayout llOne,llTwo,llThree,llFour;
    private TextView txtvOne,txtvTwo,txtvThree,txtvFour,txtvFive,txtvSix,txtvSeven,txtvEight;
    private LinearLayout[] rowView;
    private TextView[][] valueView = new TextView[4][2];
    private int index = 0;
    private int rowIndex = 0;
    private int valueIndex = -1;

    private TextView txtvLeft,txtvMiddle,txtvRight;
    private TextView[] dialogButton;
    private int dialogButtonIndex = 0;

    private ProgressBar progressbar;
    private TextView txtvProgress;
    private RemainingCountUpTimer timer;



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
        llPagerOne = (LinearLayout)mRootView.findViewById(R.id.llPagerOne);
        llPagerTwo = (LinearLayout)mRootView.findViewById(R.id.llPagerTwo);
        llPagerThree = (LinearLayout)mRootView.findViewById(R.id.llPagerThree);

        llOne = (LinearLayout)mRootView.findViewById(R.id.llOne);
        llOne.setSelected(true);
        txtvOne = (TextView)mRootView.findViewById(R.id.txtvOne);
        txtvTwo = (TextView)mRootView.findViewById(R.id.txtvTwo);

        llTwo = (LinearLayout)mRootView.findViewById(R.id.llTwo);
        llTwo.setSelected(false);
        txtvThree = (TextView)mRootView.findViewById(R.id.txtvThree);
        txtvFour = (TextView)mRootView.findViewById(R.id.txtvFour);

        llThree = (LinearLayout)mRootView.findViewById(R.id.llThree);
        llThree.setSelected(false);
        txtvFive = (TextView)mRootView.findViewById(R.id.txtvFive);
        txtvSix = (TextView)mRootView.findViewById(R.id.txtvSix);

        llFour = (LinearLayout)mRootView.findViewById(R.id.llFour);
        llFour.setSelected(false);
        txtvSeven = (TextView)mRootView.findViewById(R.id.txtvSeven);
        txtvEight = (TextView)mRootView.findViewById(R.id.txtvEight);

        txtvOne.setSelected(false);
        txtvTwo.setSelected(false);
        txtvThree.setSelected(false);
        txtvFour.setSelected(false);
        txtvFive.setSelected(false);
        txtvSix.setSelected(false);
        txtvSeven.setSelected(false);
        txtvEight.setSelected(false);

        txtvLeft = (TextView)mRootView.findViewById(R.id.txtvLeft);//取消整定
        txtvMiddle = (TextView)mRootView.findViewById(R.id.txtvMiddle);//下装整定
        txtvRight = (TextView)mRootView.findViewById(R.id.txtvRight);//重新整定
        dialogButton = new TextView[]{txtvLeft,txtvMiddle,txtvRight};

        progressbar = (ProgressBar)mRootView.findViewById(R.id.progressbar);
        txtvProgress = (TextView)mRootView.findViewById(R.id.txtvProgress);

        setViews();
        return mRootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    private void setViews(){
        rowView = new LinearLayout[]{llOne,llTwo,llThree,llFour};
        valueView[0][0] = txtvOne;
        valueView[0][1] = txtvTwo;
        valueView[1][0] = txtvThree;
        valueView[1][1] = txtvFour;
        valueView[2][0] = txtvFive;
        valueView[2][1] = txtvSix;
        valueView[3][0] = txtvSeven;
        valueView[3][1] = txtvEight;
    }

    @Override
    public void top() {
        super.top();
        if(llPagerOne.getVisibility() == View.VISIBLE){
            if(valueIndex==-1){//上下选择行
                rowView[rowIndex].setSelected(false);
                if(rowIndex==0){
                    rowIndex=3;
                }else {
                    rowIndex--;
                }
                rowView[rowIndex].setSelected(true);
                valueView[rowIndex][0].setSelected(false);
                valueView[rowIndex][1].setSelected(false);
            }else{//修改值
                if(valueIndex==0){
                    index = rowIndex + rowIndex;
                }else{
                    index = rowIndex + rowIndex + 1;
                }
                changeValue(true);
            }
        }else if(llPagerTwo.getVisibility() == View.VISIBLE){

        }

    }

    @Override
    public void bottom() {
        super.bottom();
        if(llPagerOne.getVisibility() == View.VISIBLE){
            if(valueIndex==-1){//上下选择行
                rowView[rowIndex].setSelected(false);
                if(rowIndex==3){
                    rowIndex=0;
                }else {
                    rowIndex++;
                }
                rowView[rowIndex].setSelected(true);
                valueView[rowIndex][0].setSelected(false);
                valueView[rowIndex][1].setSelected(false);
            }else{//修改值
                if(valueIndex==0){
                    index = rowIndex + rowIndex;
                }else{
                    index = rowIndex + rowIndex + 1;
                }
                changeValue(false);
            }
        }else if(llPagerTwo.getVisibility() == View.VISIBLE){

        }

    }

    @Override
    public void left() {
        super.left();
        if(llPagerOne.getVisibility() == View.VISIBLE){
            //左右选择值
            if(valueIndex!=-1){
                if(valueIndex==0){
                    valueView[rowIndex][valueIndex].setSelected(false);
                    valueIndex++;
                    valueView[rowIndex][valueIndex].setSelected(true);
                }else{
                    valueView[rowIndex][valueIndex].setSelected(false);
                    valueIndex--;
                    valueView[rowIndex][valueIndex].setSelected(true);
                }
            }
        }else if(llPagerTwo.getVisibility() == View.VISIBLE){
            dialogButton[dialogButtonIndex].setSelected(false);
            if(dialogButtonIndex==0){
                dialogButtonIndex = 3;
            }else{
                dialogButtonIndex--;
            }
            dialogButton[dialogButtonIndex].setSelected(true);
        }

    }

    @Override
    public void right() {
        super.right();
        if(llPagerOne.getVisibility() == View.VISIBLE){
            //左右选择值
            if(valueIndex!=-1){
                if(valueIndex==0){
                    valueView[rowIndex][valueIndex].setSelected(false);
                    valueIndex++;
                    valueView[rowIndex][valueIndex].setSelected(true);
                }else{
                    valueView[rowIndex][valueIndex].setSelected(false);
                    valueIndex--;
                    valueView[rowIndex][valueIndex].setSelected(true);
                }
            }
        }else if(llPagerTwo.getVisibility() == View.VISIBLE){
            dialogButton[dialogButtonIndex].setSelected(false);
            if(dialogButtonIndex==2){
                dialogButtonIndex = 0;
            }else{
                dialogButtonIndex++;
            }
            dialogButton[dialogButtonIndex].setSelected(true);
        }

    }



    @Override
    public boolean cancel() {
        if(llPagerOne.getVisibility() == View.VISIBLE){
            if(valueIndex!=-1){
                valueIndex = -1;
                rowView[rowIndex].setSelected(true);
                valueView[rowIndex][0].setSelected(false);
                valueView[rowIndex][1].setSelected(false);
            }else{
                llPagerOne.setVisibility(View.GONE);
                llPagerTwo.setVisibility(View.VISIBLE);
                dialogButtonIndex = 0;
                dialogButton[0].setSelected(true);
                dialogButton[1].setSelected(false);
                dialogButton[2].setSelected(false);
            }
        }else if(llPagerTwo.getVisibility() == View.VISIBLE){

        }
        return super.cancel();
    }

    @Override
    public boolean confirm() {
        if(llPagerOne.getVisibility() == View.VISIBLE){
            if(valueIndex==-1){
                valueIndex = 0;
                rowView[rowIndex].setSelected(false);
                valueView[rowIndex][valueIndex].setSelected(true);
                valueView[rowIndex][1].setSelected(false);
            }
        }else if(llPagerTwo.getVisibility() == View.VISIBLE){
            switch (dialogButtonIndex){
                case 0://取消整定
                    if(getActivity()!=null){
                        ((MainActivity)getActivity()).closeFragment();
                    }
                    break;
                case 1://下装整定
                    llPagerOne.setVisibility(View.GONE);
                    llPagerTwo.setVisibility(View.GONE);
                    llPagerThree.setVisibility(View.VISIBLE);
                    timer = new RemainingCountUpTimer(1500, progressbar, txtvProgress,new Runnable() {
                        @Override
                        public void run() {
                            if(getActivity()!=null){
                                ((MainActivity)getActivity()).closeFragment();
                            }
                        }
                    });
                    timer.start();
                    break;
                case 2://重新整定
                    llPagerOne.setVisibility(View.VISIBLE);
                    llPagerTwo.setVisibility(View.GONE);
                    break;
            }

        }
        return super.confirm();
    }

    public synchronized void changeValue(boolean isTop){
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
}
