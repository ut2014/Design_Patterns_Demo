package com.it5.design_patterns_demo.abstract_factory;

/**
 * Created by IT5 on 2016/8/24.
 */
public class SUVTire implements ITire{
    @Override
    public void tire() {
        System.out.println("越野轮胎");
    }
}
