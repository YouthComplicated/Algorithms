package base.ExtendTest;

/**
 * @author: nj
 * @date: 2020-03-19 11:18
 * @version: 0.0.1
 */
public class ClassA {

    public String name;

    private Integer age;

    protected Integer number = 1111111;

    public ClassA() {
        System.out.println("ClassA default constructors.......");
    }

    public ClassA(String name, Integer age) {
//        this();
        this.name = name;
        this.age = age;
    }

    public ClassA(String name) {
        this.name = name;
    }

    public ClassA(Integer age) {
        this.age = age;
    }


    public ClassA(String name, Integer age, Integer number) {
        this.name = name;
        this.age = age;
        this.number = number;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }



    @Override
    public String toString() {
        return "ClassA{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", number=" + number +
                '}';
    }

    public static void main(String[] args) {
        ClassA classA = new ClassA("aa", 1);
    }
}