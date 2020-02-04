package thread.base;

import org.junit.Test;

public class FinalTest {

    final int x;

    /**
     * 非final字段不能保证其他线程可见
     */
    int y;

    static FinalTest f;

    public FinalTest() {
        x = 3;
        y = 4;

        // bad construction - allowing this to escape
        //f = this;
    }

    static void writer() {
        f = new FinalTest();
    }

    static void reader() {
        //判断是否初始化
        if (f != null) {
            int i = f.x;
            int j = f.y;
        }
    }



    /**
     *
     */
    @Test
    public void test01(){

    }
}
