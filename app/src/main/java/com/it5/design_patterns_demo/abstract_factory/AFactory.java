package com.it5.design_patterns_demo.abstract_factory;

/**
 * Created by IT5 on 2016/8/24.
 */
public class AFactory extends CarFactory {
    @Override
    public ITire createTire() {
        return new NormalTire();
    }

    @Override
    public IEngine createEngine() {
        return new DomesticEngine();
    }

    @Override
    public IBrake createBrake() {
        return new NormalBrake();
    }
}
