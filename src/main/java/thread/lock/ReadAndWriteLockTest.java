package thread.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁演示
 */
public class ReadAndWriteLockTest {

    private Map<String, Object> map = new HashMap<>();

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private Lock readLock = readWriteLock.readLock();

    private Lock writeLock = readWriteLock.writeLock();

    public Object readMap(String key){
        readLock.lock();
        System.out.println("进入读锁....");
        try {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return  map.get(key);
        } finally {
            readLock.unlock();
            System.out.println("离开读锁....");
        }
    }

    public void writeMap(String key, String value){
        writeLock.lock();
        System.out.println("进入写锁....");
        try {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
        } finally {
            writeLock.unlock();
            System.out.println("离开写锁....");
        }
    }

    public static void main(String[] args) {
        ReadAndWriteLockTest readAndWriteLockTest = new ReadAndWriteLockTest();

        readAndWriteLockTest.map.put("aa",111);
        readAndWriteLockTest.map.put("bb",222);

        new Thread(()->{
            while (true){
                System.out.println(readAndWriteLockTest.readMap("aa"));
            }
        }).start();

        new Thread(()->{
            while (true){
                System.out.println(readAndWriteLockTest.readMap("aa"));
            }
        }).start();

//        new thread(()->{
//            while (true)
//            readAndWriteLockTest.writeMap("bb","uuiimm");
//        }).start();




    }
}
