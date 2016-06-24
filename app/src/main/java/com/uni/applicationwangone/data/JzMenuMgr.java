package com.uni.applicationwangone.data;

import com.uni.applicationwangone.data.model.jz_bean.ContentListInfoBean;
import com.uni.applicationwangone.data.model.jz_bean.ContentTextBean;
import com.uni.applicationwangone.data.model.jz_bean.ContentTipBean;
import com.uni.applicationwangone.data.model.jz_bean.MenuInfo;

import java.util.ArrayList;

/**
 * Created by Joe on 2016/6/24.
 * Email-joe_zong@163.com
 */
public class JzMenuMgr {
    public static final int Menu_List = 0;
    public static final int Content_List = 1;
    public static final int Content_Text = 2;
    public static final int Content_Page = 3;
    public static final int Content_Tip = 4;

    public static final int Content_Gravity_Center = 0;
    public static final int Content_Gravity_Left = 1;

    public static ArrayList<MenuInfo> getMenuInfo(String menuTitle, String menuText){
        ArrayList<MenuInfo> list = new ArrayList<>();
        if(menuTitle.equals("菜单管理")){
            switch (menuText){
                case "测值显示":
                    list.add(new MenuInfo("保护量显示",Content_List));
                    list.add(new MenuInfo("测量量显示",Content_List));
                    list.add(new MenuInfo("开入量显示",Menu_List));
                    list.add(new MenuInfo("软压板显示",Menu_List));
                    break;
                case "报告显示":
                    list.add(new MenuInfo("动作报告",Menu_List));
                    list.add(new MenuInfo("遥信报告",Menu_List));
                    list.add(new MenuInfo("操作报告",Menu_List));
                    list.add(new MenuInfo("运行报告",Menu_List));
                    list.add(new MenuInfo("自检报告",Menu_List));
                    break;
                case "调试操作":
                    list.add(new MenuInfo("遥信顺序试验",Menu_List));
                    list.add(new MenuInfo("遥信选点试验",Menu_List));
                    list.add(new MenuInfo("遥测信号试验",Menu_List));
                    list.add(new MenuInfo("出口传动试验",Menu_List));
                    break;
                case "定值设置":
                    list.add(new MenuInfo("系统定值",Menu_List));
                    list.add(new MenuInfo("保护定值",Menu_List));
                    list.add(new MenuInfo("通讯参数",Menu_List));
                    list.add(new MenuInfo("辅助参数",Menu_List));
                    list.add(new MenuInfo("软压板初始化",Menu_List));
                    list.add(new MenuInfo("出厂设置",Menu_List));
                    list.add(new MenuInfo("电度清零",Menu_List));
                    list.add(new MenuInfo("精度调整",Menu_List));
                    list.add(new MenuInfo("精度参数设置",Menu_List));
                    break;
                case "装置打印":
                    list.add(new MenuInfo("参数打印",Menu_List));
                    list.add(new MenuInfo("定值打印",Menu_List));
                    list.add(new MenuInfo("动作报告",Menu_List));
                    list.add(new MenuInfo("运行报告",Menu_List));
                    list.add(new MenuInfo("自检报告",Menu_List));
                    list.add(new MenuInfo("遥信报告",Menu_List));
                    list.add(new MenuInfo("状态打印",Menu_List));
                    break;
                case "版本信息":
                    break;
                case "时间设置":
                    break;
            }
        }
        return list;
    }

    public static ContentListInfoBean getContentListInfo(String menuTitle, String menuText){
        ArrayList<ContentListInfoBean.ContentListValueBean> list = new ArrayList<>();
        ContentListInfoBean bean = new ContentListInfoBean();
        if(menuTitle.equals("测值显示")){
            switch (menuText){
                case "保护量显示":
                    bean.setTitle("保护采样值");
                    list.add(new ContentListInfoBean.ContentListValueBean("IA  =  000.00安"));
                    list.add(new ContentListInfoBean.ContentListValueBean("IB  =  000.00安"));
                    list.add(new ContentListInfoBean.ContentListValueBean("IC  =  000.00安"));
                    list.add(new ContentListInfoBean.ContentListValueBean("IO  =  000.00安"));
                    list.add(new ContentListInfoBean.ContentListValueBean("UA  =  000.00伏"));
                    list.add(new ContentListInfoBean.ContentListValueBean("UB  =  000.00伏"));
                    list.add(new ContentListInfoBean.ContentListValueBean("UC  =  000.00伏"));
                    break;
                case "测量量显示":
                    bean.setTitle("遥测量显示");
                    list.add(new ContentListInfoBean.ContentListValueBean("IA  =  00.004A"));
                    list.add(new ContentListInfoBean.ContentListValueBean("IB  =  00.006A"));
                    list.add(new ContentListInfoBean.ContentListValueBean("IC  =  00.006A"));
                    list.add(new ContentListInfoBean.ContentListValueBean("IO  =  000.07A"));
                    list.add(new ContentListInfoBean.ContentListValueBean("UA  =  000.06V"));
                    list.add(new ContentListInfoBean.ContentListValueBean("UB  =  000.05V"));
                    list.add(new ContentListInfoBean.ContentListValueBean("UC  =  000.08V"));
                    break;
                case "开入量显示":
                    break;
                case "软压板显示":
                    break;

            }
        }

        bean.setList(list);
        return bean;
    }

    public static ContentTipBean getContentTipInfo(String menuTitle, String menuText){
        ContentTipBean contentTipBean = new ContentTipBean();
        return contentTipBean;
    }

    public static ContentTextBean getContentTextInfo(String menuTitle, String menuText){
        ContentTextBean contentTextBean = new ContentTextBean();
        return contentTextBean;
    }
}
