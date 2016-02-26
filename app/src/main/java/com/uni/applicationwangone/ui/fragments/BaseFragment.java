package com.uni.applicationwangone.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uni.applicationwangone.R;
import com.uni.applicationwangone.ui.listener.FragementType;
import com.uni.applicationwangone.ui.listener.HandlerListener;

public class BaseFragment extends Fragment implements HandlerListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean cancel() {
        return true;
    }

    @Override
    public boolean confirm() {
        return false;
    }

    @Override
    public void bottom() {

    }

    @Override
    public void top() {

    }

    @Override
    public void left() {

    }

    @Override
    public void right() {

    }
}
