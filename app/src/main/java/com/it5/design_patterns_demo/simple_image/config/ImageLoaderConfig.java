package com.it5.design_patterns_demo.simple_image.config;

import com.it5.design_patterns_demo.simple_image.cache.BitmapCache;
import com.it5.design_patterns_demo.simple_image.cache.MemoryCache;
import com.it5.design_patterns_demo.simple_image.policy.LoadPolicy;
import com.it5.design_patterns_demo.simple_image.policy.SerialPolicy;

/**
 * Created by IT5 on 2016/8/16.
 * imageloader配置类
 */
public class ImageLoaderConfig {
    /**
     * 图片缓存配置对象
     */
    public BitmapCache bitmapCache=new MemoryCache();

    //加载图片时的loading和加载失败的图片配置对象
    public DisplayConfig displayConfig=new DisplayConfig();

    //加载策略
    public LoadPolicy loadPolicy=new SerialPolicy();

    public int threadCount=Runtime.getRuntime().availableProcessors()+1;

    public ImageLoaderConfig setThreadCount(int count){
        threadCount=Math.max(1,count);
        return this;
    }

    public ImageLoaderConfig setCache(BitmapCache cache){
        bitmapCache=cache;
        return this;
    }
}
