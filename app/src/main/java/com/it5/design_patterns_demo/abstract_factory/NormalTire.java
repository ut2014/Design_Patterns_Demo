package com.it5.design_patterns_demo.abstract_factory;

/**
 * Created by IT5 on 2016/8/24.
 */
public class NormalTire implements ITire{
    @Override
    public void tire() {
        System.out.println("普通轮胎");
    }
}
