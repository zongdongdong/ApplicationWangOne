package com.uni.applicationwangone.data.model;

import java.io.Serializable;

/**
 * Created by Joe on 2016/5/19.
 * Email-joe.zong@xiaoniubang.com
 */
public class SpinnerBean implements Serializable{
    public String _id;
    public String mz;

    public SpinnerBean(String _id, String mz) {
        this._id = _id;
        this.mz = mz;
    }
}
