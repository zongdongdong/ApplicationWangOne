package com.uni.applicationwangone.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.uni.applicationwangone.R;
import com.uni.applicationwangone.data.model.ReferenceBean;
import com.uni.applicationwangone.ui.NewFragment.BackendMethodFragment;
import com.uni.applicationwangone.ui.NewFragment.NewMainFragment;
import com.uni.applicationwangone.ui.NewFragment.ProtectionDeviceStytemFragment;
import com.uni.applicationwangone.ui.NewFragment.ReadFragment;
import com.uni.applicationwangone.ui.NewFragment.ReferenceSearchResultFragment;
import com.uni.applicationwangone.ui.NewFragment.ReferenceSystemFragment;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewMainActivity extends BaseActivityActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        transform(new NewMainFragment(),true,false);
    }

    public void goProtectionDeviceSystem(){
        transform(new ProtectionDeviceStytemFragment(),true,true);
    }

    //消缺参数系统
    public void goReferenceSystem(){
        transform(new ReferenceSystemFragment(),true,true);
    }

    //说明书页面
    public void goRead(){
        transform(new ReadFragment(),true,true);
    }

    public void goBackendMethod(){
        transform(new BackendMethodFragment(),true,true);
    }

    public void goReferenceResult(ArrayList<ReferenceBean> ls){
        transform(ReferenceSearchResultFragment.newInstance(ls),true,true);
    }
}
