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
    }

}