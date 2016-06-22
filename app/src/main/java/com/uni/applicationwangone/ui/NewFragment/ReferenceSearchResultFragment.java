package com.uni.applicationwangone.ui.NewFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.uni.applicationwangone.R;
import com.uni.applicationwangone.data.model.ReferenceBean;
import com.uni.applicationwangone.ui.activity.BaseActivity;
import com.uni.applicationwangone.ui.adapter.QXSearchResultAdapter;
import com.uni.applicationwangone.ui.fragments.BaseFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 搜索结果
 */
public class ReferenceSearchResultFragment extends BaseFragment {
    @Bind(R.id.txtvTitle)
    TextView txtvTitle;
    @Bind(R.id.listview)
    ListView listview;
    private QXSearchResultAdapter adapter;

    private View mRootView;
    private ArrayList<ReferenceBean> referenceBeanList;

    public static ReferenceSearchResultFragment newInstance(ArrayList<ReferenceBean> list) {
        ReferenceSearchResultFragment fragment = new ReferenceSearchResultFragment();
        Bundle args = new Bundle();
        args.putSerializable(ReferenceBean.class.getSimpleName(), list);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            referenceBeanList = (ArrayList<ReferenceBean>) getArguments().getSerializable(ReferenceBean.class.getSimpleName());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_reference_search_result, container, false);
        ButterKnife.bind(this, mRootView);
        setViews();
        setClickListeners();
        return mRootView;
    }

    public void setViews() {
        txtvTitle.setText("缺陷搜索结果");
        adapter = new QXSearchResultAdapter(referenceBeanList);
        listview.setAdapter(adapter);
    }

    public void setClickListeners(){
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                adapter.showMore(position);
            }
        });
    }

    @OnClick(R.id.txtvLeft)
    public void onBack(View view) {
        ((BaseActivity) getActivity()).onBackPressed();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
