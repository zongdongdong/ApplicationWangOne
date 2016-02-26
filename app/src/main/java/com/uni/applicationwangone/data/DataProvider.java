package com.uni.applicationwangone.data;

import android.content.Context;

import com.uni.applicationwangone.R;
import com.uni.applicationwangone.ui.fragments.AlertFragment;
import com.uni.applicationwangone.ui.fragments.BaseFragment;
import com.uni.applicationwangone.ui.fragments.DeviceNumberFragment;
import com.uni.applicationwangone.ui.fragments.DingZhiCopyFragment;
import com.uni.applicationwangone.ui.fragments.DingZhiQuHaoFragment;
import com.uni.applicationwangone.ui.fragments.NetPortSettingFragment;
import com.uni.applicationwangone.ui.fragments.NoneContentFragment;
import com.uni.applicationwangone.ui.fragments.SettingViewPagerFragment;
import com.uni.applicationwangone.ui.fragments.PasswordFragment;
import com.uni.applicationwangone.ui.fragments.ShuZhiXingDingZhiFragment;
import com.uni.applicationwangone.ui.fragments.ThreeButtonDialogFragment;
import com.uni.applicationwangone.ui.fragments.TimeSettingFragment;
import com.uni.applicationwangone.ui.fragments.TwoButtonDialogFragment;
import com.uni.applicationwangone.ui.fragments.ViewPagerFragment;

/**
 * Created by Administrator on 2015/10/15.
 */
public class DataProvider {
    private static DataProvider sDataProvider;
    private Context mContext;
    private FileManager mFileManager;

    public static final String[] MenuTextData = new String[]{"查看","整定","预设","打印"};

    public static DataProvider getInstance(Context aContext){
        if (sDataProvider == null) {
            sDataProvider = new DataProvider(aContext);

        }
        return sDataProvider;
    }

    public DataProvider(Context mContext) {
        this.mContext = mContext;
        mFileManager = new FileManager(mContext);
    }

    public String[] getMenuData(int menuInext){
        String[] datas = null;
        switch (MenuTextData[menuInext]){
            case "查看":
                datas = new String[]{"装置信息","交流量","开入量","设备参数定值","保护定值 >","软压板 >" ,"装置记录 >","录波信息 >"};
                break;
            case "整定":
                datas = new String[]{"定值区号","设备参数设定","保护定值 >","软压板  >","定值拷贝"};
                break;
            case "预设":
                datas = new String[]{"时钟设置","辅助功能 >","通讯参数 >"};
                break;
            case "打印":
                datas = new String[]{"装置信息","交流量","定值信息","装置记录","波形信息","运行报告","事故报告","取消打印"};
                break;
        }
        return datas;
    }

    /**
     * 如果有下级目录，则获取对应数据，显示菜单
     * @param levelText
     * @return
     */
    public String[] getLevelData(String levelText){
        String[] datas = null;
        switch (levelText){
            case "保护定值 >":
                datas = new String[]{"差动保护 >"};
                break;
            case "差动保护 >":
                datas = new String[]{"数值型定值","投退型定值"};
                break;
            case "软压板 >":
                datas = new String[]{"功能软压板","GOOSE软压板","SV接受软压板"};
                break;
            case "装置记录 >":
                datas = new String[]{"运行报告","保护动作","保护告警","保护启动","SOE变位","遥控记录","装置自检","装置运行","装置操作"};
                break;
            case "录波信息 >":
                datas = new String[]{"动作录波信息","起动录波信息","手动录波信息"};
                break;
//            case "保护定值  >":
//                datas = new String[]{"差动保护 >"};
//                break;
            case "软压板  >":
                datas = new String[]{"保护软压板","GOOSE软压板","SV接受软压板"};
                break;
            case "辅助功能 >":
                datas = new String[]{"强制复归","手动录波","清除记录"};
                break;
            case "通讯参数 >":
                datas = new String[]{"通讯设置","装置编号","网口设置"};
                break;
        }
        return datas;
    }

