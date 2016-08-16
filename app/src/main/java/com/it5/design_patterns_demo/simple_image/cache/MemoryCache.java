package com.it5.design_patterns_demo.simple_image.cache;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.it5.design_patterns_demo.simple_image.request.BitmapRequest;

/**
 * Created by IT5 on 2016/8/16.
 * 图片的内存缓存，key为图片的url,值为图片本身
 */
public class MemoryCache implements BitmapCache{
    private LruCache<String,Bitmap> memoryCache;

    public MemoryCache() {
        //计算可使用大小
        int maxMemory= (int) (Runtime.getRuntime().maxMemory()/1024);
        //取四分之一作为缓存
        int size=maxMemory/4;
        this.memoryCache = new LruCache<String,Bitmap>(size){
            @Override
            protected int sizeOf(String key, Bitmap bmp) {
                return bmp.getRowBytes()*bmp.getHeight()/1024;
            }
        };
    }

    @Override
    public Bitmap get(BitmapRequest key) {
        return memoryCache.get(key.imageUrl);
    }

    @Override
    public void put(BitmapRequest key, Bitmap bmp) {
        memoryCache.put(key.imageUrl,bmp);
    }

    @Override
    public void remove(BitmapRequest key) {
        memoryCache.remove(key.imageUrl);
    }
}
