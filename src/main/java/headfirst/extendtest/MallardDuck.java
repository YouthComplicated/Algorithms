package headfirst.extendtest;

public class MallardDuck extends Duck {


    public MallardDuck() {
        flyBehavior = new FlyWithWings();
        eatBehavior = new EatGreenFood();
    }
}
