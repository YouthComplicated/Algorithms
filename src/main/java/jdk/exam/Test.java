package jdk.exam;



public class Test {   //例子3

    public static void main(String[] args) {
        Person p = new Man();
        System.out.println(p.type);        //返回结果为
        System.out.println(p.getName());   //返回结果为
        Man man = new Man();
        System.out.println(man.type);        //返回结果为
        System.out.println(man.getName());   //返回结果为

    }

}

class Person{

    String type = "P";
    public static String getName() {
        String name = "Person";
        return name;
    }

    public String getName1() {
        String name = "Person1";
        return name;
    }
}

class Man extends Person{

    String type = "M";
    public static String getName(){
        String name = "Man";
        return name;
    }

    @Override
    public String getName1() {
        String name = "Man1";
        return name;
    }
}
