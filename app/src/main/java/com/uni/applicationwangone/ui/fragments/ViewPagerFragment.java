package com.uni.applicationwangone.ui.fragments;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uni.applicationwangone.R;
import com.uni.applicationwangone.data.DataProvider;
import com.uni.applicationwangone.ui.views.ViewPagerNoTouch;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 2015/10/15.
 */
public class ViewPagerFragment extends BaseFragment {

    private String title;
    private String[] datas;
    private View mRootView;
    private ViewPagerNoTouch viewPager;
    private TextView txtvTitle,txtvSelectedPage,txtvTotalPage;
    private LayoutInflater inflater;
    private ViewPagerAdapter adapter;
    private int pageIndex = 0;
    private DataProvider mDataProvider;


    public static ViewPagerFragment newInstance(String title,String[] datas){
        ViewPagerFragment fragment = new ViewPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray("data", datas);
        bundle.putString("title",title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mDataProvider = DataProvider.getInstance(getActivity());
        datas = getArguments().getStringArray("data");
        title = getArguments().getString("title");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        findViews(inflater,container);
        return mRootView;
    }

    public void findViews(LayoutInflater inflater, ViewGroup container){
        this.inflater = inflater;
        mRootView = inflater.inflate(R.layout.fragment_viewpager,container,false);
        viewPager = (ViewPagerNoTouch)mRootView.findViewById(R.id.viewPager);
        txtvTitle = (TextView)mRootView.findViewById(R.id.txtvTitle);
        txtvSelectedPage = (TextView)mRootView.findViewById(R.id.txtvSelectedPage);
        txtvTotalPage = (TextView)mRootView.findViewById(R.id.txtvTotalPage);
        adapter = new ViewPagerAdapter();
        viewPager.setAdapter(adapter);
        txtvTitle.setText(title);
        txtvSelectedPage.setText(String.format("%04d",1)+"");
        txtvTotalPage.setText(String.format("%04d",datas.length)+"");
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pageIndex = position;
                txtvSelectedPage.setText(String.format("%04d",(position + 1)) + "");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void leftPage(){
        if(pageIndex == 0){
            return;
        }
        pageIndex -- ;
        viewPager.setCurrentItem(pageIndex);
    }

    public void rightPage(){
        if(pageIndex == (datas.length-1)){
            return;
        }
        pageIndex++;
        viewPager.setCurrentItem(pageIndex);
    }

    class ViewPagerAdapter extends PagerAdapter {
        private List<View> mListViews = new ArrayList<>();
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = inflater.inflate(R.layout.adapter_viewpager,null);
            TextView txtvValue = (TextView)view.findViewById(R.id.txtvValue);
//            TextView txtvValue = new TextView(getActivity());
            txtvValue.setText(datas[position]);
            container.addView(view);
            mListViews.add(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mListViews.get(position));
        }

        @Override
        public int getCount() {
            return datas.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view == o;
        }
    }
}
