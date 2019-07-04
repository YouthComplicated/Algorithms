package jdk.reflect;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestAnnotation {


    //class type
    @Test
    public void test01(){

        //类
        Class aClass = AnnotationClass.class;

        Annotation[] annotations = aClass.getAnnotations();
        for(Annotation annotation : annotations){
            if(annotation instanceof MyAnnotation){
                MyAnnotation myAnnotation = (MyAnnotation) annotation;
                System.out.println("name: " + myAnnotation.name());
                System.out.println("value: " + myAnnotation.value());
            }
        }

        Annotation annotation = aClass.getAnnotation(MyAnnotation.class);
        if(annotation instanceof MyAnnotation){
            MyAnnotation myAnnotation = (MyAnnotation) annotation;
            System.out.println("name: " + myAnnotation.name());
            System.out.println("value: " + myAnnotation.value());
        }
    }

    /**
     * 方法注解
     */
    @Test
    public void test02(){
        Method method = null;
        try {
            method = AnnotationClass.class.getDeclaredMethod("doSomething",String.class, int.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        Annotation[] annotations = method.getDeclaredAnnotations();

        for(Annotation annotation : annotations){
            if(annotation instanceof MyAnnotation){
                MyAnnotation myAnnotation = (MyAnnotation) annotation;
                System.out.println("name: " + myAnnotation.name());
                System.out.println("value: " + myAnnotation.value());
            }
        }


    }

    /**
     * 方法参数的注解
     *
     *  Annotation[][] annotations = method.getParameterAnnotations();
     */
    @Test
    public void test03(){
        Method method = null;
        try {
            method = AnnotationClass.class.getDeclaredMethod("doSomething",String.class, int.class);
            Class[] parameterTypes =  method.getParameterTypes();
            Annotation[][] annotations = method.getParameterAnnotations();
            int i = 0;
            for(Annotation[] annotationArr : annotations){
                Class paramType = parameterTypes[i++];
                for(Annotation annotation : annotationArr){
                    if(annotation instanceof MyAnnotation){
                        MyAnnotation myAnnotation = (MyAnnotation) annotation;
                        System.out.println("param: " + paramType.getName());
                        System.out.println("name: " + myAnnotation.name());
                        System.out.println("value: " + myAnnotation.value());
                    }
                }
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    /**
     * 变量的注解
     */
    @Test
    public void test04(){
        Field field = null;
        try {

            field = AnnotationClass.class.getField("addr");

            Annotation annotation = field.getAnnotation(MyAnnotation.class);

            if(annotation instanceof MyAnnotation){
                MyAnnotation myAnnotation = (MyAnnotation)annotation;
                System.out.println("name: " + myAnnotation.name());
                System.out.println("value: " + myAnnotation.value());

            }
            Annotation[] annotations = field.getDeclaredAnnotations();
            for(Annotation annotation1 : annotations){
                if(annotation1 instanceof Annotation){
                    MyAnnotation myAnnotation = (MyAnnotation)annotation;
                    System.out.println("name: " + myAnnotation.name());
                    System.out.println("value: " + myAnnotation.value());
                }
            }

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }

}
