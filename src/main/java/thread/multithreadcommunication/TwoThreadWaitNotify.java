package thread.multithreadcommunication;

/**
 * @author: nj
 * @date: 2020-03-30 15:44
 * @version: 0.0.1
 */
public class TwoThreadWaitNotify {

    private int start = 1;

    /**
     * 奇数偶数的判断 是否为奇数
     */
    private boolean flag = true;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }


    public static void main(String[] args) {

        TwoThreadWaitNotify twoThread = new TwoThreadWaitNotify();

        Thread t1 = new Thread(new oddNumber(twoThread));
        t1.setName("A");
        Thread t2 = new Thread(new evenNumber(twoThread));
        t2.setName("B");
        t2.start();
        t1.start();
    }



}


/**
 * 奇数判断
 */
class oddNumber implements Runnable{

    private TwoThreadWaitNotify  num;

    public oddNumber(TwoThreadWaitNotify num) {
        this.num = num;
    }

//    public TwoThreadWaitNotify getNum() {
//        return num;
//    }
//
//    public void setNum(TwoThreadWaitNotify num) {
//        this.num = num;
//    }

    @Override
    public void run() {
        while (num.getStart() < 100){
            synchronized (TwoThreadWaitNotify.class){
                if(num.isFlag()){
                    System.out.println(Thread.currentThread().getName() + "+-+奇数" + num.getStart());
                    num.setStart(num.getStart()+1);
                    num.setFlag(false);
                    TwoThreadWaitNotify.class.notify();
                }else{
                    try {
                        TwoThreadWaitNotify.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}


/**
 * 偶数判断
 */
class evenNumber implements Runnable{


    private TwoThreadWaitNotify  num;

    public evenNumber(TwoThreadWaitNotify num) {
        this.num = num;
    }


    @Override
    public void run() {
        while (num.getStart() < 100){
            synchronized (TwoThreadWaitNotify.class){
                if(!num.isFlag()){
                    System.out.println(Thread.currentThread().getName() + "+-+偶数" + num.getStart());
                    num.setStart(num.getStart() + 1);
                    num.setFlag(true);
                    TwoThreadWaitNotify.class.notify();
                }else{
                    try {
                        TwoThreadWaitNotify.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}