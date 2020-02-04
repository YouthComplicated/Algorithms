package jvm.classload;

public class SubClassTest {

    /**
     * 追踪加载的trace   -XX:+TraceClassLoading
     * @param args
     */
    public static void main(String[] args) {

        // 1:通过子类调用父类的静态字段不会导致子类初始化  SuperClass（父类）被初始化了。。。
        //System.out.println(Subclass.value);

//        System.out.println(new Subclass());
        //System.out.println(Subclass.vv);


        // 2:通过数组定义引用类，不会触发此类的初始化
        SuperClass[] superClasses = new SuperClass[3];
        // 3:通过new 创建对象,可以实现类初始化，必须把1下面的代码注释掉才有效果不然经过1的时候类已经初始化了，下面这条语句也就没用了。
        //SuperClass superClass = new SuperClass();

    }

}
