package headfirst.extendtest;

import org.junit.Test;

public class DuckTest {

    public static void main(String[] args) {

        WildDuck wildDuck = new WildDuck();
        wildDuck.fly();
        wildDuck.swim();

    }


    @Test
    public void testMallardDuck(){

        Duck duck = new MallardDuck();
        duck.performFly();
        duck.performEat();

        //行为指定相应的实现类
        duck.setEatBehavior(new EatAnimalFood());
        duck.performEat();

    }
}
