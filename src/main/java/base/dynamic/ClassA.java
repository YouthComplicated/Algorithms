package base.dynamic;

/**
 * @author: nj
 * @date: 2020-05-02 15:23
 * @version: 0.0.1
 */
public class ClassA {


    private String name = "ClassA";

    protected String job = "JobA";


    public ClassA() {

    }

    public void sayHi(){

        System.out.println("------ClassA-----sayHi----------");

    }

    public void doSomething(){

        System.out.println("------ClassA-----doSomething----------");

    }


    public ClassA(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "ClassA{" +
                "name='" + name + '\'' +
                '}';
    }
}