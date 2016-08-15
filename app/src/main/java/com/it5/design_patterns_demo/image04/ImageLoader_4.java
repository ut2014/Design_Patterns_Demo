package com.it5.design_patterns_demo.image04;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.it5.design_patterns_demo.ImgUtil;
import com.it5.design_patterns_demo.image01.ImageCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by IT5 on 2016/8/15.
 */
public class ImageLoader_4 {
    //图片缓存
    ImageCache imageCache=new MemoryCache();
    //
    ExecutorService service= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    //注入缓存实现
    public void setImageCache(ImageCache cache){
        imageCache=cache;
    }

    public void displayImage(String imgstring, ImageView imageView){
        Bitmap bitmap=imageCache.get(imgstring);
        if (bitmap!=null) {
            ImgUtil.displayImg(imageView,bitmap);
            return;
        }
        //图片没缓存，提交至线程池中下载图片
        submitLoadrequest(imgstring,imageView);
    }

    private void submitLoadrequest(final String imgurl, final ImageView imageView) {
        imageView.setTag(imgurl);
        service.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap=ImgUtil.downloadImage(imgurl);
                if (bitmap==null) {
                    return;
                }
                if (imageView.getTag().equals(imgurl)) {
                    ImgUtil.displayImg(imageView,bitmap);
                }
                imageCache.put(imgurl,bitmap);
            }
        });
    }
}
