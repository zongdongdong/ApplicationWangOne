package com.uni.applicationwangone.data;

import android.widget.TextView;

import com.uni.applicationwangone.data.model.jz_bean.ContentListInfoBean;
import com.uni.applicationwangone.data.model.jz_bean.ContentTextBean;
import com.uni.applicationwangone.data.model.jz_bean.ContentTipBean;
import com.uni.applicationwangone.data.model.jz_bean.ContentToast;
import com.uni.applicationwangone.data.model.jz_bean.MenuInfo;

import java.util.ArrayList;

/**
 * Created by Joe on 2016/6/24.
 * Email-joe_zong@163.com
 */
public class JzMenuMgr {
    public static final int Content_None = -1;
    public static final int Menu_List = 0;
    public static final int Content_List = 1;
    public static final int Content_Text = 2;
    public static final int Content_Page = 3;
    public static final int Content_Tip = 4;
    public static final int Content_Toast = 5;

    public static final int Content_Gravity_Center = 101;
    public static final int Content_Gravity_Left = 102;

    public static ArrayList<MenuInfo> getMenuInfo(String menuTitle, String menuText){
        ArrayList<MenuInfo> list = new ArrayList<>();
        if(menuTitle.equals("菜单管理")){
            switch (menuText){
                case "测值显示":
                    list.add(new MenuInfo("保护量显示", Content_List));
                    list.add(new MenuInfo("测量量显示",Content_List));
                    list.add(new MenuInfo("开入量显示",Content_List));
                    list.add(new MenuInfo("软压板显示",Content_List));
                    break;
                case "报告显示":
                    list.add(new MenuInfo("动作报告",Content_Text));
                    list.add(new MenuInfo("遥信报告",Content_Text));
                    list.add(new MenuInfo("操作报告",Content_Text));
                    list.add(new MenuInfo("运行报告",Content_Text));
                    list.add(new MenuInfo("自检报告",Content_Tip));
                    break;
                case "调试操作":
                    list.add(new MenuInfo("遥信顺序试验",Content_List));
                    list.add(new MenuInfo("遥信选点试验",Content_List));
                    list.add(new MenuInfo("遥测信号试验",Content_List));
                    list.add(new MenuInfo("出口传动试验",Content_Tip));
                    break;
                case "定值设置":
                    list.add(new MenuInfo("系统定值",Content_List));
                    list.add(new MenuInfo("保护定值",Content_List));
                    list.add(new MenuInfo("通讯参数",Content_List));
                    list.add(new MenuInfo("辅助参数", Content_List));
                    list.add(new MenuInfo("软压板初始化",Content_List));
                    list.add(new MenuInfo("出厂设置",Content_Toast));
                    list.add(new MenuInfo("电度清零",Content_Tip));
                    list.add(new MenuInfo("精度调整",Content_None));
                    list.add(new MenuInfo("精度参数设置",Content_None));
                    break;
                case "装置打印":
                    list.add(new MenuInfo("参数打印",Content_Tip));
                    list.add(new MenuInfo("定值打印",Content_Tip));
                    list.add(new MenuInfo("动作报告", Content_Tip));
                    list.add(new MenuInfo("运行报告",Content_Tip));
                    list.add(new MenuInfo("自检报告",Content_Tip));
                    list.add(new MenuInfo("遥信报告",Content_Tip));
                    list.add(new MenuInfo("状态打印",Content_Tip));
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
                    bean.setTitle("遥信状态");
                    list.add(new ContentListInfoBean.ContentListValueBean("TWJ","： 0"));
                    list.add(new ContentListInfoBean.ContentListValueBean("HWJ","： 0"));
                    list.add(new ContentListInfoBean.ContentListValueBean("KKJ","： 1"));
                    list.add(new ContentListInfoBean.ContentListValueBean("遥控投入","： 0"));
                    list.add(new ContentListInfoBean.ContentListValueBean("接地试跳","： 0"));
                    list.add(new ContentListInfoBean.ContentListValueBean("事故总","： 0"));
                    list.add(new ContentListInfoBean.ContentListValueBean("闭锁重合闸投入","： 0"));
                    break;
                case "软压板显示":
                    bean.setTitle("软压板状态");
                    list.add(new ContentListInfoBean.ContentListValueBean("过流I段投入","： 1"));
                    list.add(new ContentListInfoBean.ContentListValueBean("过流II段投入","： 1"));
                    list.add(new ContentListInfoBean.ContentListValueBean("过流III段投入","： 1"));
                    list.add(new ContentListInfoBean.ContentListValueBean("过流加速段投入","： 1"));
                    list.add(new ContentListInfoBean.ContentListValueBean("零序加速段投入","： 1"));
                    list.add(new ContentListInfoBean.ContentListValueBean("过负荷投入","： 0"));
                    list.add(new ContentListInfoBean.ContentListValueBean("零序I段投入", "： 0"));
                    break;

            }
        }else if(menuTitle.equals("调试操作")){
            switch (menuText){
                case "遥信顺序试验":
                case "遥信选点试验":
                    bean.setTitle("遥信试验");
                    list.add(new ContentListInfoBean.ContentListValueBean("整组启动","： 1"));
                    list.add(new ContentListInfoBean.ContentListValueBean("重合闸动作","： 0"));
                    list.add(new ContentListInfoBean.ContentListValueBean("过流I段动作","： 0"));
                    list.add(new ContentListInfoBean.ContentListValueBean("过流II段动作","： 0"));
                    list.add(new ContentListInfoBean.ContentListValueBean("过流III段动作","： 0"));
                    list.add(new ContentListInfoBean.ContentListValueBean("过流反时限动作","： 0"));
                    list.add(new ContentListInfoBean.ContentListValueBean("过流加速动作", "： 0"));
                    break;
                case "遥测信号试验":
                    bean.setTitle("遥测试验");
                    list.add(new ContentListInfoBean.ContentListValueBean("IA  =  00.004A"));
                    list.add(new ContentListInfoBean.ContentListValueBean("IB  =  00.006A"));
                    list.add(new ContentListInfoBean.ContentListValueBean("IC  =  00.006A"));
                    list.add(new ContentListInfoBean.ContentListValueBean("IO  =  000.07A"));
                    list.add(new ContentListInfoBean.ContentListValueBean("UA  =  000.06V"));
                    list.add(new ContentListInfoBean.ContentListValueBean("UB  =  000.05V"));
                    list.add(new ContentListInfoBean.ContentListValueBean("UC  =  000.08V"));
                    break;
            }
        }else if(menuTitle.equals("定值设置")){
            switch (menuText){
                case "系统定值":
                    bean.setTitle("系统定值");
                    list.add(new ContentListInfoBean.ContentListValueBean("定值区号", "00  区  "));
                    list.add(new ContentListInfoBean.ContentListValueBean("保护TA一次额定值","1000  安培"));
                    list.add(new ContentListInfoBean.ContentListValueBean("保护TA二次额定值"," 5   安培"));
                    list.add(new ContentListInfoBean.ContentListValueBean("测量TA一次额定值","1000  安培"));
                    list.add(new ContentListInfoBean.ContentListValueBean("测量TA二次额定值"," 5   安培"));
                    list.add(new ContentListInfoBean.ContentListValueBean("零序TA一次额定值","0400  安培"));
                    list.add(new ContentListInfoBean.ContentListValueBean("零序TA二次额定值", " 5   安培"));
                    break;
                case "保护定值":
                    bean.setTitle("定值   00区");
                    list.add(new ContentListInfoBean.ContentListValueBean("过流负序电压闭锁值", "000.00伏特"));
                    list.add(new ContentListInfoBean.ContentListValueBean("过流低压闭锁定值","070.00伏特"));
                    list.add(new ContentListInfoBean.ContentListValueBean("过流I段定值","015.00安培"));
                    list.add(new ContentListInfoBean.ContentListValueBean("过流I段时间","000.10秒  "));
                    list.add(new ContentListInfoBean.ContentListValueBean("过流II段定值","008.00安培"));
                    list.add(new ContentListInfoBean.ContentListValueBean("过流II段时间","000.10秒  "));
                    list.add(new ContentListInfoBean.ContentListValueBean("过流III段定值", "006.00安培"));
                    list.add(new ContentListInfoBean.ContentListValueBean("过流III段时间", "000.10秒  "));
                    break;
                case "通讯参数":
                    bean.setTitle("通讯参数");
                    list.add(new ContentListInfoBean.ContentListValueBean("口令", "***"));
                    list.add(new ContentListInfoBean.ContentListValueBean("装置地址","00010"));
                    list.add(new ContentListInfoBean.ContentListValueBean("IP1子网高位地址","192"));
                    list.add(new ContentListInfoBean.ContentListValueBean("IP1子网低位地址","168"));
                    list.add(new ContentListInfoBean.ContentListValueBean("IP2子网高位地址","192"));
                    list.add(new ContentListInfoBean.ContentListValueBean("IP2子网低位地址","169"));
                    list.add(new ContentListInfoBean.ContentListValueBean("IP3子网高位地址", "198"));
                    list.add(new ContentListInfoBean.ContentListValueBean("IP3子网低位地址", "162"));
                    break;
                case "辅助参数":
                    bean.setTitle("辅助参数");
                    list.add(new ContentListInfoBean.ContentListValueBean("弹簧未储能报警延时", "15.0秒"));
                    list.add(new ContentListInfoBean.ContentListValueBean("事故总复归时间","03.0秒"));
                    list.add(new ContentListInfoBean.ContentListValueBean("检测控制回路断线","192"));
                    list.add(new ContentListInfoBean.ContentListValueBean("301定义为TWJ","：  0"));
                    list.add(new ContentListInfoBean.ContentListValueBean("302定义为HUJ","：  0"));
                    list.add(new ContentListInfoBean.ContentListValueBean("303定义为KKJ","：  0"));
                    list.add(new ContentListInfoBean.ContentListValueBean("304定义为YK", "：  0"));
                    break;
                case "软压板初始化":
                    bean.setTitle("软压板状态");
                    list.add(new ContentListInfoBean.ContentListValueBean("过流I段投入","： 1"));
                    list.add(new ContentListInfoBean.ContentListValueBean("过流II段投入","： 1"));
                    list.add(new ContentListInfoBean.ContentListValueBean("过流III段投入","： 1"));
                    list.add(new ContentListInfoBean.ContentListValueBean("过流加速段投入","： 1"));
                    list.add(new ContentListInfoBean.ContentListValueBean("零序加速段投入","： 1"));
                    list.add(new ContentListInfoBean.ContentListValueBean("过负荷投入","： 1"));
                    list.add(new ContentListInfoBean.ContentListValueBean("零序I段投入", "： 1"));
                    break;
            }
        }

        bean.setList(list);
        return bean;
    }

