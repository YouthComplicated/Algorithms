package base.ExtendTest;

/**
 *
 * 父子类中的继承顺序
 *
 * @author: nj
 * @date: 2020-10-02 15:19
 * @version: 0.0.1
 */
public class Test2 extends Test1 {


    int k = printInit("Test2 no-static vaiable");

    public Test2() {
        System.out.println("Test2 constructor......");
        System.out.println(k+";"+k1+";");
    }

    public void aa(){
        System.out.println(1111);
    }


    private  static int l =  printInit("Test2 static variable ");


    static {
        System.out.println("Test2 static body....");
    }


    public static void main(String[] args) {
//        Test2 t = new Test2();

        System.out.println("111111xxxxxxx");

        Test1 t1 =  new Test2();
//        t1.k;
//        t1.aa();

    }
}