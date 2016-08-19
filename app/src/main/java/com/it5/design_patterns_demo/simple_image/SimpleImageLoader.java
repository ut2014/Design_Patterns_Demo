package com.it5.design_patterns_demo.simple_image;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.it5.design_patterns_demo.simple_image.cache.BitmapCache;
import com.it5.design_patterns_demo.simple_image.cache.MemoryCache;
import com.it5.design_patterns_demo.simple_image.config.DisplayConfig;
import com.it5.design_patterns_demo.simple_image.config.ImageLoaderConfig;
import com.it5.design_patterns_demo.simple_image.policy.SerialPolicy;
import com.it5.design_patterns_demo.simple_image.request.BitmapRequest;

/**
 * Created by IT5 on 2016/8/16.
 */
public class SimpleImageLoader {
    //imageLoader 实例
    private static SimpleImageLoader instance;
    //网络请求队列
    private RequestQueue imageQueue;
    //缓存
    private volatile BitmapCache cache=new MemoryCache();
    //图片加载配置对象
    private ImageLoaderConfig iconfig;
    private SimpleImageLoader(){}

    /**
     * 获取单 列，
     */
    public static SimpleImageLoader getInstance(){
        if (instance==null) {
            synchronized (SimpleImageLoader.class){
                if (instance==null) {
                    instance=new SimpleImageLoader();
                }
            }
        }
        return instance;
    }

    public void displayImage(ImageView iv,String url){
        displayImage(iv,url,null,null);
    }
    public void displayImage(ImageView iv,String url,ImageListener listener){
        displayImage(iv,url,null,listener);
    }
    public void displayImage(ImageView iv, String url, DisplayConfig config, ImageListener listener){
        BitmapRequest request=new BitmapRequest(iv,url,config,listener);
        //加载的配置对象，如果没有设置，则使用imageloader的配置
        request.displayConfig=request.displayConfig!=null?request.displayConfig:
                iconfig.displayConfig;
        //添加到队列中
        imageQueue.addRequest(request);

    }
    public void stop(){
        imageQueue.stop();
    }

    /**
     * 通过配置类初始化imageloader，设置线程数量，缓存策略
     */
    public void init(ImageLoaderConfig iconfig){
        this.iconfig=iconfig;
        cache=iconfig.bitmapCache;
        checkConfig();
        imageQueue=new RequestQueue(iconfig.threadCount);
        imageQueue.start();
    }

    private void checkConfig() {
        if (iconfig==null) {
            throw new RuntimeException(
                    "The config of SimpleImageLoader is Null, please call the init(ImageLoaderConfig config) method to initialize");
        }
        if (iconfig.loadPolicy==null) {
            iconfig.loadPolicy=new SerialPolicy();
        }
        if (cache==null){
            cache=new MemoryCache();
        }
    }

    public ImageLoaderConfig getConfig() {
        return iconfig;
    }


    //图片加载listener,加载完成后回调给客户端代码
    public static interface  ImageListener{
        public void onComplete(ImageView iv,Bitmap bmp,String url);
    }
}
