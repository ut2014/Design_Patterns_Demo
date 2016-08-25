package com.it5.design_patterns_demo.factory;

/**
 * Created by IT5 on 2016/8/24.
 */
public class Client {
    public static void main(String[] args){
        Factory factory=new ConcreteFactory();
        Product product=factory.createProduct(ConcreteProductA.class);
        product.method();
    }
}
