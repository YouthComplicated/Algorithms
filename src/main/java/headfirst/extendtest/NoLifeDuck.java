package headfirst.extendtest;

public class NoLifeDuck extends Duck{

    public NoLifeDuck() {
        flyBehavior = new FlyNoWings();
        eatBehavior = new EatAnimalFood();
    }

}
