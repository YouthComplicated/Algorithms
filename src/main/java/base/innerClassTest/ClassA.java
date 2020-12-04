package base.innerClassTest;

/**
 * @author: nj
 * @date: 2020-10-01 17:31
 * @version: 0.0.1
 */
public class ClassA {

    private int a;

    private int b;

    /**
     * 私有全局变量
     */
    private static String name;



    /**
     * 而外部类要访问内部类中的成员需要:内部类.成员或者内部类对象.成员。  ????
     */
    public void getInner(){
        /**
         * 不需要getA(),即使是私有方法
         */
        int a = new InnerA().a;


    }


    class InnerA{
        private int a;

        public int c;

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        /**
         * 使用外部类私有数据
         */
        public  void get(){
            String name = ClassA.name;
        }
    }

    /**
     * 作用？？？？
     */
    final class InnerB{

        /**
         * 非static的内部类中的成员不能声明为static的，只有在外部类或static的内部类中才可声明static成员。
         */
//        static int aa;

    }

    private class InnerC{

    }

    protected class InnerD{

    }

    abstract class InnerF{

    }



    public static void main(String[] args) {
        ClassA a = new ClassA();
        /**
         * 匿名内部类
         */
        new ClassA().callInner(new A(){
            //接口是不能new但此处比较特殊是子类对象实现接口，只不过没有为对象取名
            public void fun1() {
                System.out.println("implement for fun1");
            }
        });// 两步写成一步了

    }


    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void callInner(A a) {
        a.fun1();
    }
}

interface  A{
    void fun1();
}