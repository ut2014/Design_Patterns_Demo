package com.it5.design_patterns_demo.abstract_factory;

import com.it5.design_patterns_demo.abstract_factory.IBrake;

/**
 * Created by IT5 on 2016/8/24.
 */
public class NormalBrake implements IBrake {
    @Override
    public void brake() {
        System.out.println("普通制动");
    }
}
