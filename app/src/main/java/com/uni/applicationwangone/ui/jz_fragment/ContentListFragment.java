package com.uni.applicationwangone.ui.jz_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

import com.uni.applicationwangone.R;
import com.uni.applicationwangone.data.model.jz_bean.ContentListInfoBean;
import com.uni.applicationwangone.ui.adapter.jz.ContentListAdapter;
import com.uni.applicationwangone.ui.fragments.BaseFragment;
import com.uni.applicationwangone.ui.util.UIHelper;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 列表内容
 */
public class ContentListFragment extends BaseFragment {
    @Bind(R.id.txtvTitle)
    TextView txtvTitle;
    @Bind(R.id.lvContent)
    ListView lvContent;
    private View mRootView;
    private ContentListAdapter adapter;
    int currentFirstVisibleItem = 0;
    int currentVsibleItemCount = 0;
    int currentTotalItemCount = 0;

    private ContentListInfoBean contentListInfoBean;

    public static ContentListFragment newInstance(ContentListInfoBean bean) {
        ContentListFragment fragment = new ContentListFragment();
        Bundle args = new Bundle();
        args.putSerializable(ContentListInfoBean.class.getSimpleName(),bean);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            contentListInfoBean = (ContentListInfoBean)getArguments().getSerializable(ContentListInfoBean.class.getSimpleName());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(mRootView == null){
            mRootView = inflater.inflate(R.layout.fragment_content_list, container, false);
            ButterKnife.bind(this, mRootView);
            bindData();
            setClickListeners();
        }
        return mRootView;
    }

    public void bindData(){
        if(contentListInfoBean!=null){
            txtvTitle.setText(contentListInfoBean.getTitle());
            adapter = new ContentListAdapter();
            lvContent.setAdapter(adapter);
            adapter.refresh(contentListInfoBean.list);
            lvContent.setEnabled(false);
        }
    }

    public void setClickListeners(){
        lvContent.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                currentFirstVisibleItem = firstVisibleItem;
                currentVsibleItemCount = visibleItemCount;
                currentTotalItemCount = totalItemCount;
//                UIHelper.showToast(getActivity(),""+firstVisibleItem+","+visibleItemCount+","+totalItemCount);
            }
        });
    }

    @Override
    public void top() {
        super.top();

        int selectPostion = adapter.getSelectPosition();
        if(selectPostion == 0){
            return;
        }
        if(selectPostion<(currentVsibleItemCount-1)){
            selectPostion-=1;
            adapter.selectItem(selectPostion);
            lvContent.setSelection(0);
        }else {
//            UIHelper.showToast(getActivity(), "" + currentVsibleItemCount + "," + selectPostion + "," + (currentVsibleItemCount - selectPostion));
            adapter.selectItem((selectPostion - 1));
            lvContent.setSelection((selectPostion - 1));
        }
    }

    @Override
    public void bottom() {
        super.bottom();
        int selectPostion = adapter.getSelectPosition();
        if(selectPostion == (adapter.getCount()-1)){
            return;
        }
        if((selectPostion+1)==(currentFirstVisibleItem+currentVsibleItemCount-1)){
            selectPostion+=1;
            if(selectPostion<adapter.getCount()){
                adapter.selectItem(selectPostion);
                lvContent.setSelection(selectPostion);
            }
        }else{
            selectPostion+=1;
            adapter.selectItem(selectPostion);
        }

//        int selectPostion = adapter.getSelectPosition();
//        if(selectPostion == (currentTotalItemCount-1)){
//            return;
//        }
//        if((selectPostion+1)==(currentFirstVisibleItem+currentVsibleItemCount)){
//            selectPostion+=1;
//            if(selectPostion<adapter.getCount()){
//                adapter.selectItem(selectPostion);
//                lvContent.setSelection(selectPostion);
//            }
//        }else{
//            selectPostion+=1;
//            adapter.selectItem(selectPostion);
//        }
    }

    @Override
    public void left() {
        super.left();
    }

    @Override
    public void right() {
        super.right();
    }

    @Override
    public boolean confirm() {
        return super.confirm();
    }

    @Override
    public boolean cancel() {
        goBack();
        return super.cancel();
    }
}
