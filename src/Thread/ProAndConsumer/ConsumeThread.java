package Thread.ProAndConsumer;

public class ConsumeThread  implements Runnable{

    private Mall mall;

    public ConsumeThread(Mall mall) {
        this.mall = mall;
    }

    @Override
    public void run() {
        while (true){
            mall.consume();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
