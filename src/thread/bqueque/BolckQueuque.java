package thread.bqueque;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BolckQueuque {

    public static BlockingQueue<String> queue = new ArrayBlockingQueue<>(3000);


    public static void main(String[] args) {

//        queue.add("1111");
//
//        new Thread(()->{
//            while (true){
//                queue.add("aa");
//                System.out.println("+++++put+++++"+queue.size());
//            }
//        }).start();



        new Thread(()->{
            while (true){
                try {
                    System.out.println("进入线程++++++");
                    String str = queue.take();
                    System.out.println("+++++take++++"+str);
                } catch (InterruptedException e) {
                    System.out.println("++++exception++++");
                    e.printStackTrace();
                }
            }
        }).start();



        new Thread(()->{
            try {
                System.out.println("+++++++provider+++++");
                Thread.sleep(3000);
                queue.put("tttttt");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();



    }


}
