package jdk.serialization.serial;

import java.beans.Transient;
import java.io.Serializable;

public class Bird implements Serializable {

    transient  private String home;

    private String name;

    private Integer age;

    public Bird(String home, String name, Integer age) {
        this.home = home;
        this.name = name;
        this.age = age;
    }

    public Bird(String name, Integer age) {
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
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
