package Thread.ProAndConsumer;

/**
 *
 */
public class Mall {

    private int count;

    private final int MAX_COUNT = 20;

    //生产
    public synchronized void produce(){
        while(count >= MAX_COUNT) {
            try {
                System.out.println(Thread.currentThread().getName() + " 库存数量达到上限，生产者停止生产。");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count ++;
        System.out.println(Thread.currentThread().getName() + " 生产者生产，当前库存为：" + count);
        notifyAll();
    }

    //消费
    public synchronized void consume(){
        while(count <= 0) {
            try {
                System.out.println(Thread.currentThread().getName() + " 库存数量为零，消费者等待。");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count --;
        System.out.println(Thread.currentThread().getName() + " 消费者消费，当前库存为：" + count);
        notifyAll();
    }


}
