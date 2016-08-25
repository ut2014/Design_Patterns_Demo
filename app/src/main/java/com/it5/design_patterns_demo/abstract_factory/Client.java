package com.it5.design_patterns_demo.abstract_factory;

import java.util.List;

/**
 * Created by IT5 on 2016/8/24.
 */
public class Client {
    public static void main(String[] args){
        CarFactory factorya=new AFactory();
        factorya.createTire().tire();
        factorya.createEngine().engine();
        factorya.createBrake().brake();
        List<Class> list= ClassUtils.getAllClassByInterface(IBrake.class);
        System.out.println(list.size());
    }
}
