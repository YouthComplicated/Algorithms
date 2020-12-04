/**
 * @author: nj
 * @date: 2020-10-12 15:48
 * @version: 0.0.1
 */
public class Test11 {


    static int get(){
        int x = 1;
        try {
            return x;
        } finally {

            System.out.println(1111);

//            ++x;
            x = x + 1;
            System.out.println(x);

            return x;

        }
    }

    public static void main(String[] args) {

        System.out.println(get());

    }
}