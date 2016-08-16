package com.it5.design_patterns_demo.lsp;

/**
 * Created by IT5 on 2016/8/16.
 * 建立视图抽象，测量视图的宽高为公用代码，绘制实现交给具体的子类
 */
public abstract class View1 {
    public abstract void draw();
    public void measure(int width,int height){

    }
}
