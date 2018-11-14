package base;

import org.junit.Test;

/**
 * 递归方法汇总
 */
public class RecursiveTest {

    /**
     * 递归的效率问题
     * @param n
     * @return
     */
    public static long F(int n ){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return F(n-1) + F(n-2);
    }


    @Test
    public void testF(){
        long start,end;
        for(int i = 0; i < 100; i ++){
            start = System.currentTimeMillis();
            System.out.println("====N:"+i+ "结果值:" + F(i));
            System.out.println("耗时:"+(System.currentTimeMillis() - start));
        }
    }

    /**
     * 二项式分布
     * @param n
     * @param k
     * @param p
     * @return
     */
    public static double binomial(int n, int k, double p ){
        if(n == 0 && k == 0){
            return 1.0;
        }

        if(n < 0 || k <0){
            return 0.0;
        }
        return (1.0-p)*binomial(n-1, k,p)+p*binomial(n-1,k-1,p);
    }

    public void testBinomial(){
        binomial(100,50,0.25);
    }

}
