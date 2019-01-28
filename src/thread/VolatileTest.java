package thread;

public class VolatileTest {

    //private  volatile  int a = 1;

    private  int a = 1;

    public  int b = 2;

    public void setA(int a){
        this.a = a;
    }
    public int getA(){
        return this.a;
    }

    public static void main(String[] args) {

        VolatileTest test = new VolatileTest();
        test.b = 88;

        new Thread(()-> test.b=0).start();
        new Thread(()-> System.out.println(test.b)).start();
        System.out.println("result b:"+test.b);
    }









}
