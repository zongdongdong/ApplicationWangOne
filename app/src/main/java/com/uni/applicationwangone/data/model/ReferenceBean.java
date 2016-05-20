package com.uni.applicationwangone.data.model;

import java.io.Serializable;

/**
 * Created by Joe on 2016/5/19.
 * Email-joe.zong@xiaoniubang.com
 */
public class ReferenceBean implements Serializable{

    /**
     * _id : 573c75d5d6c4cf702432abc8
     * __v : 0
     * hash : 唯亭变#119备用9仓断路器#一般缺陷#二次回路#119线二次柜内低压开关操作箱坏（开关无法操作）NSP30-C1#119线二次柜内低压开关操作箱已恢复（NSP30-C2）#2016-4-18 0:00:00#沈晨雁 季庆州 郦君婷
     * clry : 沈晨雁 季庆州 郦君婷
     * clsj : 2016-4-18 0:00:00
     * clgc : 119线二次柜内低压开关操作箱已恢复（NSP30-C2）
     * qxms : 119线二次柜内低压开关操作箱坏（开关无法操作）NSP30-C1
     * qxdx : 二次回路
     * qxlx : 一般缺陷
     * jgmc : 119备用9仓断路器
     * bdzmc : 唯亭变
     */

    public String _id;
//    public int __v;
//    public String hash;
    public String clry;//处理人员
    public String clsj;//处理时间
    public String clgc;//处理过程
    public String qxms;//缺陷描述
    public String qxdx;//缺陷对象
    public String qxlx;//缺陷类型
    public String jgmc;//间隔名称
    public String bdzmc;//变电站名称
}
