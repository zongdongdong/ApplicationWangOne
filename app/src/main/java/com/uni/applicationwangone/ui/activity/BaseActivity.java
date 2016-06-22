package com.uni.applicationwangone.ui.activity;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.uni.applicationwangone.R;

public class BaseActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    public void transform(Fragment fragment,boolean isAddStack, boolean isAnimation){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(isAnimation){
            transaction.setCustomAnimations( R.anim.slide_in_from_right, R.anim.slide_out_to_left, R.anim.slide_in_from_left,R.anim.slide_out_to_right);
        }
        transaction.replace(R.id.container_frame, fragment, fragment.getClass().getSimpleName());
        if(isAddStack){
            transaction.addToBackStack(fragment.getClass().getSimpleName());
        }
        transaction.commitAllowingStateLoss();
    }

    public void transformFragment(int containerId, Fragment fragment,boolean isAddStack, boolean isAnimation){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if(isAnimation){
            transaction.setCustomAnimations( R.anim.slide_in_from_right, R.anim.slide_out_to_left, R.anim.slide_in_from_left,R.anim.slide_out_to_right);
        }
        transaction.replace(containerId, fragment, fragment.getClass().getSimpleName());
        if(isAddStack){
            transaction.addToBackStack(fragment.getClass().getSimpleName());
        }
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void onBackPressed() {
        goBack();
    }

    public void goBack(){
        if(getSupportFragmentManager().getBackStackEntryCount()>1){
            getSupportFragmentManager().popBackStack();
        }else {
            finish();
        }
    }
}
