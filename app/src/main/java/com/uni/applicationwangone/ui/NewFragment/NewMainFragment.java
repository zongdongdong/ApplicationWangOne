package com.uni.applicationwangone.ui.NewFragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.uni.applicationwangone.R;
import com.uni.applicationwangone.ui.AppConstant;
import com.uni.applicationwangone.ui.activity.NewMainActivity;
import com.uni.applicationwangone.ui.common.LoginActivity;
import com.uni.applicationwangone.ui.fragments.BaseFragment;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewMainFragment extends BaseFragment {
    private View mRootView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.fragment_new_main, container, false);
        ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.btnConfig, R.id.btnReference, R.id.btnRead, R.id.btnMethod})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnConfig:
                ((NewMainActivity)getActivity()).goProtectionDeviceSystem();
                break;
            case R.id.btnReference:
                ((NewMainActivity)getActivity()).goReferenceSystem();
                break;
            case R.id.btnRead:
                startActivity(new Intent(getActivity(), LoginActivity.class));
//                ((NewMainActivity)getActivity()).goRead();
                break;
            case R.id.btnMethod:
                ((NewMainActivity)getActivity()).goBackendMethod();
                break;
        }
    }
}
