package headfirst.extendtest;

public class EatAnimalFood implements EatBehavior{
    @Override
    public void eat() {
        System.out.println("eat animal food...");
    }
}
