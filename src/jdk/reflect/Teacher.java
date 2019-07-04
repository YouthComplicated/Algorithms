package jdk.reflect;

import jdk.classTest.Country;

public class Teacher<T> extends Country<T>{



    public String city;

    public Integer workExperience;

    private String userName;
    private Integer age;
    private Character sex;

    private String nameStr;

    private T t;

    public String privateField(String nameStr, int t){
        System.out.println("+++++++invoke:[privateField]++++++");
        this.nameStr = nameStr+t+1223232;
        return  132 + nameStr + t;
    }

    private String privateMethod(String a, Integer b){
        System.out.println("+++++++invoke:[privateMethod]++++++");
        return a;
    }

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

    public String doSomething(int num){
        System.out.println("+++++invoke[doSomething]++++++");
        return "tttt"+num;
    }

    public Teacher(String userName) {
        this.userName = userName;
    }

    private void getAdder(){
        System.out.println("=======getAdder=======");
    }

    public void getMajor(){
        System.out.println("=======getMajor=======");
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

    @Override
    public String toString() {
        return "Teacher{" +
                "city='" + city + '\'' +
                ", workExperience=" + workExperience +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", t=" + t +
                '}';
    }
}
