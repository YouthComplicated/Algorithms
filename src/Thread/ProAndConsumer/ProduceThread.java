package Thread.ProAndConsumer;

public class ProduceThread  implements  Runnable{

    private Mall mall;

    public ProduceThread(Mall mall) {
        this.mall = mall;
    }

    @Override
    public void run() {
        while(true) {
            mall.produce();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
