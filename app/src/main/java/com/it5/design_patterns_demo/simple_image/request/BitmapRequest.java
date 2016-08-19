package com.it5.design_patterns_demo.simple_image.request;

import android.widget.ImageView;

import com.it5.design_patterns_demo.simple_image.SimpleImageLoader;
import com.it5.design_patterns_demo.simple_image.config.DisplayConfig;
import com.it5.design_patterns_demo.simple_image.policy.LoadPolicy;
import com.it5.design_patterns_demo.simple_image.utils.Md5Helper;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by IT5 on 2016/8/16.
 * 网络请求类，注意get和delete不能传递参数，因为其请求的性质所致，用户可以将参数构
 * 到url后传递进来到request中
 */
public class BitmapRequest implements Comparable<BitmapRequest> {
    Reference<ImageView> mImageViewRef;
    public DisplayConfig displayConfig;
    public SimpleImageLoader.ImageListener imageListener;

    public String imageUrl="";
    public String imageUrlMd5="";

    /**
     * 请求序列号
     */
    public int serialNum=0;
    //取消该请求
    public boolean isCancel=false;
    public boolean justCacheInMen=false;

    //加载策略
    LoadPolicy mLoadPolicy=SimpleImageLoader.getInstance().getConfig().loadPolicy;
    public BitmapRequest(ImageView iv, String url, DisplayConfig config,
                         SimpleImageLoader.ImageListener listener) {
        mImageViewRef=new WeakReference<ImageView>(iv);
        displayConfig=config;
        imageListener=listener;
        imageUrl=url;
        iv.setTag(url);
        imageUrlMd5= Md5Helper.toMD5(imageUrl);
    }

    public ImageView getImageView(){
        return mImageViewRef.get();
    }

    @Override
    public int compareTo(BitmapRequest another) {
        return 0;
    }

    public boolean isImageViewTagValid() {

        return false;
    }
}
