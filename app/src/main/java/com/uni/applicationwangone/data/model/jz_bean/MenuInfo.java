package com.uni.applicationwangone.data.model.jz_bean;

import java.io.Serializable;

/**
 * Created by Joe on 2016/6/23.
 * Email-joe.zong@xiaoniubang.com
 */
public class MenuInfo implements Serializable{
    public String value;
    public int childIsMenu;

    public MenuInfo(String value, int childIsMenu) {
        this.value = value;
        this.childIsMenu = childIsMenu;
    }
}
