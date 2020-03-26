package base.ExtendTest;

/**
 * @author: nj
 * @date: 2020-03-19 11:18
 * @version: 0.0.1
 */
public class ClassA {

    private String name;

    private Integer age;

    public ClassA() {
    }

    public ClassA(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public ClassA(String name) {
        this.name = name;
    }

    public ClassA(Integer age) {
        this.age = age;
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
                '}';
    }
}