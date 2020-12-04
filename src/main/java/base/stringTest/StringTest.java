package base.stringTest;

/**
 * @author: nj
 * @date: 2020-10-01 19:46
 * @version: 0.0.1
 */
public class StringTest {


    /**
     *
     * 1、字符串 +
     * 2、concat()  ==> 数组扩容(system.copy)->复制
     * 3、容器类  数组扩容
     *
     */
    public static void main(String[] args) {

        String str1 = new String("AA");
        str1 = str1.concat("BB");



        System.out.println("str1:"+str1);
        StringBuffer sb1 = new StringBuffer("AA");
        sb1.append("BB");
        System.out.println(sb1.toString());



        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb.toString());

    }


}