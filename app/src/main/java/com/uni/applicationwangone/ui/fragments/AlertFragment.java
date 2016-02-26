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

public class AlertFragment extends BaseFragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String titile;
    private String content;

    private TextView txtvTitle,txtvContent;
    private View mRootView;


    public static AlertFragment newInstance(String title, String content) {
        AlertFragment fragment = new AlertFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, title);
        args.putString(ARG_PARAM2, content);
        fragment.setArguments(args);
        return fragment;
    }

    public AlertFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            titile = getArguments().getString(ARG_PARAM1);
            content = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_alert, container, false);
        txtvTitle = (TextView)mRootView.findViewById(R.id.txtvTitle);
        txtvContent = (TextView)mRootView.findViewById(R.id.txtvContent);
        txtvTitle.setText(titile);
        txtvContent.setText(content);
        return mRootView;
    }

}
