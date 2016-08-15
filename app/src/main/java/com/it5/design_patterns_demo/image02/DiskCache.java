package com.it5.design_patterns_demo.image02;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by IT5 on 2016/8/15.
 */
public class DiskCache {
    static String cacheDir="sdcard/cache/";
    //从缓存中获取图片
    public Bitmap get(String url){
        return BitmapFactory.decodeFile(cacheDir+imgName(url));
    }
    //将图片缓存到内存中
    public void put(String url,Bitmap bmp){
        FileOutputStream outputStream=null;
        try{
            File filedir=new File(cacheDir);
            if (!filedir.exists()) {
                filedir.mkdirs();
            }
            Log.e("img name: ",imgName(url));
            outputStream=new FileOutputStream(cacheDir+imgName(url));
            bmp.compress(Bitmap.CompressFormat.PNG,100,outputStream);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }finally {
            if (outputStream!=null) {
                try{
                    outputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

    }

    private String imgName(String imgurl){
        if (TextUtils.isEmpty(imgurl)) {
            return null;
        }
        return imgurl.substring(imgurl.lastIndexOf("/")+1,imgurl.length());
    }
}
