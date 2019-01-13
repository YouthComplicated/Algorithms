package Thread;

import java.util.Timer;
import java.util.TimerTask;

public class TimeTask {

    public static void main(String[] args) {
        Timer timer  = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("===timertask start run======");
            }
       }, 0,1000);
    }
}
