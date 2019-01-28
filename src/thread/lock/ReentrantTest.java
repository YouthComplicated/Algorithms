package thread.lock;

public class ReentrantTest {

    private  MyLock myLock = new MyLock();

    public void a(){
        myLock.lock();
        System.out.println("a");
        b();
        myLock.unlock();
    }

    public void b(){
        myLock.lock();
        System.out.println("b");
        myLock.unlock();
    }

    public static void main(String[] args) {
        ReentrantTest test = new ReentrantTest();
        test.a();

    }

}
