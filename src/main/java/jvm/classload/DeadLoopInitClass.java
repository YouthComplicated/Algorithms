package jvm.classload;

public class DeadLoopInitClass {

    static class LoopClass{
        //
//        static {
//            System.out.println(Thread.currentThread()+"init DeadLoopInitClass");
//            while (true){
//
//            }
//        }
        static {
            if(true){
                System.out.println(Thread.currentThread()+"init DeadLoopInitClass");
                while (true){

                }
            }
        }

    }

    public static void main(String[] args) {

        Runnable runnable = ()-> {
            System.out.println(Thread.currentThread()+" start");
            LoopClass dlic = new LoopClass();
            System.out.println(Thread.currentThread()+" run over");
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();

    }
}
