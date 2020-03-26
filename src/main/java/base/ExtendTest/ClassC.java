package base.ExtendTest;

/**
 * @author: nj
 * @date: 2020-03-19 11:18
 * @version: 0.0.1
 */
public class ClassC extends ClassB{

    static {
        System.out.println(111);
//        System.out.println(sex);
//        System.out.println(a);
    }

    private char sex;

    private static char a;

    public ClassC(String name, Integer age, String address) {
        super(name, age, address);
    }

    public ClassC(String name){
        super(name);
    }

    public ClassC(char sex,Integer age){
        super(age);
//        this();
        this.sex = sex;
    }

    public ClassC(String name, char sex) {
        super(name);
    }
}