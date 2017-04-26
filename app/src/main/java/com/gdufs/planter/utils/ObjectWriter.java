package com.gdufs.planter.utils;

import android.content.Context;
import android.os.Environment;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  
 * 对象的持久化操作 
 * 
 */  
public class ObjectWriter {

    private static String TAG = ObjectWriter.class.getSimpleName();

    private static String FILE_ROOT_DIRECTORY = "/Planter";
    private static String DIR_VIEW_DATA = FILE_ROOT_DIRECTORY + File.separator + "ViewData";
    public static String FILE_DIRECTORY = Environment.getExternalStorageDirectory().toString() + DIR_VIEW_DATA + File.separator;
    public static String FILE_DIRECTORY_TEST = Environment.getExternalStorageDirectory().toString() + DIR_VIEW_DATA + File.separator + "testFile4.doc";

    public static String ROOT_DIRECTORY = Environment.getExternalStorageDirectory().toString() + FILE_ROOT_DIRECTORY;

    /**
     * 写入本地文件
     * @param obj
     * @param fileName
     */  
    public static void write(Object obj, String fileName) {
        try {  
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            ObjectOutputStream oout = null;
            File file = new File(FILE_DIRECTORY + fileName);
            if(!createFile(file)){
                LogUtil.e(TAG, "createFile");
                return;
            }

            if(file.length()<1){
                oout = new ObjectOutputStream(bout);
            }else{
                oout = new MyObjectOutputStream(bout);
            }
            oout.writeObject(obj);  
            oout.flush();  
            oout.close();  
            bout.close();  
            byte[] b = bout.toByteArray();  


//            if(createFile(file)){
                LogUtil.e(TAG, "after createFile");
                FileOutputStream out = new FileOutputStream(file, true);
                out.write(b);
                out.flush();
                out.close();
//            }
        } catch (Exception e) {
            LogUtil.e(TAG, e.toString());
        } finally {  
  
        }  
    }

    public static boolean isExist(File file){
        if(file != null && file.exists()){
            return true;
        }
        return false;
    }

    public static boolean createFile(File file){

        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        LogUtil.e(TAG, "createFile");

        boolean isCreated = true;
        if(!isExist(file)){
            try {
                isCreated = file.createNewFile();
                LogUtil.e(TAG, "1 isCreated = " + isCreated);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        LogUtil.e(TAG, "2 isCreated = " + isCreated);
        return isCreated;
    }
  
    /** 
     * 从本地文件读取 
     * @param context 
     * @param fileName 
     * @return 
     */  
    public static Object read(Context context, String fileName) {  
        // 拿出持久化数据  
        Object obj = null;  
        try {  
            File file = new File(FILE_DIRECTORY + fileName);
            FileInputStream in = new FileInputStream(file);
            ObjectInputStream oin = new ObjectInputStream(in);
            obj = oin.readObject();  
            in.close();  
            oin.close();  
        } catch (Exception e) {
            LogUtil.e(TAG, e.toString());
        }  
        return obj;  
    }

    public static <T> List<T> readAll(String fileName){
        T obj = null;
        List<T> objList = new LinkedList<>();
        try {
            File file = new File(FILE_DIRECTORY + fileName);

            if(createFile(file)){
                FileInputStream in = new FileInputStream(file);
                ObjectInputStream oin = new ObjectInputStream(in);
                LogUtil.e(TAG, "before read");
                while(oin.available() == 0){
                    LogUtil.e(TAG, "reading");
                    obj = (T) oin.readObject();
                    objList.add(0, obj);
                }
                LogUtil.e(TAG, "after read 1, list size = " + objList.size());
                in.close();
                oin.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
//            LogUtil.e(TAG, e.toString());
        }
        LogUtil.e(TAG, "after read 2, list size = " + objList.size());
        return objList;
    }

    static class MyObjectOutputStream extends ObjectOutputStream{
        public MyObjectOutputStream() throws IOException {
            super();
        }

        public MyObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }
        @Override
        protected void writeStreamHeader() throws IOException {
            return;
        }
    }
} 