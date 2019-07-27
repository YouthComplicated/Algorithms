package jdk.serialization.serial;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Cat implements Animal, Externalizable {


    private Bird bird;

    @Override
    public String eatSomething() {
        return "fresh fish and bird!";
    }

    private String name;

    private Integer age;

    public Cat(Bird bird, String name, Integer age) {
        this.bird = bird;
        this.name = name;
        this.age = age;
    }

    public Cat(String name, Integer age) {
        this.name = name;
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
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }

    @Override
    public String toString() {
        return "Cat{" +
                "bird=" + bird +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
