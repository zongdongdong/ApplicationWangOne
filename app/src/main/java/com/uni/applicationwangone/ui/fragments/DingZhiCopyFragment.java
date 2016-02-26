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
 * 定值拷贝
 */
public class DingZhiCopyFragment extends BaseFragment {

    private View mRootView;

    public static DingZhiCopyFragment newInstance() {
        DingZhiCopyFragment fragment = new DingZhiCopyFragment();
        return fragment;
    }

    public DingZhiCopyFragment() {
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
        mRootView = inflater.inflate(R.layout.fragment_ding_zhi_copy, container, false);;
        return mRootView;
    }
}
