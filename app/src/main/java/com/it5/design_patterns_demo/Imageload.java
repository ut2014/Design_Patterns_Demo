package com.it5.design_patterns_demo;

import android.graphics.Bitmap;
import android.util.LruCache;
import android.widget.ImageView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by IT5 on 2016/8/15.
 */
public class Imageload {
    private LruCache<String,Bitmap>cache;
    //线程池，线程数量为cpu的数量
    ExecutorService service= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    Imageload(){
        initCache();
    }

    private void initCache() {
        //计算可使用的最大内存
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        //取四分之一的可用内存作为缓存
        final int cacheSize = maxMemory / 4;
        //初始化lrucache
        cache=new LruCache<String,Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getHeight()*bitmap.getRowBytes()/1024;
            }
        };
    }

    public void displayimage(final String url, final ImageView imageView){
        imageView.setTag(url);
        Bitmap bitmap=cache.get(url);
        if (bitmap==null) {
            service.submit(new Runnable() {
                @Override
                public void run() {
                  Bitmap bitmap= ImgUtil.downloadImage(url);
                    if (bitmap==null) {
                        return;
                    }
//                    imageView.setImageBitmap(bitmap);
                    ImgUtil.displayImg(imageView,bitmap);
                    cache.put(url,bitmap);
                }
            });

        }else
        if (imageView.getTag().equals(url)) {
//            imageView.setImageBitmap(bitmap);
            ImgUtil.displayImg(imageView,bitmap);
        }
    }


}
