package com.it5.design_patterns_demo.image03;

import android.graphics.Bitmap;

import com.it5.design_patterns_demo.image01.ImageCache;
import com.it5.design_patterns_demo.image02.DiskCache;

/**
 * Created by IT5 on 2016/8/15.
 * 双缓存。获取图片时先从内存缓存中获取，如果内存中没有，再从sd卡中获取
 * 缓存图片也是在内丰和sd卡中都缓存一份
 */
public class DoubleCache {
    ImageCache memoryCache=new ImageCache();
    DiskCache diskCache=new DiskCache();

    //先从内存缓存中获取图片，如果没有，再从sd卡中获取
    public Bitmap get(String url){
        Bitmap bitmap=memoryCache.get(url);
        if (bitmap==null) {
            bitmap=diskCache.get(url);
        }
        return bitmap;
    }
    //将图片缓存到内存和SD卡中
    public void put(String url,Bitmap bmp){
        memoryCache.put(url,bmp);
        diskCache.put(url,bmp);
    }
}
