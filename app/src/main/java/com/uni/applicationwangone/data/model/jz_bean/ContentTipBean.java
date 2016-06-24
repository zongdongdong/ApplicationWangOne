package com.uni.applicationwangone.data.model.jz_bean;

import java.io.Serializable;

/**
 * Created by Joe on 2016/6/24.
 * Email-joe.zong@xiaoniubang.com
 */
public class ContentTipBean implements Serializable {
    public String title;
    public String tip;

    public ContentTipBean(String title, String tip) {
        this.title = title;
        this.tip = tip;
    }

    public ContentTipBean(String tip) {
        this.tip = tip;
    }

    public ContentTipBean() {
    }
}
