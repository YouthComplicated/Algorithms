package headfirst.extendtest;

public class FlyNoWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("fly with no wings...");
    }
}
