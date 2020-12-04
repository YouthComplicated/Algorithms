package base.exception;

/**
 * @author: nj
 * @date: 2020-10-01 20:36
 * @version: 0.0.1
 */
public class exceptionTest {


    public static void a(){
        System.out.println(111);
    }


    public static void b(){
        System.out.println(222);
    }


    public static void c(){
        try {
            throw  new Exception("异常！！！！！！！");
        } catch (Exception e) {
            e.printStackTrace();
            for(StackTraceElement st : e.getStackTrace()){
                System.out.println("method:"+st.getMethodName());
                System.out.println("fileName:"+st.getFileName());
                System.out.println("lineNumber"+st.getLineNumber());
            }
        }
//        System.out.println(33);
    }


    public static void main(String[] args) {

        c();
        System.out.println("===============");
        a();
        System.out.println("===============");
        b();

    }


}