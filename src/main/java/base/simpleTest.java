package base;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class simpleTest {
    /**
     * ???
     * @param a
     * @param b
     * @return
     */
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
        System.out.println(Double.POSITIVE_INFINITY); // 1.0 / 0.0;  Infinity
        System.out.println(Double.NEGATIVE_INFINITY); // -1.0 / 0.0;  -Infinity

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
        // 运算符的优先级问题
        System.out.println( true && false || true && true);
        System.out.println((1+2.236)/2);
        System.out.println(1+2+3+4.0);
        System.out.println(4.1>=4);
        System.out.println(1+2+"3");


        //System.out.println(1/0); //java.lang.ArithmeticException: / by zero
        System.out.println(1.0/0.0);//Infinity

    }


    @Test
    public void testPrintln(){
        /**
         * 字面量的值
         */
        System.out.println('b');
        System.out.println('b'+'c');
        System.out.println((char)('a'+4));
    }

    @Test
    public void test1(){
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++){
            System.out.println(f);
            f = f + g;
            g = f - g;
        }
    }

    @Test
    public void test2(){
        double t = 9.0;
        System.out.println();
        while (Math.abs(t - 9.0/t) > .001){
            t = (9.0/t + t) / 2.0;
            System.out.println(t);
            System.out.println("math:"+Math.abs(t - 9.0/t));
        }
        System.out.printf("%.5f\n", t);
    }

    @Test
    public void test3(){
        int sum = 0;
        for(int i = 1; i < 1000; i++){
            for (int j = 0; j < i; j++){
                sum ++;
            }
            System.out.println(sum);
        }
        System.out.println(sum);
    }

    @Test
    public void test4(){
        int sum = 0;
        for(int i = 1; i < 1000; i *= 2){
            for (int j = 0; j < 1000; j++){
                sum ++;
            }
            System.out.println(sum);
        }
        System.out.println(sum);
    }


    public static int  lg(int m){

        int k = 0;
        if(m >= 0){
            int a = 1;
            while (a <= m){
                a *= 2;
                k ++;
            }
        }else{
            int a = 1;
            while (a <= m){
                a /= 2;
                k --;
            }
        }
        return k;
    }

    @Test
    public void test5() {

    }
}
