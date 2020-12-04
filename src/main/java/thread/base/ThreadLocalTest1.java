package thread.base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalTest1 {



    static ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<>();
    private static final  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public static class parseDate1 implements Runnable{
        int i = 0;
        public parseDate1(int i){
            this.i=i;
        }
        @Override
        public void run() {
            try {
                Date t=tl.get().parse("2015-03-29 19:29:"+ i % 60);
                System.out.println(i+":"+t);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }





    public static class ParseDate implements Runnable{
        int i = 0;
        public ParseDate(int i){
            this.i=i;
        }
        @Override
        public void run() {
            try {
                if(tl.get()==null){
                    tl.set(sdf);
                    tl.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                }
                Date t=tl.get().parse("2015-03-29 19:29:"+ i % 60);
                System.out.println(i+":"+t);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }



    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
//        for(int i = 0; i < 1000; i++){
//            es.execute(new ParseDate(i));
//        }


        for(int i = 0; i < 1000; i++){
            es.execute(new parseDate1(i));
        }
    }





}
