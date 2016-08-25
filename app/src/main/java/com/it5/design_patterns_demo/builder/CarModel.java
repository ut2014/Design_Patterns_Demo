package com.it5.design_patterns_demo.builder;

import java.util.ArrayList;

/**
 * Created by IT5 on 2016/8/24.
 * 定义一个车的抽象类，所有的车辆都继承这里
 */
public abstract class CarModel {
    //这个参数是各个基本方法的执行顺序
    private ArrayList<String> sequence=new ArrayList<>();

    //启动
    protected  abstract void start();
    //停止
    protected abstract  void stop();
    //喇叭
    protected  abstract  void alarm();
    //发动机
    protected abstract void engineBoom();

    //跑
    final public void run(){
        for (int i=0;i<sequence.size();i++) {
            String actionName=sequence.get(i);
            if (actionName.equalsIgnoreCase("start")) {//start
                start();
            }else if(actionName.equalsIgnoreCase("stop")){
                stop();
            }else if(actionName.equalsIgnoreCase("alarm")){
                alarm();
            }else if(actionName.equalsIgnoreCase("engine room")){
                engineBoom();
            }
        }
    }

    final public void setSequence(ArrayList<String> sequence){
        this.sequence=sequence;
    }
}
