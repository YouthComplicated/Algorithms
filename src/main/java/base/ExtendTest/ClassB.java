package base.ExtendTest;

/**
 * @author: nj
 * @date: 2020-03-19 11:18
 * @version: 0.0.1
 */
public class ClassB extends ClassA{

    /**
     * 与子类出现同名的成员
     */
    private String name;

    private String address;

    private Integer number = 222222;

    /**
     * 子类中所有的构造器默认都会访问父类中空参数的构造器
     */
//    public ClassB(){
//        //会调用父类默认的构造器
//        System.out.println("number:" + super.number);
//        System.out.println("country:");
//    }

    public ClassB(String address){
        super(address);
        this.name = "xxxx";
        this.address = address;
        //父子类中同名的属性使用super区分
        this.address = super.name + name;
    }

//    public ClassB(String name){
//        super(name);
//    }

    public ClassB(String name, Integer age, String address) {
        super(name, age);
//        this();
        this.address = address;
    }

//    public ClassB(String name, String address) {
////        super(name);
//        this.address = address;
//    }

//    public ClassB(String name, Integer age){
//        super();
//    }



    public ClassB(Integer age){
        super(age);
    }

    public Integer getNumber() {
        return number;
    }
    public Integer getFatherNumber() {
        //使用super调用
        return super.number;
    }

    public static void main(String[] args) {

        ClassB classB = new ClassB("555");
        System.out.println("address:" + classB.address);
        System.out.println(classB.toString());
        System.out.println("number:" + classB.number);
        System.out.println("number:"+classB.getFatherNumber());


    }



}
