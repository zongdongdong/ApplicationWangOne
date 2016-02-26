package com.uni.applicationwangone.ui.fragments;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.uni.applicationwangone.R;
import com.uni.applicationwangone.ui.views.ViewPagerNoTouch;

import java.util.ArrayList;
import java.util.List;

/**
 * GOOSE软压板
 */
public class SettingViewPagerFragment extends BaseFragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private LayoutInflater inflater;
    private View mRootView;
    private ViewPagerNoTouch viewPager;
    private TextView txtvTitle, txtvSelectedPage,txtvTotalPage;
    private SettingViewPagerAdapter adapter;
    private  List<List<String>> datas;
    private List<View> mListViews = new ArrayList<>();

    private String title;
    private String Status1="退出";
    private String Status2="投入";


    private int pageIndex = 0;
    private int itemIndex = 0;
    private int maxItemValue;
    private ListView listView;
    private SettingListViewAdapter settingListViewAdapter;

    public static SettingViewPagerFragment newInstance(String title) {
        SettingViewPagerFragment fragment = new SettingViewPagerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, title);
        fragment.setArguments(args);
        return fragment;
    }

    public SettingViewPagerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.inflater = inflater;
        getData();
        mRootView = inflater.inflate(R.layout.fragment_goose_ruan_ya_ban, container, false);
        viewPager = (ViewPagerNoTouch)mRootView.findViewById(R.id.viewPager);
        adapter = new SettingViewPagerAdapter();
        viewPager.setAdapter(adapter);
        txtvTitle = (TextView)mRootView.findViewById(R.id.txtvTitle);
        txtvSelectedPage = (TextView)mRootView.findViewById(R.id.txtvSelectedPage);
        txtvTotalPage = (TextView)mRootView.findViewById(R.id.txtvTotalPage);
        txtvTitle.setText(title);
        txtvSelectedPage.setText(String.format("%04d", 1) + "");
        txtvTotalPage.setText(String.format("%04d", datas.size()) + "");
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                txtvSelectedPage.setText(String.format("%04d", (position + 1)) + "");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return mRootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData(false);
    }

    public void topOrBottom(boolean isTop){
        if(isTop){
            if(itemIndex == 0){
                if(pageIndex>0){
                    pageIndex--;
                    viewPager.setCurrentItem(pageIndex);
                    initData(true);
                }
            }else{
                itemIndex --;
                refreshStyle();
            }
        }else{
            if(itemIndex == (maxItemValue-1)){
                if(pageIndex<(adapter.getCount()-1)){
                    pageIndex++;
                    viewPager.setCurrentItem(pageIndex);
                    initData(false);
                }
            }else{
                itemIndex ++;
                refreshStyle();
            }
        }
    }

    public synchronized void leftOrRight(boolean isLeft){
        View view = listView.getChildAt(itemIndex);
        switch (title){
            case "GOOSE软压板":
            case "保护软压板":
            case "SV接受软压板":
            case "差动保护控制值":
                TextView txtvSetting = (TextView)view.findViewById(R.id.txtvSetting);
                String value = txtvSetting.getText().toString();
                if(value.equals(Status1)){
                    txtvSetting.setText(Status2);
                }else{
                    txtvSetting.setText(Status1);
                }
                break;
            case "差动保护定值":
                break;
        }


    }

    public void refreshStyle(){
        settingListViewAdapter.refresh(itemIndex);
    }

    public synchronized void initData(boolean isPrePage){
        View view = mListViews.get(pageIndex);
        listView = (ListView)view.findViewById(R.id.listview);
        settingListViewAdapter = (SettingListViewAdapter)listView.getAdapter();
        maxItemValue = settingListViewAdapter.getCount();
        if(isPrePage){
            itemIndex = maxItemValue - 1;
        }else{
            itemIndex = 0;
        }
    }

    class SettingViewPagerAdapter extends PagerAdapter {

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mListViews.get(position));
            return mListViews.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mListViews.get(position));
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view == o;
        }
    }

    class SettingListViewAdapter extends BaseAdapter{
        List<String> ls;
        int defaultIndex = 0;

        public SettingListViewAdapter(List<String> ls) {
            this.ls = ls;
        }

        public void refresh(int position){
            defaultIndex = position;
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return ls.size();
        }

        @Override
        public Object getItem(int i) {
            return ls.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView txtvTitle,txtvSetting;
            if(view == null){
                switch (title){
                    case "GOOSE软压板":
                    case "保护软压板":
                    case "SV接受软压板":
                        view = inflater.inflate(R.layout.adapter_goose_listview,null);
                        break;
                    case "差动保护控制值":
                        view = inflater.inflate(R.layout.adapter_setting_vierpager_01,null);
                        break;
                }
            }
            txtvTitle = (TextView)view.findViewById(R.id.txtvTitle);
            txtvSetting = (TextView)view.findViewById(R.id.txtvSetting);
            txtvTitle.setText(ls.get(i));
            if(defaultIndex == i){
                txtvSetting.setSelected(true);
            }else{
                txtvSetting.setSelected(false);
            }
            return view;
        }
    }

    public void getData(){
        datas = new ArrayList<>();
        switch (title){
            case "GOOSE软压板":
                Status1="退出";
                Status2="投入";
                List<String> ls = new ArrayList<>();
                ls.add("跳高压侧软压板");
                ls.add("跳中压侧软压板");
                ls.add("跳低压侧1分支软压板");
                ls.add("跳低压侧2分支软压板");
                ls.add("跳高压侧桥分支软压板");
                ls.add("跳闸备用1软压板");
                datas.add(ls);

                List<String> ls1 = new ArrayList<>();
                ls1.add("跳闸备用2软压板");
                ls1.add("跳闸备用3软压板");
                ls1.add("跳闸备用4软压板");
                ls1.add("跳闸备用5软压板");
                ls1.add("跳闸备用6软压板");
                ls1.add("跳闸备用7软压板");
                datas.add(ls1);

                List<String> ls2 = new ArrayList<>();
                ls2.add("跳闸备用8软压板");
                ls2.add("跳闸备用9软压板");
                ls2.add("跳闸备用10软压板");
                datas.add(ls2);
                break;
            case "保护软压板":
                Status1="退出";
                Status2="投入";
                List<String> baohuLs = new ArrayList<>();
                baohuLs.add("远方修改定值投入");
                baohuLs.add("远方切换定值区投入");
                baohuLs.add("远方控制压板投入");
                baohuLs.add("差动保护投入");
                datas.add(baohuLs);
                break;
            case "SV接受软压板":
                Status1="退出";
                Status2="投入";
                List<String> svLs = new ArrayList<>();
                svLs.add("高侧电流SV投入");
                svLs.add("高桥侧电流SV投入");
                svLs.add("中侧电流SV投入");
                svLs.add("低1分支电流SV投入");
                svLs.add("低2分支电流SV投入");
                datas.add(svLs);
                break;
            case "差动保护控制值":
                Status1="0";
                Status2="1";
                List<String> kzLs = new ArrayList<>();
                kzLs.add("纵差差动速断");
                kzLs.add("纵差差动保护");
                kzLs.add("二次谐波制动");
                kzLs.add("CT断线闭锁差动保护");
                datas.add(kzLs);
                break;
        }
        for(int i = 0;i<datas.size();i++){
            View view = inflater.inflate(R.layout.adapter_goose_viewpager, null);
            ListView listView = (ListView)view.findViewById(R.id.listview);
            SettingListViewAdapter gooseListViewAdapter = new SettingListViewAdapter(datas.get(i));
            listView.setAdapter(gooseListViewAdapter);
            mListViews.add(view);
        }
    }

}
