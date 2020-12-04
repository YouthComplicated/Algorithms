package headfirst.adaptertest;

/**
 *
 * 适配器类中加入要适配的类引用??有疑问此种是不是代理模式
 *
 * @author: nj
 * @date: 2020-11-08 10:32
 * @version: 0.0.1
 */
public class AdapterStudent2 implements NameTarget{

    private Student student = new Student();

    @Override
    public void doSomething() {
        student.getNumber();
        System.out.println("========doSomething========");

    }
}