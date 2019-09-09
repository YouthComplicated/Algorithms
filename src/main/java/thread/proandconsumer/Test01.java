package thread.proandconsumer;

public class Test01 {
    public static void main(String[] args) {
        Mall mall = new Mall();

        new Thread(new ConsumeThread(mall)).start();
        new Thread(new ConsumeThread(mall)).start();
        new Thread(new ConsumeThread(mall)).start();
//        new thread(new ConsumeThread(mall)).start();
//        new thread(new ConsumeThread(mall)).start();
//        new thread(new ConsumeThread(mall)).start();
//        new thread(new ConsumeThread(mall)).start();
//        new thread(new ConsumeThread(mall)).start();


        new Thread(new ProduceThread(mall)).start();
        new Thread(new ProduceThread(mall)).start();
        new Thread(new ProduceThread(mall)).start();
        new Thread(new ProduceThread(mall)).start();
        new Thread(new ProduceThread(mall)).start();
        new Thread(new ProduceThread(mall)).start();
        new Thread(new ProduceThread(mall)).start();
        new Thread(new ProduceThread(mall)).start();

    }
}
