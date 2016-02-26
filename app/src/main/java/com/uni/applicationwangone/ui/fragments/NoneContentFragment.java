package com.uni.applicationwangone.ui.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uni.applicationwangone.R;

/**
 * 无内容提示
 */
public class NoneContentFragment extends BaseFragment {
    private View mRootView;

    public static NoneContentFragment newInstance(String param1, String param2) {
        NoneContentFragment fragment = new NoneContentFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.fragment_none_content, container, false);
        return mRootView;
    }

}
