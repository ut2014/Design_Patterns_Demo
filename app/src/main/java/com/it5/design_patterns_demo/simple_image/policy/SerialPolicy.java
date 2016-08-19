package com.it5.design_patterns_demo.simple_image.policy;

import com.it5.design_patterns_demo.simple_image.request.BitmapRequest;

/**
 * Created by IT5 on 2016/8/16.
 */
public class SerialPolicy implements LoadPolicy{
    @Override
    public int compare(BitmapRequest request, BitmapRequest request2) {
        // 如果优先级相等,那么按照添加到队列的序列号顺序来执行
        return request.serialNum-request2.serialNum;
    }
}
