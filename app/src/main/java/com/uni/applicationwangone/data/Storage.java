package com.uni.applicationwangone.data;

import java.io.File;
import android.content.Context;
import android.os.Environment;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by dongdong on 2014/11/12.
 */
public class Storage {
    private Storage(){}

    private final static boolean IS_LOCAL_TAG = true;
    public final static String FilePath = "/aihire";
    public final static String MediaPath = "/media";
    public final static String ConfigurePath = "/configure";
    public final static String JsonConfigPath = "/jsonConfig";
    public final static String CrashPath = "/crashPath";
    public final static String ZipPath = "/zipPath";
    public final static String VideoName = "/AIHireVideo.mp4";
    public final static String AudioName = "/AIHireAudio.mp4";
    public final static String ConfigureJsonName = "/configure.json";
    public final static String CongfigureZipName = "/configureZip.zip";
    public final static String LogName = "/log.txt";
    public final static String LogUpdateName = "/logUpdate.txt";
    public final static String LogValidationName = "/logValidation.txt";
    public final static String ScorePath = "/scorePath";
    public final static String FileDataPath = "/fileData";




    // Context.MODE_PRIVATE：private Overwrite the data
    // Context.MODE_APPEND：append data
    // MODE_WORLD_READABLE：read for other app
    // MODE_WORLD_WRITEABLE：write for other app
/*
    <uses-permission android:name="android.permission.MOUNT_UNMOUNT_FILESYSTEMS"/>

    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>*/

    public static boolean saveData(Context aContext, String filePath, Object obj){
        if(IS_LOCAL_TAG){
            return saveLocalData(aContext,filePath,obj);
        }else{
            return saveDataToSD(filePath,obj);
        }
    }

    public static Object readData(Context aContext, String filePath){
        if(IS_LOCAL_TAG){
            return readLocalData(aContext, filePath);
        }else{
            return readDataFromSD(filePath);
        }
    }



    /**
     * save file to local
     * @param aContext
     * @param fileName
     * @param obj
     * @return
     */
    public static boolean saveLocalData(Context aContext, String fileName, Object obj){
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
    public static Object readLocalData(Context aContext, String fileName){
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
    public static boolean saveDataToSD(String fileName, Object obj){
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
    public static Object readDataFromSD(String fileName){
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

    /**
     * get file path
     * @return
     */
    public static String getSDPath(Context aContext) {
        String savePath = Environment.getExternalStorageDirectory()
                + FilePath;
        File file1 = new File(savePath);
        if (!file1.exists()) {
            file1.mkdir();
        }
        return savePath;
    }

    public static String getLocalPath(Context aContext){
        return aContext.getExternalFilesDir("aihire").getAbsolutePath();
    }

    public static String getFilePath(Context aContext){
        if(IS_LOCAL_TAG){
            return getLocalPath(aContext);
        }else{
            return getSDPath(aContext);
        }
    }



    public static String getJsonConfigPath(Context aContext){
        String jsonConfigPath = getFilePath(aContext)+JsonConfigPath;
        File file = new File(jsonConfigPath);
        if(!file.exists()){
            file.mkdir();
        }
        return jsonConfigPath;
    }

    public static String getConfigurePath(Context aContext){
        String configurePath = getFilePath(aContext)+ConfigurePath;
        File file = new File(configurePath);
        if(!file.exists()){
            file.mkdir();
        }
        return configurePath;
    }

    public static String getZipPath(Context aContext){
        String zipPath = getFilePath(aContext)+ZipPath;
        File file = new File(zipPath);
        if(!file.exists()){
            file.mkdir();
        }
        return zipPath;
    }

    public static String getCrashPath(Context aContext){
        String crashPath = getFilePath(aContext)+CrashPath;
        File file = new File(crashPath);
        if(!file.exists()){
            file.mkdir();
        }
        return crashPath;
    }

    public static String getScorePath(Context aContext){
        String scorePath = getFilePath(aContext)+ScorePath;
        File file = new File(scorePath);
        if(!file.exists()){
            file.mkdir();
        }
        return scorePath;
    }

    public static String getFileDataPath(Context aContext){
        String fileDataPath = getFilePath(aContext)+FileDataPath;
        File file = new File(fileDataPath);
        if(!file.exists()){
            file.mkdir();
        }
        return fileDataPath;
    }

}
