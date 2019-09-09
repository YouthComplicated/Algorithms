package jvm;

public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;
    public void isAlive(){
        System.out.println("yes, i am still alive :)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();

        System.out.println("finalize method executed !");
        FinalizeEscapeGC.SAVE_HOOK = this;

    }


    public static void main(String[] args) throws InterruptedException {


        SAVE_HOOK = new FinalizeEscapeGC();

        SAVE_HOOK = null;
        System.gc();

        Thread.sleep(500);

        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println(" not i am dead:");
        }

        SAVE_HOOK = null;
        System.gc();

        Thread.sleep(500);

        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println(" not i am dead:");
        }


//        Student student = new Student();
//        student = null;
//        System.gc();
//        thread.sleep(500);
//
//        if(student != null){
//            student.isAlive();
//        }else{
//            System.out.println(" not i am dead:");
//        }


    }

}
class Student{
    private String username;
    private String sex;

    public Student(){
        this.username = "张三";
        this.sex = "男";
    }

    public void isAlive(){
        System.out.println("yes, i am still alive :)");
    }

}

