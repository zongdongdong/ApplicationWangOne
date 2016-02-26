package com.uni.applicationwangone.ui.views;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2014/12/31.
 */
public class ViewPagerNoTouch extends ViewPager{
    private boolean isScrollable = false;
    public ViewPagerNoTouch(Context context) {
        super(context);
    }

    public ViewPagerNoTouch(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public void setScrollable(boolean isScrollable){
        this.isScrollable = isScrollable;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (isScrollable == false) {
            return false;
        } else {
            return super.onTouchEvent(ev);
        }

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (isScrollable == false) {
            return false;
        } else {
            return super.onInterceptTouchEvent(ev);
        }

    }
}
