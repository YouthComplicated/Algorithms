package base.dynamic;

/**
 * @author: nj
 * @date: 2020-05-02 15:24
 * @version: 0.0.1
 */
public class ClassB extends ClassA {

    private String name = "ClassB";


    protected String job = "JobB";

    private String country = "huang gwewfww";

//    public ClassB(String name) {
//        super(name);
//    }

    public ClassB() {
    }


    public ClassB(String name, String country) {
        super(name);
        this.country = country;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void sayYes(){

        System.out.println("------ClassB-----sayYes----------");

    }

    @Override
    public void doSomething() {
//        super.doSomething();

        System.out.println("------ClassB----doSomething----------");

    }

    public static void main(String[] args) {


        ClassB b1 =  new ClassB();
        System.out.println(b1.country);
        b1.sayYes();
        b1.sayHi();

        /**
         *
         * up casting 针对子类特有的方法属性，转型之后的引用不能访问子类的这些属性
         *
         */
        ClassA b2 = new ClassB();
        //无法访问子类的属性以及方法
        /**
         * 以下代码编译错误，原因属性是在编译是确定
         */
//        System.out.println(b2.country);
//        b2.sayYes();


        /**
         *
         * 重写方法的方法调用子类的
         * 重写方法，父子类编译类型中都有的话，看实际对象是属于哪个类
         *
         *
         */
        b2.doSomething();
        System.out.println("name:" + b2.getName());
        /**
         *
         * 成员变量父子类都存在并且访问修饰符为protected
         *
         * 向上转型调用的父类的成员变量
         *
         * 不能调用父类的私有变量和方法
         */
        System.out.println("job:" + b2.job);

    }


}