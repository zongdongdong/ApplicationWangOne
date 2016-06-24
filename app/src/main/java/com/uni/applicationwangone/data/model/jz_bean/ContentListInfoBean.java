package com.uni.applicationwangone.data.model.jz_bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Joe on 2016/6/24.
 * Email-joe.zong@xiaoniubang.com
 */
public class ContentListInfoBean implements Serializable {
    public String title;
    public ArrayList<ContentListValueBean> list;

    public static class ContentListValueBean implements Serializable{
        public String value1;
        public String value2;

        public ContentListValueBean(String value1, String value2) {
            this.value1 = value1;
            this.value2 = value2;
        }

        public ContentListValueBean(String value1) {
            this.value1 = value1;
        }
    }

    public ArrayList<ContentListValueBean> getList() {
        return list;
    }

    public void setList(ArrayList<ContentListValueBean> list) {
        this.list = list;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
