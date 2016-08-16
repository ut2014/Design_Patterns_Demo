package com.it5.design_patterns_demo.image03;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.it5.design_patterns_demo.util.ImgUtil;
import com.it5.design_patterns_demo.image01.ImageCache;
import com.it5.design_patterns_demo.image02.DiskCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by IT5 on 2016/8/15.
 * 使用 内存与sd缓存
 */
public class ImageLoader_3 {
    //内存缓存
    ImageCache imageCache=new ImageCache();
    //sd缓存
    DiskCache diskCache=new DiskCache();
    //双缓存
    DoubleCache doubleCache=new DoubleCache();
    //使用sd缓存
    boolean isUseDiskCache=false;
    //使用双缓存
    boolean isUseDoubleCache=false;
    //线程池，线程数量为cpu的数量
    ExecutorService service= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public void displayImage(final String url, final ImageView imageView){
        Bitmap bitmap=null;
        if (isUseDiskCache) {
            bitmap=doubleCache.get(url);
        } else if (isUseDiskCache) {
            bitmap=diskCache.get(url);
        }else {
            bitmap=imageCache.get(url);
        }
        if (bitmap!=null) {
//            imageView.setImageBitmap(bitmap);
            ImgUtil.displayImg(imageView,bitmap);
            return;
        }

        //没有缓存，则提交给线程池进行异步下载图片
        imageView.setTag(url);
        service.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap= ImgUtil.downloadImage(url);
                if (bitmap==null) {
                    return;
                }
                if (imageView.getTag().equals(url)) {
                    ImgUtil.displayImg(imageView,bitmap);
                }
                imageCache.put(url,bitmap);
                diskCache.put(url,bitmap);
                doubleCache.put(url,bitmap);
            }
        });

    }

    public void useDiskCache(boolean isDisk){
        isUseDiskCache=isDisk;
    }
    public void useDoubleCache(boolean isDouble){
        isUseDoubleCache=isDouble;
    }



}
