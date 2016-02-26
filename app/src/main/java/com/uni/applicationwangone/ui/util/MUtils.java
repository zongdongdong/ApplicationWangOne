package com.uni.applicationwangone.ui.util;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Dong on 2015/11/16.
 */
public class MUtils {
    public static String getCurrentTime(String formatStyle){
        SimpleDateFormat format = new SimpleDateFormat(formatStyle);
        return format.format(new Date());
    }

    public static String dateFormatString(Date date,String formatStyle){
        SimpleDateFormat format = new SimpleDateFormat(formatStyle);
        return  format.format(date);
    }

    //时间相减，得到天数
    public static int subToDays(Date date){
        long nowTime = System.currentTimeMillis();
        long time = date.getTime();
        return (int)((nowTime-time)/24/60/60/1000);
    }

    public static String getSimpleJsonForKey(String json,String key){
        String result = "";
        if(!TextUtils.isEmpty(json)){
            try {
                JSONObject jsonObject = new JSONObject(json);
                result = jsonObject.optString(key);
            }catch (JSONException e){
                e.printStackTrace();
            }

        }
        return result;
    }

    public static Object getObjFromJson(String json,String key){
        Object obj = null;
        if(!TextUtils.isEmpty(json)){
            try {
                JSONObject jsonObject = new JSONObject(json);
                obj = jsonObject.opt(key);
            }catch (JSONException e){
                e.printStackTrace();
            }

        }
        return obj;
    }


    public static boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    public static Bitmap zoomImg(Bitmap bm, int newWidth ,int newHeight){
        // 获得图片的宽高
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap newbm = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);
        return newbm;
    }

    public static boolean savePicture(Bitmap bitmap,String path){
        if(bitmap==null){
            return false;
        }
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();
            return true;
        } catch (IOException ioe) {
            return false;
        }
    }
}
