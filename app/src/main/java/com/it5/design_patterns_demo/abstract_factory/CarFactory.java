package com.it5.design_patterns_demo.abstract_factory;

/**
 * Created by IT5 on 2016/8/24.
 */
public abstract class CarFactory {
    //生产轮胎
    public abstract ITire createTire();
    //生产发动机
    public abstract IEngine createEngine();

    //生产制动系统
    public abstract IBrake createBrake();

}
