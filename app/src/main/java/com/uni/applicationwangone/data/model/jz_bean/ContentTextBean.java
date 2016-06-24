package com.uni.applicationwangone.data.model.jz_bean;

import java.io.Serializable;

/**
 * Created by Joe on 2016/6/24.
 * Email-joe.zong@xiaoniubang.com
 */
public class ContentTextBean implements Serializable{
    public int gravity;
    public String text;

    public ContentTextBean(String text, int gravity) {
        this.text = text;
        this.gravity = gravity;
    }

    public ContentTextBean() {
    }
}
