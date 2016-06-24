package com.uni.applicationwangone.ui.jz_fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uni.applicationwangone.R;
import com.uni.applicationwangone.data.model.jz_bean.ContentTipBean;
import com.uni.applicationwangone.ui.fragments.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 */
public class ContentTipFragment extends BaseFragment {
    @Bind(R.id.txtvTip)
    TextView txtvTip;
    private View mRootView;
    private ContentTipBean contentTipBean;

    public static ContentTipFragment newInstance(ContentTipBean contentTipBean) {
        ContentTipFragment fragment = new ContentTipFragment();
        Bundle args = new Bundle();
        args.putSerializable(ContentTipBean.class.getSimpleName(),contentTipBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            contentTipBean = (ContentTipBean)getArguments().getSerializable(ContentTipBean.class.getSimpleName());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_content_tip, container, false);
        ButterKnife.bind(this, mRootView);
        bindData();
        return mRootView;
    }

    public void bindData(){
        if(contentTipBean != null){
            txtvTip.setText(contentTipBean.tip);
        }
    }

    @Override
    public boolean cancel() {
        goBack();
        return super.cancel();
    }
}
