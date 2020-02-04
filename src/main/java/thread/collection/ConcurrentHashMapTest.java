package thread.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.UUID;

public class ConcurrentHashMapTest {


    /**
     *
     */
    @Test
    public void test01(){
        final HashMap<String, String> map = new HashMap<>(2);
        Thread t = new Thread(() -> {

                for (int i = 0; i < 10000; i++) {
                    new Thread(() ->
                            map.put(UUID.randomUUID().toString(), ""),"ftf" + i).start();

                }
        }, "ftf");

        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
