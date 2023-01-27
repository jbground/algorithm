package org.jsjeong.design.strategy;

public class ModelDuck extends Duck {

    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.print("저는 모형 오리입니다. : ");
    }
}
