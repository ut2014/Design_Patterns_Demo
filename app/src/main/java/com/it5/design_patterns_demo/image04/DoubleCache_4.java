package com.it5.design_patterns_demo.image04;

import android.graphics.Bitmap;

import com.it5.design_patterns_demo.interf.IImageCache;

/**
 * Created by IT5 on 2016/8/16.
 */
public class DoubleCache_4 implements IImageCache{
    IImageCache memoryCache=new MemoryCache();
    IImageCache diskCache=new DiskCache_4();

    //先从内存缓存中获取，如没有，则从sd中获取
    @Override
    public Bitmap get(String url) {
        Bitmap bitmap=memoryCache.get(url);
        if (bitmap==null) {
            bitmap=diskCache.get(url);
        }
        return bitmap;
    }

    //将图片缓存到内存和sd卡中
    @Override
    public void put(String url, Bitmap bitmap) {
        memoryCache.put(url,bitmap);
        diskCache.put(url,bitmap);
    }
}
