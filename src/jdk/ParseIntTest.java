package jdk;

/**
 * @author NJ
 * @date 2019/1/24 11:15
 */
public class ParseIntTest {

    public static void main(String[] args) {
        String str = "";
//        int a = Integer.parseInt(str);
//        Integer a = (Integer)str;
        Integer a = Integer.valueOf(str);
        System.out.println(a);
    }
}
