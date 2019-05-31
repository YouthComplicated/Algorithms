package headfirst.extendtest;

public class EaserDuck extends  Duck{
    @Override
    public  void fly(){
        System.out.println("--------easerDuck_fly---------");
    }


    public static void main(String[] args) {
        EaserDuck easerDuck = new EaserDuck();
        easerDuck.swim();
    }
}
