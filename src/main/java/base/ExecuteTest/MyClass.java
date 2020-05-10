package base.ExecuteTest;

/**
 *
 *
 * 演示类中属性、块等内部的加载顺序
 *
 * 注意一点，代码块优于构造器加载
 *
 *
 * @author: nj
 * @date: 2020-05-07 11:11
 * @version: 0.0.1
 */
public class MyClass {

    private int number = 1;


    public MyClass(int number, int sex) {
        System.out.println("constructor.....");
        this.number = number;
        this.sex = sex;
    }

    {
        System.out.println("say hello!!!");
//        System.out.println(sex);
    }

    private int sex;

    static {
        System.out.println("static !!!");
    }


    public static void main(String[] args) {

        MyClass myClass = new MyClass(1,2);


    }






}