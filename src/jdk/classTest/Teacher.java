package jdk.classTest;

public class Teacher<T> extends Country<T>{



    private String userName;
    private Integer age;
    private Character sex;

    private T t;

    public Teacher(String userName, Integer age, Character sex) {
        this.userName = userName;
        this.age = age;
        this.sex = sex;
    }

    public Teacher(String userName, Integer age, Character sex, T t) {
        this.userName = userName;
        this.age = age;
        this.sex = sex;
        this.t = t;
    }

    public Teacher() {
    }

    public Teacher(T t) {
        this.t = t;
    }

    public Teacher(Integer age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }
}
