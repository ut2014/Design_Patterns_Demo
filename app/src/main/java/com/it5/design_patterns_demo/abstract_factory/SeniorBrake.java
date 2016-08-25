package com.it5.design_patterns_demo.abstract_factory;

/**
 * Created by IT5 on 2016/8/24.
 */
public class SeniorBrake implements IBrake {
    @Override
    public void brake() {
        System.out.println("高级制动");
    }
}
