package com.uni.applicationwangone.data;

import com.uni.applicationwangone.data.model.jz_bean.MenuInfo;

import java.util.ArrayList;

/**
 * Created by Joe on 2016/6/24.
 * Email-joe_zong@163.com
 */
public class JzMenuMgr {
    public static ArrayList<MenuInfo> getMenuInfo(String menuTitle, String menuText){
        ArrayList<MenuInfo> list = new ArrayList<>();
        if(menuTitle.equals("菜单管理")){
            switch (menuText){
                case "测值显示":
                    list.add(new MenuInfo("保护量显示",false));
                    list.add(new MenuInfo("测量量显示",false));
                    list.add(new MenuInfo("开入量显示",false));
                    list.add(new MenuInfo("软压板显示",false));
                    break;
                case "报告显示":
                    break;
                case "调试操作":
                    break;
                case "定值设置":
                    break;
                case "装置打印":
                    break;
                case "版本信息":
                    break;
                case "时间设置":
                    break;
            }
        }
        return list;
    }
}
