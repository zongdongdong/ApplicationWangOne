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

public class TwoButtonDialogFragment extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    private static final String ARG_PARAM4 = "param4";

    private String title;
    private String content;
    private String leftText;
    private String middleText;
    private String rightText;

    private View mRootView;

    private TextView txtvTitle,txtvContent,txtvLeft,txtvRight;

    public static TwoButtonDialogFragment newInstance(String title,String content, String leftText, String rightText) {
        TwoButtonDialogFragment fragment = new TwoButtonDialogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, title);
        args.putString(ARG_PARAM2, content);
        args.putString(ARG_PARAM3, leftText);
        args.putString(ARG_PARAM4, rightText);
        fragment.setArguments(args);
        return fragment;
    }

    public TwoButtonDialogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_PARAM1);
            content = getArguments().getString(ARG_PARAM2);
            leftText = getArguments().getString(ARG_PARAM3);
            rightText = getArguments().getString(ARG_PARAM4);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_two_button_dialog, container, false);

        txtvTitle = (TextView)mRootView.findViewById(R.id.txtvTitle);
        txtvContent = (TextView)mRootView.findViewById(R.id.txtvContent);
        txtvLeft = (TextView)mRootView.findViewById(R.id.txtvLeft);
        txtvRight = (TextView)mRootView.findViewById(R.id.txtvRight);
        txtvTitle.setText(title);
        txtvContent.setText(content);
        txtvLeft.setText(leftText);
        txtvRight.setText(rightText);
        txtvLeft.setSelected(true);
        return mRootView;
    }

    public void leftOrRight(boolean isLeft){
        if(txtvLeft.isSelected()){
            txtvLeft.setSelected(false);
            txtvRight.setSelected(true);
        }else if(txtvRight.isSelected()){
            txtvLeft.setSelected(true);
            txtvRight.setSelected(false);
        }
    }
}
