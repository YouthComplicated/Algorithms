package base.InterfaceTest;

/**
 * @author: nj
 * @date: 2020-03-19 17:26
 * @version: 0.0.1
 */
public interface TestA {

    int a = 1;

    void say();

    void get();

    default void eat(){
        System.out.println(11111);
    }
}