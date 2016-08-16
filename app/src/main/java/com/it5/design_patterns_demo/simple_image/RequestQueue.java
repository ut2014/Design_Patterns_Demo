package com.it5.design_patterns_demo.simple_image;

import com.it5.design_patterns_demo.simple_image.request.BitmapRequest;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by IT5 on 2016/8/16.
 * 请求队列，使用优先队列，使得请求可以按照优先级进行处理
 * 【thread safe】
 */
public class RequestQueue {
    //请求队列
    private BlockingQueue<BitmapRequest> mRequestQueue
            =new PriorityBlockingQueue<BitmapRequest>();
    //请求的序列化生成器
    private AtomicInteger serialNumGenerator=new AtomicInteger(0);

    //默认的核心数 cpu+1
    public static int DEFAULT_CORE_NUMS=Runtime.getRuntime().availableProcessors()+1;

    private int dispatcherNums=DEFAULT_CORE_NUMS;
    //networkexecutor 执行网络请求的线程；
    private RequestDispatcher[] dispatchers=null;

    protected RequestQueue(){
        this(DEFAULT_CORE_NUMS);
    }

    //线程核心数，http执行器
    protected RequestQueue(int coreNums){
        dispatcherNums=coreNums;

    }

    public void addRequest(BitmapRequest request) {

    }

    public void stop() {

    }

    public void start() {

    }
}
