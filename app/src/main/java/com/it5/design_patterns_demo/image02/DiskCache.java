package com.it5.design_patterns_demo.image02;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.it5.design_patterns_demo.util.ImgUtil;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by IT5 on 2016/8/15.
 */
public class DiskCache {
    //从缓存中获取图片
    public Bitmap get(String url){
        return BitmapFactory.decodeFile(ImgUtil.cacheDir+ ImgUtil.imgName(url));
    }
    //将图片缓存到内存中
    public void put(String url,Bitmap bmp){
        FileOutputStream outputStream=null;
        ImgUtil.mkCacheDirs();
        try{
            Log.e("img name: ",ImgUtil.imgName(url));
            outputStream=new FileOutputStream(ImgUtil.cacheDir+ImgUtil.imgName(url));
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


}
