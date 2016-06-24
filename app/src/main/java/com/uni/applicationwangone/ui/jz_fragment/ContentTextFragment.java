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

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 */
public class ContentTextFragment extends BaseFragment {

    @Bind(R.id.txtvContent)
    TextView txtvContent;
    private View mRootView;
    private ArrayList<ContentTextBean> contentTextBeanList;
    private int itemPostion=0;

    public static ContentTextFragment newInstance(ArrayList<ContentTextBean> contentTextBean) {
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
            contentTextBeanList = (ArrayList<ContentTextBean>)getArguments().getSerializable(ContentTextBean.class.getSimpleName());
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
        if(contentTextBeanList!=null){
            ContentTextBean bean = contentTextBeanList.get(itemPostion);
            txtvContent.setText(bean.text);
            if(bean.gravity == JzMenuMgr.Content_Gravity_Center){
                txtvContent.setGravity(Gravity.CENTER_HORIZONTAL);
            }else{
                txtvContent.setGravity(Gravity.LEFT);
            }
        }
    }


    @Override
    public boolean cancel() {
        goBack();
        return super.cancel();
    }
}
