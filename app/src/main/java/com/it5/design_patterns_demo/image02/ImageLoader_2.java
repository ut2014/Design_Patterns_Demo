package com.it5.design_patterns_demo.image02;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.it5.design_patterns_demo.DisplayImg;
import com.it5.design_patterns_demo.image01.ImageCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by IT5 on 2016/8/15.
 */
public class ImageLoader_2 {
    //内存缓存
    ImageCache imageCache = new ImageCache();
    //sd卡缓存
    DiskCache diskCache = new DiskCache();
    //是否使用SD卡缓存
    boolean isUseDiskCache = false;
    //线程池，线程数量为cpu的数量
    ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public void displayImage(final String url, final ImageView imageView) {
        //判断使用哪种缓存
        Bitmap bitmap = isUseDiskCache ? diskCache.get(url) : imageCache.get(url);
        if (bitmap != null) {
//            imageView.setImageBitmap(bitmap);
            new DisplayImg(imageView,bitmap);
            return;
        }
        //没有缓存，则提交给线程池进行下载
        imageView.setTag(url);
        service.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = DisplayImg.downloadImage(url);
                if (bitmap == null) return;
                if (imageView.getTag().equals(url)) {
//                    imageView.setImageBitmap(bitmap);
                    new DisplayImg(imageView,bitmap);
                }
                imageCache.put(url, bitmap);
                diskCache.put(url,bitmap);
            }
        });
    }

    public void userDiskCache(boolean isuse) {
        isUseDiskCache = isuse;
    }
}
