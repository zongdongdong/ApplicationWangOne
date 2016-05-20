package com.uni.applicationwangone.ui.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

/**
 * Created by Joe on 2016/5/18.
 * Email-joe.zong@xiaoniubang.com
 */
public class UIHelper {
    private static Toast mToast = null;
    public static void showToast(Context aContext,String msg){
        if(mToast == null){
            mToast = Toast.makeText(aContext,msg,Toast.LENGTH_SHORT);
        }else{
            mToast.setText(msg);
        }
        mToast.show();
    }
    public static void post(Runnable runnable){
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    public static void postDelayed(Runnable runnable,long time){
        new Handler(Looper.getMainLooper()).postDelayed(runnable,time);
    }
}
