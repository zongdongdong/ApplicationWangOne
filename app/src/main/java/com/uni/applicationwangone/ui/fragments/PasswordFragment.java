package com.uni.applicationwangone.ui.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.uni.applicationwangone.R;

public class PasswordFragment extends BaseFragment {
    private View mRootView;
    private TextView txtvOne,txtvTwo,txtvThree;
    private int index = 0;

    public static PasswordFragment newInstance(String param1) {
        PasswordFragment fragment = new PasswordFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public PasswordFragment() {
        // Required empty public constructor
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
        mRootView = inflater.inflate(R.layout.fragment_password, container, false);
        txtvOne = (TextView)mRootView.findViewById(R.id.textvOne);
        txtvTwo = (TextView)mRootView.findViewById(R.id.textvTwo);
        txtvThree = (TextView)mRootView.findViewById(R.id.textvThree);
        return mRootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        refreshStyle();
    }

    public void topOrBottom(boolean isTop){
        TextView view = null;
        switch (index){
            case 0:
                view = txtvOne;
                break;
            case 1:
                view = txtvTwo;
                break;
            case 2:
                view = txtvThree;
                break;
        }
        int oneValue = Integer.parseInt(view.getText().toString());
        if(isTop){
            if(oneValue == 9){
                view.setText("0");
            }else{
                oneValue++;
                view.setText(""+oneValue);
            }
        }else{
            if(oneValue == 0){
                view.setText("9");
            }else{
                oneValue--;
                view.setText(""+oneValue);
            }
        }
    }

    public void leftOrRight(boolean isLeft){
        if(isLeft){
            if(index == 0){
                index = 2;
            }else{
                index --;
            }
        }else{
            if(index == 2){
                index = 0;
            }else{
                index ++;
            }
        }
        refreshStyle();
    }

    public synchronized boolean validatePassword(){
        String value = txtvOne.getText().toString()+txtvTwo.getText().toString()+txtvThree.getText().toString();
        boolean isSuccess =  value.equals("800");
        if(!isSuccess){
            Toast.makeText(getActivity(),"正确口令\"800\"",Toast.LENGTH_LONG).show();
        }
        return isSuccess;
    }

    public synchronized void refreshStyle(){
        txtvOne.setSelected(false);
        txtvTwo.setSelected(false);
        txtvThree.setSelected(false);
        switch(index){
            case 0:
                txtvOne.setSelected(true);
                break;
            case 1:
                txtvTwo.setSelected(true);
                break;
            case 2:
                txtvThree.setSelected(true);
                break;
        }
    }
}
