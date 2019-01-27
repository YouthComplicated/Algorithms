package Thread;

import java.util.function.Supplier;

/**
 * todo 应用的那些场景
 * eg:追踪多线程程序所花费的时间(每个线程)
 *
 */
public class ThreadLocalTest {


    private ThreadLocal<Integer> count = new ThreadLocal<Integer>() {
        protected Integer initialValue() {
            return new Integer(0);
        };
    };

    Supplier<Integer> supplier = ()->0;

   private ThreadLocal<Integer> count1 = ThreadLocal.withInitial(supplier);

    public int getNext() {
        Integer value = count.get();
        value++;
        count.set(value);
        return value;
    }

    public static void main(String[] args) {
        ThreadLocalTest d = new ThreadLocalTest();
        new Thread(()->{
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " " + d.getNext());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }).start();

        new Thread(()->{
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " " + d.getNext());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }).start();
    }
}
