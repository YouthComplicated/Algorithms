package headfirst.extendtest;



 /**
   * @Description:普通类的继承缺点
   * @Author: NJ
   * @CreateDate:2019-05-08 10:39
   * @Version:1.0
 */
public abstract class Duck {


    public  void fly(){
        System.out.println("--------fly---------");
    }

    public  void swim(){
        System.out.println("--------swim---------");
    }

    public  void eat(){
        System.out.println("--------fly---------");
    }


//    public abstract String color(){
//
//    }

     /**
      * 将行为委托给接口
      */
     FlyBehavior flyBehavior;
     EatBehavior eatBehavior;

     public void performFly(){
         flyBehavior.fly();
     }

     public void performEat(){
         eatBehavior.eat();
     }

     public FlyBehavior getFlyBehavior() {
         return flyBehavior;
     }

     public void setFlyBehavior(FlyBehavior flyBehavior) {
         this.flyBehavior = flyBehavior;
     }

     public EatBehavior getEatBehavior() {
         return eatBehavior;
     }

     public void setEatBehavior(EatBehavior eatBehavior) {
         this.eatBehavior = eatBehavior;
     }
 }
