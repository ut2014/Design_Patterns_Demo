package com.it5.design_patterns_demo.builder;

/**
 * Created by IT5 on 2016/8/24.
 * 奔驰车模型
 */
public class BenzModel extends CarModel{
    @Override
    protected void start() {
        System.out.println("奔驰车的开始...");
    }

    @Override
    protected void stop() {
        System.out.println("奔驰车停止...");
    }

    @Override
    protected void alarm() {
        System.out.println("奔驰车的喇叭声音是这个样子的...");
    }

    @Override
    protected void engineBoom() {
        System.out.println("奔驰车的引擎...");
    }
}