    public BaseFragment getFragment(String levelText,int menuIndex){
        BaseFragment baseFragment = null;
        switch (levelText){
            case "装置信息":
                if(menuIndex == 0){
                    baseFragment = ViewPagerFragment.newInstance("装置信息",getPageDatas("装置信息",menuIndex));
                }
                break;
            case "交流量":
                if(menuIndex == 0){
                    baseFragment = ViewPagerFragment.newInstance("交流量",getPageDatas("交流量",menuIndex));
                }
                break;
            case "开入量":
                baseFragment = ViewPagerFragment.newInstance("开入量",getPageDatas("开入量",menuIndex));
                break;
            case "设备参数定值":
                baseFragment = ViewPagerFragment.newInstance("变压器参数",getPageDatas("设备参数定值",menuIndex));
                break;
            case "数值型定值":
                if(menuIndex == 0){
                    baseFragment = ViewPagerFragment.newInstance("差动保护定值",getPageDatas("数值型定值",menuIndex));
                }else{
                    baseFragment = PasswordFragment.newInstance("数值型定值");
                }
                break;
            case "投退型定值":
                if(menuIndex == 0){
                    baseFragment = ViewPagerFragment.newInstance("差动保护控制字",getPageDatas("投退型定值",menuIndex));
                }else{
                    baseFragment = PasswordFragment.newInstance("投退型定值");
                }
                break;
            case "功能软压板":
                if(menuIndex == 0){
                    baseFragment = ViewPagerFragment.newInstance("功能软压板",getPageDatas("功能软压板",menuIndex));
                }
                break;
            case "GOOSE软压板":
                if(menuIndex == 0){
                    baseFragment = ViewPagerFragment.newInstance("GOOSE软压板",getPageDatas("GOOSE软压板",menuIndex));
                }else{
                    baseFragment = PasswordFragment.newInstance("GOOSE软压板");
                }
                break;
            case "SV接受软压板":
                if(menuIndex == 0){
                    baseFragment = ViewPagerFragment.newInstance("SV接受软压板",getPageDatas("SV接受软压板",menuIndex));
                }else{
                    baseFragment = PasswordFragment.newInstance("SV接受软压板");
                }
                break;
            case "运行报告":
                if(menuIndex == 0){
                    baseFragment = ViewPagerFragment.newInstance("运行报告",getPageDatas("运行报告",menuIndex));
                }
                break;
            case "保护动作":
                baseFragment = ViewPagerFragment.newInstance("保护动作",getPageDatas("保护动作",menuIndex));
                break;
            case "保护告警":
                baseFragment = ViewPagerFragment.newInstance("保护告警",getPageDatas("保护告警",menuIndex));
                break;
            case "保护启动":
                baseFragment = ViewPagerFragment.newInstance("保护启动",getPageDatas("保护启动",menuIndex));
                break;
            case "SOE变位":
                baseFragment = ViewPagerFragment.newInstance("SOE变位",getPageDatas("SOE变位",menuIndex));
                break;
            case "遥控记录":
                baseFragment = ViewPagerFragment.newInstance("遥控记录",getPageDatas("遥控记录",menuIndex));
                break;
            case "装置自检":
                baseFragment = ViewPagerFragment.newInstance("装置自检",getPageDatas("装置自检",menuIndex));
                break;
            case "装置运行":
                baseFragment = ViewPagerFragment.newInstance("装置运行",getPageDatas("装置运行",menuIndex));
                break;
            case "装置操作":
                baseFragment = ViewPagerFragment.newInstance("装置操作",getPageDatas("装置操作",menuIndex));
                break;
            case "动作录波信息":
                baseFragment = ViewPagerFragment.newInstance("动作录波信息",getPageDatas("动作录波信息",menuIndex));
                break;
            case "起动录波信息":
                baseFragment = ViewPagerFragment.newInstance("起动录波信息",getPageDatas("起动录波信息",menuIndex));
                break;
            case "手动录波信息":
                baseFragment = AlertFragment.newInstance("手动录波信息","无手动录波");
                break;
            case "时钟设置":
                baseFragment = PasswordFragment.newInstance("时钟设置");
                break;
            case "时钟设置口令正确":
                baseFragment = TimeSettingFragment.newInstance();
                break;
            case "装置编号":
                baseFragment = PasswordFragment.newInstance("装置编号");
                break;
            case "装置编号口令正确":
                baseFragment = DeviceNumberFragment.newInstance();
                break;
            case "定值区号":
                baseFragment = PasswordFragment.newInstance("定值区号");
                break;
            case "定值区号口令正确":
                baseFragment = DingZhiQuHaoFragment.newInstance();
                break;
            case "定值区号修改确认":
                baseFragment = ThreeButtonDialogFragment.newInstance("定值整定","确实要下装定值?","取消整定","下装定值","重新整定");
                break;
            case "定值拷贝":
                baseFragment = PasswordFragment.newInstance("定值拷贝");
                break;
            case "定值拷贝口令正确":
                baseFragment = DingZhiCopyFragment.newInstance();
                break;
            case "GOOSE软压板口令正确":
                baseFragment = SettingViewPagerFragment.newInstance("GOOSE软压板");
                break;
            case "GOOSE软压板修改确认":
                baseFragment = TwoButtonDialogFragment.newInstance("GOOSE软压板","确实要下载软压板？","取消配置","下装配置");
                break;
            case "SV接受软压板口令正确":
                baseFragment = SettingViewPagerFragment.newInstance("SV接受软压板");
                break;
            case "SV接受软压板修改确认":
                baseFragment = TwoButtonDialogFragment.newInstance("SV接受软压板","确实要下载软压板？","取消配置","下装配置");
                break;
            case "保护软压板":
                baseFragment = PasswordFragment.newInstance("保护软压板");
                break;
            case "保护软压板口令正确":
                baseFragment = SettingViewPagerFragment.newInstance("保护软压板");
                break;
            case "保护软压板修改确认":
                baseFragment = TwoButtonDialogFragment.newInstance("保护软压板","确实要下载软压板？","取消配置","下装配置");
                break;
            case "投退型定值口令正确":
                baseFragment = SettingViewPagerFragment.newInstance("差动保护控制值");
                break;
            case "投退型定值修改确认":
                baseFragment = ThreeButtonDialogFragment.newInstance("定值整定","确实要下装定值?","取消整定","下装定值","重新整定");
                break;
            case "数值型定值口令正确":
                baseFragment = ShuZhiXingDingZhiFragment.newInstance();
                break;
            case "数值型定值修改确认":
                baseFragment = ThreeButtonDialogFragment.newInstance("定值整定","确实要下装定值?","取消整定","下装定值","重新整定");
                break;
            case "网口设置":
                baseFragment = PasswordFragment.newInstance("网口设置");
                break;
            case "网口设置口令正确":
                baseFragment = NetPortSettingFragment.newInstance();
                break;
            case "网口设置修改确认":
                baseFragment = ThreeButtonDialogFragment.newInstance("参数整定","确实要下装定值?","取消整定","下装参数","重新整定");
                break;
            case "通讯设置":
                baseFragment = PasswordFragment.newInstance("通讯设置");
                break;
            case "通讯设置口令正确":
                baseFragment = ViewPagerFragment.newInstance("通讯设置",getPageDatas("通讯设置",menuIndex));
                break;
            case "强制复归":
            case "手动录波":
            case "清除记录":
            case "设备参数设定":
                baseFragment = new NoneContentFragment();
                break;

        }
         return baseFragment;
    }

