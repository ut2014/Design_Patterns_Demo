package com.it5.design_patterns_demo.image01;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.it5.design_patterns_demo.ImgUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by IT5 on 2016/8/15.
 */
public class ImageLoader_1 {
    //图片缓存
    private ImageCache imageCache=new ImageCache();
    //线程池，线程数量为cpu的数量
    ExecutorService service= Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors()
    );
    public  void displayImage(final String url, final ImageView imageView){
        if (imageView==null) {
            return;
        }
        final Bitmap bitmap=imageCache.get(url);
        if (bitmap!=null){
//            imageView.setImageBitmap(bitmap);
            ImgUtil.displayImg(imageView,bitmap);
            return;
        }
        imageView.setTag(url);
        service.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap= ImgUtil.downloadImage(url);
                if (bitmap==null) {
                    return;
                }
                if (imageView.getTag().equals(url)) {
//                    imageView.setImageBitmap(bitmap);
                    ImgUtil.displayImg(imageView,bitmap);
                }
                imageCache.put(url,bitmap);
            }
        });

    }
}
