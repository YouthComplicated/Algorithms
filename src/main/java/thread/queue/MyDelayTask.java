package thread.queue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author: nj
 * @date: 2020-11-28 01:45
 * @version: 0.0.1
 */
public class MyDelayTask {


    public static void main(String[] args) {


    }


}



//DelayQueue只能添加(offer/put/add)实现了Delayed接口的对象
class MyTask implements Delayed{

    private String name ;
    private long start = System.currentTimeMillis();
    private long time ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public long getDelay(TimeUnit unit) {

        return unit.convert((start+time) - System.currentTimeMillis(),TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return 0;
    }
}