    public String[] getPageDatas(String levelText,int menuIndex){
        String[] datas = null;
        switch (levelText){
            case "装置信息":
                datas = new String[]{"      PRS-7387\n" +
                        "软件名称             :   PRS-7387\n" +
                        "保护软件版本     :   V2.34\n" +
                        "保护CRC校验码 :   7E4A\n" +
                        "保护软件日期     :   2014.01.13\n" +
                        "管理软件版本     :   V2.34\n" +
                        "管理CRC校验码 :   D597\n" +
                        "管理软件日期     :   2014.01.13"};
                break;
            case "交流量":
                datas = mContext.getResources().getStringArray(R.array.jiao_liu_liang);
                break;
            case "开入量":
                datas = mContext.getResources().getStringArray(R.array.kai_ru_liang);
                break;
            case "设备参数定值":
                datas = mContext.getResources().getStringArray(R.array.she_bei_can_shu_ding_zhi);
                break;
            case "数值型定值":
                datas = mContext.getResources().getStringArray(R.array.cha_kan_shu_zhi_xing_ding_zhi);
                break;
            case "投退型定值":
                datas = mContext.getResources().getStringArray(R.array.cha_kan_tou_tui_xing_ding_zhi);
                break;
            case "功能软压板":
                datas = mContext.getResources().getStringArray(R.array.cha_kan_gong_neng_ruan_ya_ban);
                break;
            case "GOOSE软压板":
                datas = mContext.getResources().getStringArray(R.array.cha_kan_goose_ruan_ya_ban);
                break;
            case "SV接受软压板":
                datas = mContext.getResources().getStringArray(R.array.cha_kan_sv_jie_shou_ruan_ya_ban);
                break;
            case "运行报告":
                datas = mContext.getResources().getStringArray(R.array.yun_xing_bao_gao);
                break;
            case "保护动作":
                datas = mContext.getResources().getStringArray(R.array.bao_hu_dong_zuo);
                break;
            case "保护告警":
                datas = mContext.getResources().getStringArray(R.array.bao_hu_gao_jing);
                break;
            case "保护启动":
                datas = mContext.getResources().getStringArray(R.array.bao_hu_qi_dong);
                break;
            case "SOE变位":
                datas = mContext.getResources().getStringArray(R.array.soe_bian_wei);
                break;
            case "遥控记录":
                datas = mContext.getResources().getStringArray(R.array.yao_kong_ji_lu);
                break;
            case "装置自检":
                datas = mContext.getResources().getStringArray(R.array.zhuang_zhi_zi_jian);
                break;
            case "装置运行":
                datas = mContext.getResources().getStringArray(R.array.zhuang_zhi_yun_xing);
                break;
            case "装置操作":
                datas = mContext.getResources().getStringArray(R.array.zhuang_zhi_cao_zuo);
                break;
            case "动作录波信息":
                datas = mContext.getResources().getStringArray(R.array.dong_zuo_lu_bo_xin_xi);
                break;
            case "起动录波信息":
                datas = mContext.getResources().getStringArray(R.array.qi_dong_lu_bo_xin_xi);
                break;
            case "通讯设置":
                datas = mContext.getResources().getStringArray(R.array.tong_xun_she_zhi);
                break;
        }
        return datas;
    }

    public String getDesc(String levelText){
        String desc = "";
        switch (levelText){
            case "装置信息":
                desc = "查看装置信息";
                break;
            case "交流量":
                desc = "查看交流量";
                break;
            case "开入量":
                desc = "查看开入量";
                break;
            case "设备参数定值":
                desc = "查看设备参数定值";
                break;
            case "差动保护 >":
                desc = "查看差动保护定值";
                break;
            case "保护软压板":
                desc = "查看保护软压板";
                break;
            case "GOOSE软压板":
                desc = "查看GOOSE软压板";
                break;
            case "SV接受软压板":
                desc = "查看SV接受软压板";
                break;
            case "遥控记录":
                desc = "查看遥控操作记录";
                break;
            case "":
                desc = "";
                break;
        }
        return desc;
    }
}
