/**
 * @author: nj
 * @date: 2020-03-09 15:52
 * @version: 0.0.1
 */
public class TestC1 {

    public String testFinally(){
        try{
            String t = "";
            try {
                t = "try";
                return t;
            } catch (Exception e) {
                // result = "catch";
                t = "catch";
                return t;
            } finally {
                t = "finally";
                System.out.println("inner:fianlly");
            }
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }finally {
            System.out.println("outer:fianlly");
        }
    }

    public static void main(String[] args) {
        TestC1 testC1 = new TestC1();
        System.out.println(testC1.testFinally());
    }
}