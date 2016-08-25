package com.it5.design_patterns_demo.builder;

import java.util.ArrayList;

/**
 * Created by IT5 on 2016/8/24.
 * 最终客户开始使用这个模型
 */
public class Client {
    public static void main(String[] args){
        ArrayList<String> sequence=new ArrayList<>();
        sequence.add("engine room");
        sequence.add("start");

        BenzModel benz=new BenzModel();
        benz.setSequence(sequence);
        benz.run();
    }
}
