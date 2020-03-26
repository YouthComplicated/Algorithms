package base.ExtendTest;

/**
 * @author: nj
 * @date: 2020-03-19 11:18
 * @version: 0.0.1
 */
public class ClassB extends ClassA{

    private String address;

    public ClassB(String name, Integer age, String address) {
        super(name, age);
        this.address = address;
    }

    public ClassB(String name, String address) {
        super(name);
        this.address = address;
    }

    public ClassB(String name, Integer age){
        super();
    }

    public ClassB(String name){
        super(name);
    }

    public ClassB(Integer age){
        super(age);
    }

}
