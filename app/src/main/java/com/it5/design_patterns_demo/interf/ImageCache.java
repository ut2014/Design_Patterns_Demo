package com.it5.design_patterns_demo.interf;

import android.graphics.Bitmap;

/**
 * Created by IT5 on 2016/8/15.
 */
public interface ImageCache {
    public Bitmap get(String url);
    public void put(String url,Bitmap bitmap);
}
