package headfirst.adaptertest;

/**
 * @author: nj
 * @date: 2020-11-08 10:29
 * @version: 0.0.1
 */
public class AdapterStudent1 extends Student implements NameTarget{

    @Override
    public void doSomething() {
        //调用父类的一下属性和方法
        super.getNumber();
        //加入逻辑
        System.out.println("======doSomething=====");
    }

    public static void main(String[] args) {

        AdapterStudent1 a = new AdapterStudent1();
        a.doSomething();

    }
}