package base.ExtendTest;

/**
 *
 * 程序执行过程
 * 1、声明成员变量的默认值
 * 2、显式初始化、多个初始化块依次被执行（同级别下按先后顺序执行）staic块优于普通代码块
 * 3、构造器再对成员进行赋值操作
 * 当类被载入时，类属性的声明和静态代码块先后顺序被执行，且只被执行一次。类属性声明和静态代码
 *
 * @author: nj
 * @date: 2020-05-02 14:42
 * @version: 0.0.1
 */
public class Base {

    public Integer number = 00000;

    protected String country = "china";


    {
        System.out.println(111);
    }

    static {
        System.out.println("静态代码块只能加载一次");
    }

    {
        System.out.println(333);
    }



    public Base(String country) {
        System.out.println("构造器");
        this.country = country;
    }

    public static void main(String[] args) {
        Base b = new Base("");
        System.out.println("==========");
        Base c = new Base("");
    }




}