package com.it5.design_patterns_demo.image04;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.it5.design_patterns_demo.interf.IImageCache;
import com.it5.design_patterns_demo.util.CloseUtils;
import com.it5.design_patterns_demo.util.ImgUtil;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by IT5 on 2016/8/16.
 * sd卡缓存diskCache
 */
public class DiskCache_4 implements IImageCache{

    @Override
    public Bitmap get(String url) {
        return BitmapFactory.decodeFile(ImgUtil.cacheDir+ ImgUtil.imgName(url));
    }

    @Override
    public void put(String url, Bitmap bitmap) {
        ImgUtil.mkCacheDirs();
        FileOutputStream outputStream=null;
        try {
            outputStream=new FileOutputStream(url);
            bitmap.compress(Bitmap.CompressFormat.PNG,100,outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            CloseUtils.closeQuietly(outputStream);
        }
    }
}
