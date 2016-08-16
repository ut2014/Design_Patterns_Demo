package com.it5.design_patterns_demo.image04;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.it5.design_patterns_demo.interf.IImageCache;

/**
 * Created by IT5 on 2016/8/15.
 * 内存缓存
 */
public class MemoryCache implements IImageCache {
    private LruCache<String,Bitmap> memoryCache;
    public MemoryCache(){
        int maxMemory= (int) (Runtime.getRuntime().maxMemory()/1024);
        int size=maxMemory/4;
        memoryCache=new LruCache<String,Bitmap>(size){
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes()*bitmap.getHeight()/1024;
            }
        };
    }
    @Override
    public Bitmap get(String url) {
        return memoryCache.get(url);
    }

    @Override
    public void put(String url, Bitmap bitmap) {
        memoryCache.put(url,bitmap);
    }
}
