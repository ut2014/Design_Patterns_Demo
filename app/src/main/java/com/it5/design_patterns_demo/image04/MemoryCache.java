package com.it5.design_patterns_demo.image04;

import android.graphics.Bitmap;

import com.it5.design_patterns_demo.interf.ImageCache;

/**
 * Created by IT5 on 2016/8/15.
 */
public class MemoryCache implements ImageCache {
    @Override
    public Bitmap get(String url) {
        return null;
    }

    @Override
    public void put(String url, Bitmap bitmap) {

    }
}
