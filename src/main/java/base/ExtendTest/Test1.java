package base.ExtendTest;

/**
 * @author: nj
 * @date: 2020-10-02 15:15
 * @version: 0.0.1
 */
public class Test1 {

    static int printInit(String str){
        System.out.println(str);
        return 0;
    }

    private int i = 10;

    protected int k1 = 4;

    Test1(){
        System.out.println("Test1 constructor.....");
    }


    static {
        System.out.println("Test1 static body.....");
    }
    private static int j = printInit("Test1 static variable");


    {
        System.out.println("Test1 no-static body.....");
    }

}