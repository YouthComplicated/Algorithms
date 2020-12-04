import java.util.concurrent.TimeUnit;

/**
 * @author: nj
 * @date: 2020-03-02 17:13
 * @version: 0.0.1
 */
public class TestC {

    String str = new String("good");
    char[] ch = { 't', 'e', 's', 't' };

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'g';
    }

    public static void main(String[] args) {
        TestC ex = new TestC();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");
        System.out.println(ex.ch);



        int [] arr = {1,2,3};

        new Thread(()->{
            System.out.println("进入线程A。。。");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            arr[0] = 888888;

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    ).start();


        new Thread(()->{
            System.out.println("进入线程B。。。");
            System.out.println("B发现参数为："+ arr[0]);
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            System.out.println("B发现参数为："+ arr[0]);

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ).start();





//        ()->{
//            System.out.println("进入线程中");
//            arr[1] = 999;
//


    }

}