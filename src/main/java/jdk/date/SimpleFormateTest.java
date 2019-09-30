package jdk.date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleFormateTest {


    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    /**
     * pase
     */
    @Test
    public void test01(){

//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(sdf.format(date));

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        for(int i = 0; i < 30; i++){
            executorService.execute(()->{
                for(int j = 0; j < 10; j++){
                    try {
                        System.out.println(sdf.parse("2019-09-25 15:36:15"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

            });
        }

        executorService.shutdown();

    }


    /**
     * 如何实现format() 线程不安全
     */
    @Test
    public void test02(){

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        for(int i = 0; i < 30; i++){
            executorService.execute(()->{
                for(int j = 0; j < 10; j++){
                    try {
                        Date date = new Date();
                        System.out.println(sdf.format(date));
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            });
        }

        executorService.shutdown();
    }



    @Test
    public void test03(){

        Date date = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat();
        System.out.println(sdf1.format(date));

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINESE);
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.UK);
        System.out.println(sdf2.format(date));
        System.out.println(sdf3.format(date));

        System.out.println(sdf2.toPattern());

        System.out.println(sdf2.toLocalizedPattern());

        System.out.println(sdf2.formatToCharacterIterator(date).toString());

    }


















}
