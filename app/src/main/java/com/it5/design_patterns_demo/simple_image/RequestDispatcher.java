package com.it5.design_patterns_demo.simple_image;

import android.util.Log;

import com.it5.design_patterns_demo.simple_image.load.Loader;
import com.it5.design_patterns_demo.simple_image.load.LoaderManager;
import com.it5.design_patterns_demo.simple_image.request.BitmapRequest;

import java.util.concurrent.BlockingQueue;

/**
 * Created by IT5 on 2016/8/16.
 * 网络请求dispatcher ,继承thread 从网络请求队列中循环读取请求并且执行
 */
public class RequestDispatcher extends Thread{
    //网络请求队列
    private BlockingQueue<BitmapRequest> requestQueue;

    public RequestDispatcher(BlockingQueue<BitmapRequest> queue) {
        requestQueue=queue;
    }

    @Override
    public void run() {
        try{
            while (!isInterrupted()){
                final BitmapRequest request=requestQueue.take();
                if (request.isCancel) {
                    continue;
                }
                final String schema=parseSchema(request.imageUrl);
                Loader imageLoader= LoaderManager.getInstance().getLoader(schema);
                imageLoader.loadImage(request);
            }
        }catch (InterruptedException e){
            Log.i("","### 请求分发器退出");
        }
    }

    private String parseSchema(String url){
        if (url.contains("://")) {
            return url.split("://")[0];
        }else {
            Log.e(getName(), "### wrong scheme, image uri is : " + url);
        }
        return "";
    }
}
