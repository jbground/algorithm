package org.jsjeong.design.strategy;

public class Squeak implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("삑");
    }
}
