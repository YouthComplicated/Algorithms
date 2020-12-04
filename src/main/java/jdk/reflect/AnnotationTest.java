package jdk.reflect;

/**
 *
 * 注解的本质是什么？？
 * 1、注解是一个接口继承自顶级接口Annotation,里面的属性就是接口中的一个抽象方法
 * 2、注解实现的原理JDK动态代理，注解实际会有代理类
 *
 * @author: nj
 * @date: 2020-08-19 15:11
 * @version: 0.0.1
 */
@MyAnnotation(name = "yyy", value = "xxx")
public class AnnotationTest {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        MyAnnotation annotation = AnnotationTest.class.getDeclaredAnnotation(MyAnnotation.class);
        annotation.name();
        System.out.println(annotation.value());
    }
}