    public static ContentTipBean getContentTipInfo(String menuTitle, String menuText){
        ContentTipBean contentTipBean = new ContentTipBean();
        if(menuTitle.equals("报告显示")) {
            switch (menuText) {
                case "自检报告":
                    contentTipBean = new ContentTipBean("", "报告不存在");
                    break;
            }
        }else if(menuTitle.equals("调试操作")){
            switch (menuText){
                case "出口传动试验":
                    contentTipBean = new ContentTipBean("", "禁止传动");
                    break;
            }
        }else if(menuTitle.equals("定值设置")){
            switch (menuText){
                case "电度清零":
                    contentTipBean = new ContentTipBean("", "电度已清零");
                    break;
            }
        }else if(menuTitle.equals("装置打印")){
            contentTipBean = new ContentTipBean("", "打印机异常");
        }else if(menuTitle.equals("菜单管理")&&menuText.equals("报告清除")){
            contentTipBean = new ContentTipBean("", "报告已清除");
        }
        return contentTipBean;
    }

    public static ArrayList<ContentTextBean> getContentTextInfo(String menuTitle,String menuText){
        ArrayList<ContentTextBean> list = new ArrayList<>();
        if(menuTitle.equals("报告显示")){
            switch (menuText){
                case "动作报告":
                    list.add(new ContentTextBean("000.06\n89-09-17 03:52:31:753\n\n                Imax 000.00A\n过流加速动作"));
                    break;
                case "遥信报告":
                    list.add(new ContentTextBean("0025\n89-09-17 04:00:22:753\n" +
                            "控制回路断线\n\n                         0 -> 1"));
                    break;
                case "操作报告":
                    list.add(new ContentTextBean("操作报告 :\n0000\n" +
                            "89-09-17 03:51:54:753\n                    遥信位置"));
                    break;
                case "运行报告":
                    list.add(new ContentTextBean("运行告警 :\n0005\n" +
                            "89-09-17 03:51:54:753\n\n装置报警\n控制回路断线"));
                    break;
            }
        }else if (menuTitle.equals("菜单管理")){
            switch (menuText){
                case "版本信息":
                    list.add(new ContentTextBean("保护程序版本信息\niPACS-5711-D101175\n版本号：1.00\n校验码：9381\n2010-110-10 14:59\nCPLD版本：R 2.00"
                            ,Content_Gravity_Center));
                    break;
                case "时间设置":
                    list.add(new ContentTextBean("时间设置\n\n日期：09  09  17\n时间：04  10 33"
                            ,Content_Gravity_Center));
                    break;
            }
        }
        return list;
    }

    public static ContentToast getContentToastInfo(String menuTitle,String menuText){
        ContentToast contentToast = new ContentToast();
        if(menuTitle.equals("定值设置")){
            switch (menuText){
                case "出厂设置":
                    contentToast.setToast("恢复出厂设置成功");
                    break;
            }
        }
        return contentToast;
    }
}
