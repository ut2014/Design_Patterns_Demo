package com.it5.design_patterns_demo.simple_image.policy;

import com.it5.design_patterns_demo.simple_image.request.BitmapRequest;

/**
 * Created by IT5 on 2016/8/16.
 * 加载策略接口
 */
public interface LoadPolicy {
    public int compare(BitmapRequest request,BitmapRequest request2);
}
