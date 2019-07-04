package jdk.reflect;


@MyAnnotation(name="aaa", value = "bbbb")
public class AnnotationClass {



    @MyAnnotation(name="bbb", value = "bbbb")
    private String addr;

    @MyAnnotation(name="111", value = "222")
    public void doSomething(@MyAnnotation(name="rrrr", value="ppp") String Str, @MyAnnotation(name="rrrr", value="bbbb") int i){

    }
}
