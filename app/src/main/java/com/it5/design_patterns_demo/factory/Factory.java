package com.it5.design_patterns_demo.factory;

/**
 * Created by IT5 on 2016/8/24.
 */
public abstract class Factory {
    /**
     * 抽象工厂方法
     * 具体由子类实现
     *
     * @return 具体的产品对象
     * */
    public abstract <T extends Product> T createProduct(Class<T> clz);
}
