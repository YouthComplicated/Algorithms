package thread.lock;

public class AQSLockTest {

    private AQSLock aqsLock = new AQSLock();

    private  int value ;

    private int getNext(){
//        aqsLock.lock();
//        int a = value ++;
//        aqsLock.unlock();
//        return a;
        aqsLock.lock();
        try {
            Thread.sleep(300);
            return value ++;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw  new RuntimeException();
        }finally {
            aqsLock.unlock();
        }
    }


    public void a() {
        aqsLock.lock();
        System.out.println("a");
        b();
        aqsLock.unlock();
    }

    public void b() {
        aqsLock.lock();
        System.out.println("b");
        aqsLock.unlock();
    }

//    private int getNext(){
//        try {
//            thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return value ++;
//    }

    public static void main(String[] args) {

        AQSLockTest test = new AQSLockTest();

        new Thread(()->{
            test.a();
        }).start();

//        new thread(()->{
//            while (true){
//                System.out.println(thread.currentThread().getName()+" "+test.getNext());
//            }
//        }).start();
//        new thread(()->{
//            while (true){
//                System.out.println(thread.currentThread().getName()+" "+test.getNext());
//            }
//        }).start();
//        new thread(()->{
//            while (true){
//                System.out.println(thread.currentThread().getName()+" "+test.getNext());
//            }
//        }).start();

    }
}
