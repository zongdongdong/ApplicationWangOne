package com.uni.applicationwangone.ui.activity;

import android.os.Bundle;

import com.uni.applicationwangone.data.model.ReferenceBean;
import com.uni.applicationwangone.ui.NewFragment.BackendMethodFragment;
import com.uni.applicationwangone.ui.NewFragment.NewMainFragment;
import com.uni.applicationwangone.ui.NewFragment.ProtectionDeviceStytemFragment;
import com.uni.applicationwangone.ui.NewFragment.ReadFragment;
import com.uni.applicationwangone.ui.NewFragment.ReferenceSearchResultFragment;
import com.uni.applicationwangone.ui.NewFragment.ReferenceSystemFragment;

import java.util.ArrayList;

public class NewMainActivity extends BaseActivity {

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
