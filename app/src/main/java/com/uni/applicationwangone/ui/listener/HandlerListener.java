package com.uni.applicationwangone.ui.listener;

/**
 * Created by Dong on 2016/2/26.
 */
public interface HandlerListener {
    boolean confirm();
    boolean cancel();
    void top();
    void bottom();
    void left();
    void right();
}
