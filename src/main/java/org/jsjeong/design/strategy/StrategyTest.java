package org.jsjeong.design.strategy;

import java.util.ArrayList;
import java.util.List;

public class StrategyTest {

    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();

        Duck model = new ModelDuck();
        model.performFly();
        model.performQuack();
        model.setFlyBehavior(new FlyRocketPowered());
        model.setQuackBehavior(new Squeak());
        model.performFly();
        model.performQuack();

        List<Duck> list = new ArrayList<>();
        list.add(mallard);
        list.add(model);

        System.out.println("////////////////////////////");

        for (Duck d : list) {
            d.performFly();
        }
    }
}
