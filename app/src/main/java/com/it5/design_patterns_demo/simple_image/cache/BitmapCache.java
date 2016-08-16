package com.it5.design_patterns_demo.simple_image.cache;

import android.graphics.Bitmap;

import com.it5.design_patterns_demo.simple_image.request.BitmapRequest;

/**
 * Created by IT5 on 2016/8/16.
 * 图片缓存抽象类，具全的子类有不使用缓存（@see Nocache）
 * 内存缓存 memoryCache
 * sd卡缓存 DiskCache以及内存和sd卡双缓存 doubleCache
 *
 * 请求缓存接口
 */
public interface BitmapCache {
    public Bitmap get(BitmapRequest key);
    public void put(BitmapRequest key, Bitmap bmp);
    public void remove(BitmapRequest key);
}
