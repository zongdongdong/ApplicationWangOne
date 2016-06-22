package com.uni.applicationwangone.ui.NewFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uni.applicationwangone.R;
import com.uni.applicationwangone.ui.activity.BaseActivity;
import com.uni.applicationwangone.ui.activity.MainActivity;
import com.uni.applicationwangone.ui.fragments.BaseFragment;
import com.uni.applicationwangone.ui.util.UIHelper;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 保护装置仿真系统
 */
public class ProtectionDeviceStytemFragment extends BaseFragment {

    @Bind(R.id.txtvTitle)
    TextView txtvTitle;
    private View mRootView;

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
        mRootView = inflater.inflate(R.layout.fragment_protection_device_stytem, container, false);
        ButterKnife.bind(this, mRootView);
        txtvTitle.setText("保护装置仿真系统");
        return mRootView;
    }


    public void goMainActivity() {
        startActivity(new Intent(getActivity(), MainActivity.class));
    }

    public void showEmptyMessage() {
        UIHelper.showToast(getActivity(), "暂未开放");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @OnClick({R.id.btn1, R.id.btn2,R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btn10})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn7:
                goMainActivity();
                break;
            default:
                showEmptyMessage();
                break;
        }
    }

    @OnClick(R.id.txtvLeft)
    public void onBack(View view) {
        ((BaseActivity) getActivity()).onBackPressed();
    }
}
