package com.it5.design_patterns_demo.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by IT5 on 2016/8/16.
 */
public class CloseUtils {
    private CloseUtils(){}

    /**
     * 关闭closeable对象
     */
    public static void closeQuietly(Closeable closeable){
        if (null!=closeable) {
            try{
                closeable.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}
