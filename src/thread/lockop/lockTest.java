package thread.lockop;

import org.junit.Test;

import java.util.List;
import java.util.Vector;

public class lockTest {

    /**
     * 锁的粗化
     */
    public void test01(){

        synchronized (this){
            //do sth1
        }

        //做其他不需要的同步的工作，但能很快执行完毕
        synchronized (this){
            //do sth2
        }

    }


    public void test02(){
        synchronized (this){
            //do sth1
            //do sth2
        }
    }



    public void cycle01(){

        for(int i = 0; i < 100; i++){
            synchronized (this){
                //do sth
            }
        }

    }

    public void cycle02(){

        synchronized (this){
            for(int i = 0; i < 100; i++){
                //do sth
            }
        }

    }

    public static void main(String[] args) {
        /**
         * 锁的消除
         *
         * -server -XX:+DoEscapeAnalysis-XX:+EliminateLocks
         *  85ms
         *
         * -server -XX:+DoEscapeAnalysis-XX:-EliminateLocks
         *
         * 160ms
         */
        int cycle = 2000000;
        long start = System.currentTimeMillis();
        for(int i = 0; i < cycle; i++){
            createStr("YUN","UINW");
        }
        long cost = System.currentTimeMillis() - start;

        System.out.println("====cost===="+cost);

    }



    public static String createStr(String s1, String s2){
        StringBuffer sb = new StringBuffer();
        sb.append(s1);
        sb.append(s2);
        return sb.toString();
    }




    public static List<Integer> numberList = new Vector<>();


    /**
     * 偏向锁
     *
     * -XX:+UseBiasedLocking-XX:BiasedLockingStartupDelay=0
     * 250 ms
     *
     * -XX:-UseBiasedLocking
     * 400 ms
     *
     */
    @Test
    public void TestLock1(){
        long start = System.currentTimeMillis();
        int count = 0,startnum = 0;
        while (count < 10000000){
            numberList.add(startnum);
            startnum ++;
            count++;
        }
        System.out.println("耗时时间:"+(System.currentTimeMillis() - start));


    }













}
