package com.it5.design_patterns_demo;

import android.graphics.Bitmap;
import android.util.Log;
import android.util.LruCache;
import android.widget.ImageView;

import com.it5.design_patterns_demo.util.ImgUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by IT5 on 2016/8/15.
 * 设计模式之图片加载类
 * 按照最初的不同功能实现用不同方法
 */
public class ImageLoader_0 {
    //图片缓存
    LruCache<String,Bitmap>mImageCache;
    //线程池，线程数量为cpu的数量
    ExecutorService service= Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
    );
    public ImageLoader_0(){
        initImageCache();
    }

    private void initImageCache() {
        //计算可使用的最大内存
        final int maxMemory= (int) (Runtime.getRuntime().maxMemory()/1024);
        //取四分之一的可用内存作为缓存
        final int cacheSize=maxMemory/4;
        mImageCache=new LruCache<String,Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes()*value.getHeight()/1024;
            }
        };
    }

    public void displayImage(final  String url, final ImageView imageView){
        if (imageView==null)return;
        imageView.setTag(url);
        Bitmap bitmap=mImageCache.get(url);
        if (bitmap!=null){
//            imageView.setImageBitmap(bitmap);
            ImgUtil.displayImg(imageView,bitmap);
            return;
        }
        service.submit(new Runnable() {
            @Override
            public void run() {
                final Bitmap bitmap= ImgUtil.downloadImage(url);
                if (bitmap==null) {
                    return;
                }
            /*    if (imageView.getTag().equals(url)) {
                    imageView.setImageBitmap(bitmap);
                }*/
                ImgUtil.displayImg(imageView,bitmap);
                Log.e("img",bitmap.getHeight()+":"+bitmap.getWidth());
                mImageCache.put(url,bitmap);
            }
        });
    }


}
