package kafka;

/**
 * @author: nj
 * @date: 2020-11-12 22:16
 * @version: 0.0.1
 */
public class aa {

    public static void main(String[] args) {

        System.out.println(-1 & 0x7fffffff);

        System.out.println(1 & Integer.MAX_VALUE);

        System.out.println(-1 & Integer.MAX_VALUE);
        System.out.println(-Integer.MAX_VALUE & Integer.MAX_VALUE);
    }
}