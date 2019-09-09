package jdk.date.datetest;


import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class GetTimeStamp {


    public static void main(String[] args) {
        int type = 2;
        int interval = 3;


        for(int i = 0 ; i < 1000; i++){
            new Thread(()->{
                long time = System.currentTimeMillis();
                if(type == 2){
                    time = time - Integer.parseInt("7")*1000;
                }else if(type == 3){
                    time = time - Integer.parseInt("10")*1000;
                }
                Calendar c = Calendar.getInstance();
                c.setTime(new Date(time));
                if(interval == -1){
                }else if(interval == 0){
                    c.set(Calendar.MILLISECOND, 0);
                }else if(interval == 1){
                    c.set(Calendar.MILLISECOND, 0);
                    c.set(Calendar.SECOND,0);
                }else if(interval == 2){
                    c.set(Calendar.MINUTE, 0);
                    c.set(Calendar.MILLISECOND, 0);
                    c.set(Calendar.SECOND,0);
                }else if(interval == 3){
                    int bpmInterval = Integer.parseInt("5");
                    c.set(Calendar.MILLISECOND, 0);
                    c.set(Calendar.SECOND, (c.get(Calendar.SECOND) / bpmInterval) * bpmInterval);
                }
                System.out.println(c.getTimeInMillis());
            }).start();


        }

    }

    @Test
    public void test01(){
        long a = 0;
        for(;a<=60;a+=1){
            System.out.println("time:"+a+" 格式化之后："+a/5*5);
        }
    }
}
