package com.uni.applicationwangone.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.uni.applicationwangone.R;
import com.uni.applicationwangone.data.model.jz_bean.MenuInfo;
import com.uni.applicationwangone.ui.fragments.BaseFragment;
import com.uni.applicationwangone.ui.jz_fragment.MenuListFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class JzMainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jz_main);
        ButterKnife.bind(this);
        transformFragment(R.id.container_frame,MenuListFragment.newInstance("菜单管理", getData()), true, true);
    }

    public void transform(Fragment fragment){
        transformFragment(R.id.container_frame,fragment, true, true);
    }

    public  ArrayList<MenuInfo> getData(){
        ArrayList<MenuInfo> list = new ArrayList<>();
        list.add(new MenuInfo("测值显示",true));
        list.add(new MenuInfo("报告显示",true));
        list.add(new MenuInfo("调试操作",true));
        list.add(new MenuInfo("定值设置",true));
        list.add(new MenuInfo("装置打印",true));
        list.add(new MenuInfo("版本信息",true));
        list.add(new MenuInfo("时间设置",true));
        return list;
    }


    @OnClick({R.id.btnTop, R.id.btnLeft, R.id.btnBottom, R.id.btnRight, R.id.btnCancel, R.id.btnConfirm})
    public void onClick(View view) {
        BaseFragment baseFragment = getVisibleFragment();
        switch (view.getId()) {
            case R.id.btnTop:
                baseFragment.top();
                break;
            case R.id.btnLeft:
                baseFragment.left();
                break;
            case R.id.btnBottom:
                baseFragment.bottom();
                break;
            case R.id.btnRight:
                baseFragment.right();
                break;
            case R.id.btnCancel:
                baseFragment.cancel();
                break;
            case R.id.btnConfirm:
                baseFragment.confirm();
                break;
        }
    }
}
