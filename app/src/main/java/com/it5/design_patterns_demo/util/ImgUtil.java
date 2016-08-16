package com.it5.design_patterns_demo.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by IT5 on 2016/8/15.
 */
public class ImgUtil {
    public static String cacheDir="sdcard/cache/";
    private static Handler handler=new Handler(Looper.getMainLooper());
    private ImgUtil(){}
    public static void displayImg(final ImageView imageView, final Bitmap bitmap){
        handler.post(new Runnable() {
            @Override
            public void run() {
                imageView.setImageBitmap(bitmap);
            }
        });
    }

    public static Bitmap downloadImage(String imgurl){
        Bitmap bitmap=null;
        try{
            URL url=new URL(imgurl);
            final HttpURLConnection conn= (HttpURLConnection) url.openConnection();
            bitmap= BitmapFactory.decodeStream(conn.getInputStream());
            conn.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bitmap;
    }

    public static String imgName(String imgurl){
        if (TextUtils.isEmpty(imgurl)) {
            return null;
        }
        return imgurl.substring(imgurl.lastIndexOf("/")+1,imgurl.length());
    }

    public static void mkCacheDirs() {
        File filedir=new File(ImgUtil.cacheDir);
        if (!filedir.exists()) {
            filedir.mkdirs();
        }
    }
}
