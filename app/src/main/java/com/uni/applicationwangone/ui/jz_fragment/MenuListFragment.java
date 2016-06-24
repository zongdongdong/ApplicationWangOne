package com.uni.applicationwangone.ui.jz_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

import com.uni.applicationwangone.R;
import com.uni.applicationwangone.data.JzMenuMgr;
import com.uni.applicationwangone.data.model.jz_bean.ContentListInfoBean;
import com.uni.applicationwangone.data.model.jz_bean.MenuInfo;
import com.uni.applicationwangone.ui.activity.JzMainActivity;
import com.uni.applicationwangone.ui.adapter.jz.MenuListAdapter;
import com.uni.applicationwangone.ui.fragments.BaseFragment;
import com.uni.applicationwangone.ui.util.UIHelper;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 *
 */
public class MenuListFragment extends BaseFragment {
    @Bind(R.id.txtvTitle)
    TextView txtvTitle;
    @Bind(R.id.lvMenu)
    ListView lvMenu;
    private View mRootView;
    private MenuListAdapter adapter;
    int currentFirstVisibleItem = 0;
    int currentVsibleItemCount = 0;
    int currentTotalItemCount = 0;

    private String menuTitle;
    private ArrayList<MenuInfo> menuInfoList;

    public static MenuListFragment newInstance(String title, ArrayList<MenuInfo> menuInfos) {
        MenuListFragment fragment = new MenuListFragment();
        Bundle args = new Bundle();
        args.putString("menuTitle",title);
        args.putSerializable("menuData",menuInfos);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            menuTitle = getArguments().getString("menuTitle");
            menuInfoList = (ArrayList<MenuInfo>)getArguments().getSerializable("menuData");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(mRootView==null){
            mRootView = inflater.inflate(R.layout.fragment_menu_list, container, false);
            ButterKnife.bind(this, mRootView);
            bindData();
            setClickListeners();
        }
        return mRootView;
    }

    public void bindData(){
        txtvTitle.setText(menuTitle);
        adapter = new MenuListAdapter();
        lvMenu.setAdapter(adapter);
        adapter.refresh(menuInfoList);
        lvMenu.setEnabled(false);
    }

    public void setClickListeners(){
        lvMenu.setOnScrollListener(new AbsListView.OnScrollListener() {
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
            lvMenu.setSelection(0);
        }else {
//            UIHelper.showToast(getActivity(), "" + currentVsibleItemCount + "," + selectPostion + "," + (currentVsibleItemCount - selectPostion));
            adapter.selectItem((selectPostion - 1));
            lvMenu.setSelection((selectPostion - 1));
        }

//
//        int selectPostion = adapter.getSelectPosition();
//        if(selectPostion == 0){
//            return;
//        }
//        if(selectPostion == currentFirstVisibleItem){
////            UIHelper.showToast(getActivity(), "" + currentVsibleItemCount + "," + selectPostion + "," + (currentVsibleItemCount - selectPostion));
//            adapter.selectItem((selectPostion - 1));
//            if(selectPostion<currentVsibleItemCount){
//                lvMenu.setSelection(0);
//            }else{
//                lvMenu.setSelection(Math.abs(selectPostion - currentVsibleItemCount));
//            }
//        }else{
//            selectPostion-=1;
//            adapter.selectItem(selectPostion);
//        }
    }

    @Override
    public void right() {
        super.right();
//        UIHelper.showToast(getActivity(), "right");
    }

    @Override
    public void left() {
        super.left();
//        UIHelper.showToast(getActivity(), "left");
    }

    @Override
    public boolean confirm() {
//        UIHelper.showToast(getActivity(),"confirm");
        int selectPostion = adapter.getSelectPosition();
        MenuInfo menuInfo = (MenuInfo)adapter.getItem(selectPostion);
        if(menuInfo.childIsMenu == JzMenuMgr.Menu_List){
            ((JzMainActivity)getActivity()).transform(MenuListFragment.newInstance(menuInfo.value, JzMenuMgr.getMenuInfo(menuTitle,menuInfo.value)));
        }else if(menuInfo.childIsMenu == JzMenuMgr.Content_List){
            ((JzMainActivity)getActivity()).transform(ContentListFragment.newInstance(JzMenuMgr.getContentListInfo(menuTitle,menuInfo.value)));
        }else if(menuInfo.childIsMenu == JzMenuMgr.Content_Text){
            ((JzMainActivity)getActivity()).transform(ContentTextFragment.newInstance(JzMenuMgr.getContentTextInfo(menuTitle, menuInfo.value)));
        }else if(menuInfo.childIsMenu == JzMenuMgr.Content_Tip){
            ((JzMainActivity)getActivity()).transform(ContentTipFragment.newInstance(JzMenuMgr.getContentTipInfo(menuTitle, menuInfo.value)));
        }else if(menuInfo.childIsMenu == JzMenuMgr.Content_Toast){
            UIHelper.showToast(getActivity(),JzMenuMgr.getContentToastInfo(menuTitle, menuInfo.value).toast);
        }

        return super.confirm();
    }

    @Override
    public void bottom() {
        super.bottom();
        int selectPostion = adapter.getSelectPosition();
        if(selectPostion == (currentTotalItemCount-1)){
            return;
        }
        if((selectPostion+1)==(currentFirstVisibleItem+currentVsibleItemCount-1)){
            selectPostion+=1;
            if(selectPostion<adapter.getCount()){
                adapter.selectItem(selectPostion);
                lvMenu.setSelection(selectPostion);
            }
        }else{
            selectPostion+=1;
            adapter.selectItem(selectPostion);
        }
    }

    @Override
    public boolean cancel() {
//        UIHelper.showToast(getActivity(),"cancel");
        goBack();
        return super.cancel();
    }
}
