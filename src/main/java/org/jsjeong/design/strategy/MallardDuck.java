package org.jsjeong.design.strategy;

public class MallardDuck extends Duck{

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.print("저는 물오리입니다. : ");
    }
}
