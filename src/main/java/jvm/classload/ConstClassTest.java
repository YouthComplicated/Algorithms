package jvm.classload;

public class ConstClassTest {

    /**
     * ③常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用定义常量的类，因此不会触发定义常量的类的初始化
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(ConstClass.HELLO);//输出结果：hello world
    }

}
