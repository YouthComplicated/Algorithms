package thread.tool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;

/**
 * @author: nj
 * @date: 2020-02-06 12:55
 * @version: 0.0.1
 */
public class BlockQueueTest {

    BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(100);

    BlockingQueue<String> blockingQueue1 = new LinkedBlockingDeque<>(100);

    BlockingQueue<String> blockingQueue2 = new SynchronousQueue<>();

    public static void main(String[] args) {

    }
}