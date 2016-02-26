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

public class ThreeButtonDialogFragment extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    private static final String ARG_PARAM4 = "param4";
    private static final String ARG_PARAM5 = "param5";

    private String title;
    private String content;
    private String leftText;
    private String middleText;
    private String rightText;

    private View mRootView;

    private TextView txtvTitle,txtvContent,txtvLeft,txtvMiddle,txtvRight;

    private int index = 0;

    public static ThreeButtonDialogFragment newInstance(String title,String content, String leftText, String middleText, String rightText) {
        ThreeButtonDialogFragment fragment = new ThreeButtonDialogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, title);
        args.putString(ARG_PARAM2, leftText);
        args.putString(ARG_PARAM3, middleText);
        args.putString(ARG_PARAM4, rightText);
        args.putString(ARG_PARAM5, content);
        fragment.setArguments(args);
        return fragment;
    }

    public ThreeButtonDialogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_PARAM1);
            leftText = getArguments().getString(ARG_PARAM2);
            middleText = getArguments().getString(ARG_PARAM3);
            rightText = getArguments().getString(ARG_PARAM4);
            content = getArguments().getString(ARG_PARAM5);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.fragment_three_button_dialog, container, false);
        txtvTitle = (TextView)mRootView.findViewById(R.id.txtvTitle);
        txtvContent = (TextView)mRootView.findViewById(R.id.txtvContent);
        txtvLeft = (TextView)mRootView.findViewById(R.id.txtvLeft);
        txtvMiddle = (TextView)mRootView.findViewById(R.id.txtvMiddle);
        txtvRight = (TextView)mRootView.findViewById(R.id.txtvRight);
        txtvTitle.setText(title);
        txtvContent.setText(content);
        txtvLeft.setText(leftText);
        txtvMiddle.setText(middleText);
        txtvRight.setText(rightText);
        return mRootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        refreshStyle();
    }

    public void leftOrRight(boolean isLeft){
        if(isLeft){
            if(index == 0){
                index = 2;
            }else{
                index --;
            }
        }else{
            if(index == 2){
                index = 0;
            }else{
                index ++;
            }
        }
        refreshStyle();
    }


    public synchronized void refreshStyle(){
        txtvLeft.setSelected(false);
        txtvMiddle.setSelected(false);
        txtvRight.setSelected(false);
        switch (index){
            case 0:
                txtvLeft.setSelected(true);
                break;
            case 1:
                txtvMiddle.setSelected(true);
                break;
            case 2:
                txtvRight.setSelected(true);
                break;
        }
    }

}
