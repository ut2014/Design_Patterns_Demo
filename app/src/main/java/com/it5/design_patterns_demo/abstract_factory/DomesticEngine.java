package com.it5.design_patterns_demo.abstract_factory;

/**
 * Created by IT5 on 2016/8/24.
 */
public class DomesticEngine implements IEngine{
    @Override
    public void engine() {
        System.out.println("国产发动机");
    }
}
