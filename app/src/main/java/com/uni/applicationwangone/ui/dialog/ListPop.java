package com.uni.applicationwangone.ui.dialog;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.uni.applicationwangone.R;
import com.uni.applicationwangone.ui.adapter.PopListViewAdapter;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/10/15.
 */
public class ListPop extends PopupWindow{
    private Context mContext;
    private ListView listview;
    private String[] datas;
    private PopListViewAdapter adapter;
    private int itemHeight;
    private int itemMaxWidth;

    public ListPop(Context aContext,String[] datas){
        this.mContext = aContext;
        this.datas = datas;
        this.setWidth(LayoutParams.WRAP_CONTENT);
        this.setHeight(LayoutParams.WRAP_CONTENT);
        View view = LayoutInflater.from(aContext).inflate(R.layout.list_pop_view, null);
        initView(view);
        this.setContentView(view);
//        this.setOutsideTouchable(true);
//        this.setFocusable(true);
//        this.setBackgroundDrawable(new ColorDrawable(0x00000000));
    }
    public void initView(View view){
        listview = (ListView)view.findViewById(R.id.listview);
        adapter = new PopListViewAdapter(mContext,datas);
        listview.setAdapter(adapter);
        this.setWidth(meathureWidthByChilds());
    }

    public void refreshStyle(int position){
        if(adapter!=null){
            adapter.refreshStyle(position);
        }
    }

    public int getMenuCount(){
        if(adapter!=null){
            return adapter.getCount();
        }
        return 0;
    }

    public View getLevelViewForPosition(int position){
        View view = null;
        if(adapter!=null){
            view = (TextView)adapter.getView(position, view, null).findViewById(R.id.txtvValue);
            view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
            float x = view.getX();
            float y = view.getY();
        }
        return view;
    }

    public int getItemHeight() {
        return itemHeight;
    }

    public int getItemMaxWidth() {
        return itemMaxWidth;
    }

    public String getLevelTextForPosition(int position){
        if(adapter!=null){
            return String.valueOf(adapter.getItem(position));
        }
        return "";
    }

    public int meathureWidthByChilds() {
        int maxWidth = 0;
        View view = null;
        for (int i = 0; i < adapter.getCount(); i++) {
            view = adapter.getView(i, view, null);
            view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
            if (view.getMeasuredWidth() > maxWidth){
                maxWidth = view.getMeasuredWidth();
                itemHeight = view.getMeasuredHeight();
            }
        }
        itemMaxWidth = maxWidth;
        return maxWidth;
    }
}
