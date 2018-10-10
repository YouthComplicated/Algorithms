package base;

import org.junit.Test;

public class simpleTest {

    public static int mystrey(int a, int b){
        if(b == 0) return 0;
        if(b % 2 == 0) return mystrey(a+a, b/2);
        return mystrey(a+a, b/2) + a;
    }

    public static void main(String[] args) {
        System.out.println(11122);
        System.out.println(simpleTest.mystrey(2,25));
    }

    @Test
    public void testOverFlow(){
        System.out.println(Math.abs(-2147483648));
        System.out.println(1%2);

        System.out.println(simpleTest.mystrey(3,11));
    }

    @Test
    public void testDouble(){
        //Infinity 无穷大
        System.out.println(Double.POSITIVE_INFINITY); // 1.0 / 0.0;
        System.out.println(Double.NEGATIVE_INFINITY); // -1.0 / 0.0;
    }


    /**
     * 7
     * 200.0000002
     * true
     * 1.618
     * 10.0
     * true
     * 33
     */
    @Test
    public void test(){
        /**
         *  涉及运算的精度提升问题
         *  运算的优先级
         */
        System.out.println((0+15)/2);
        System.out.println(2.0e-6 * 100000000.1);
        System.out.println( true && false || true && true); // 运算符的优先级问题
        System.out.println((1+2.236)/2);
        System.out.println(1+2+3+4.0);
        System.out.println(4.1>=4);
        System.out.println(1+2+"3");
    }

}
