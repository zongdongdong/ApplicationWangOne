package com.uni.applicationwangone.data;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by dongdong on 2014/11/12.
 */
public class FileManager {
    private final boolean IS_SAVE_LOCAL = false;
    public final static String FilePath = "MData";
    private Context mContext;

    public FileManager(Context aContext){
        this.mContext = aContext;
    }

    public boolean saveData(Object obj,String fileName){
        String filePath = getFilePath(mContext)+ File.separator + fileName;
        if(IS_SAVE_LOCAL){
            return saveLocalData(mContext,filePath,obj);
        }else{
            return saveDataToSD(filePath,obj);
        }
    }

    public Object readData(String fileName){
        String filePath = getFilePath(mContext)+ File.separator + fileName;
        if(IS_SAVE_LOCAL){
            return readLocalData(mContext, filePath);
        }else{
            return readDataFromSD(filePath);
        }
    }

    private String getFilePath(Context aContext){
        if(IS_SAVE_LOCAL){
            return getLocalPath(aContext);
        }else{
            return getSDPath(aContext);
        }
    }

    private String getSDPath(Context aContext) {
        String savePath = Environment.getExternalStorageDirectory()
                + File.separator + FilePath;
        File file1 = new File(savePath);
        if (!file1.exists()) {
            file1.mkdir();
        }
        return savePath;
    }

    private String getLocalPath(Context aContext){
        return aContext.getExternalFilesDir(FilePath).getAbsolutePath();
    }

    private boolean saveLocalData(Context aContext, String fileName, Object obj){
        boolean isSuccess = true;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = aContext.openFileOutput(fileName, Context.MODE_PRIVATE);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
        } catch (Exception e) {
            e.printStackTrace();
            isSuccess = false;
        }
        finally{
            try {
                if(oos!=null){
                    oos.close();
                }
                if(fos!=null){
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return isSuccess;
    }

    /**
     * read flie from local
     * @param aContext
     * @param fileName
     * @return
     */
    private Object readLocalData(Context aContext, String fileName){
        Object obj = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = aContext.openFileInput(fileName);
            ois = new ObjectInputStream(fis);
            obj = ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                if(ois!=null){
                    ois.close();
                }
                if(fis!=null){
                    fis.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return obj;
    }


    /**
     * save file to sdcard
     * @param fileName
     * @param obj
     * @return
     */
    private boolean saveDataToSD(String fileName, Object obj){
        boolean isSuccess = true;
        File file = new File(fileName);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
        }catch (Exception e) {
            e.printStackTrace();
            isSuccess = false;
        }finally {
            try {
                if(oos!=null){
                    oos.close();
                }
                if(fos!=null){
                    fos.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return isSuccess;
    }


    /**
     * read file from sdcard
     * @param fileName
     * @return
     */
    private Object readDataFromSD(String fileName){
        Object obj = null;
        File file = new File(fileName);
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis=new FileInputStream(file);   //获得输入流
            ois = new ObjectInputStream(fis);
            obj = ois.readObject();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                if(ois!=null){
                    ois.close();
                }
                if(fis!=null){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return obj;
    }




    public static void deleteFile(File file){
//        File file = new File(filePath);
//        if(file.exists()){
//            return file.delete();
//        }else{
//            return true;
//        }

        if(file.isFile()){
            file.delete();
            return;
        }
        if(file.isDirectory()){
            File[] childFile = file.listFiles();
            if(childFile == null || childFile.length == 0){
                file.delete();
                return;
            }
            for(File f : childFile){
                deleteFile(f);
            }
            file.delete();
        }
    }
}
