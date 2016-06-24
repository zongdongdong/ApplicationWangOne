package com.uni.applicationwangone.ui.jz_fragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uni.applicationwangone.R;
import com.uni.applicationwangone.data.JzMenuMgr;
import com.uni.applicationwangone.data.model.jz_bean.ContentTextBean;
import com.uni.applicationwangone.ui.fragments.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 */
public class ContentTextFragment extends BaseFragment {

    @Bind(R.id.txtvContent)
    TextView txtvContent;
    private View mRootView;
    private ContentTextBean contentTextBean;

    public static ContentTextFragment newInstance(ContentTextBean contentTextBean) {
        ContentTextFragment fragment = new ContentTextFragment();
        Bundle args = new Bundle();
        args.putSerializable(ContentTextBean.class.getSimpleName(),contentTextBean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            contentTextBean = (ContentTextBean)getArguments().getSerializable(ContentTextBean.class.getSimpleName());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(mRootView == null){
            mRootView = inflater.inflate(R.layout.fragment_content_text, container, false);
            ButterKnife.bind(this, mRootView);
            bindData();
        }
        return mRootView;
    }

    public void bindData(){
        if(contentTextBean!=null){
            txtvContent.setText(contentTextBean.text);
            if(contentTextBean.gravity == JzMenuMgr.Content_Gravity_Center){
                txtvContent.setText(Gravity.CENTER_HORIZONTAL);
            }
        }
    }


    @Override
    public boolean cancel() {
        goBack();
        return super.cancel();
    }
}
