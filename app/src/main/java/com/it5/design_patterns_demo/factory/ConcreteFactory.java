package com.it5.design_patterns_demo.factory;

/**
 * Created by IT5 on 2016/8/24.
 */
public class ConcreteFactory extends Factory {
    /**
     * 具体工厂
     * @return
     */
 /*   @Override
    public Product createProduct() {
        return new ConcreteProductA();
    }*/

    @Override
    public <T extends Product> T createProduct(Class<T> clz) {
        Product product=null;
        try {
            product= (Product) Class.forName(clz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) product;
    }
}
