package jdk.reflect.myproxy;

/**
 * @author: nj
 * @date: 2020-08-19 17:44
 * @version: 0.0.1
 */
public class ChinesePerson implements Person {
    @Override
    public void eat() {
        System.out.println("----eat rice----");
    }
}