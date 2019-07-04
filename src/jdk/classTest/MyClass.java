package jdk.classTest;

import base.Arrays.Array;
import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public class MyClass {


    static void printLine(String ... args){
        if(args.length > 0){
            System.out.println("===============" + args[0]);
        }else{
            System.out.println("===============");
        }

    }


    /**
     *  test getInterfaces
     */
    @Test
    public void test01(){
        Student student = new Student("詹胜男",2,'1');


        System.out.println(student.getClass().toGenericString());
        printLine();
        Class clazz = student.getClass();

        String clazzStr = clazz.toString();
        System.out.println(clazzStr);

        /**
         * 1、order
         * 2、if class is interface return interface array
         */
        Class [] interfaces = clazz.getInterfaces();
        for(Class inface : interfaces){
            System.out.println(inface.toString());
        }
        printLine();

        Class [] interfaces1 = Study.class.getInterfaces();
        for(Class inface : interfaces1){
            System.out.println(inface.toString());
        }
        /**
         * <p> If this object represents a class or interface that implements no
         * interfaces, the method returns an array of length 0.
         *
         * <p> If this object represents a primitive type or void, the method
         * returns an array of length 0.
         */
        printLine();
        Class [] intInface = int.class.getInterfaces();
        for(Class inface : intInface){
            System.out.println(inface.toString());
        }
    }


    @Test
    public void test02(){

        /**
         * test isAnnotation()
         */
        Student student = new Student("詹胜男",2,'1');
        Class clazz = student.getClass();

        System.out.println(clazz.isAnnotation());

        System.out.println(MyAnnotation.class.isAnnotation());

        /**
         * getSuperclass
         */
        printLine("getSuperclass");
        System.out.println(clazz.getSuperclass());
        printLine("getGenericSuperclass");
        System.out.println(clazz.getGenericSuperclass());

        Teacher teacher = new Teacher("zhansan",2,'2');
        Class teaClass = teacher.getClass();
        printLine("Teacher==>getSuperclass");
        System.out.println(teaClass.getSuperclass());
        printLine("Teacher==>getGenericSuperclass");
        Type t = teaClass.getGenericSuperclass();
        System.out.println(t);

        System.out.println(((ParameterizedType) t).getActualTypeArguments()[0]);

    }


    @Test
    public void test03(){
        Student student = new Student("詹胜男",2,'1');
        Class clazz = student.getClass();
        printLine("getPackage");
        System.out.println(clazz.getPackage());
        printLine("getGenericInterfaces");
        Type [] classes = clazz.getGenericInterfaces();
        System.out.println(Arrays.toString(classes));

        String [] aa = {"aa","vv"};

        System.out.println(aa.getClass().getComponentType());
        System.out.println(String [].class.getComponentType());

        printLine("getModifiers");
        System.out.println(clazz.getModifiers());

        printLine("getSigners");
        Object[] singers = clazz.getSigners();
        System.out.println(Arrays.toString(singers));
        System.out.println(Student.class.getSigners());


    }


    /**
     * 一、getEnclosingXX
     *
     * getEnclosingClass():该类是在那个类中定义的， 比如直接定义的内部类或匿名内部类
     *
     * getEnclosingConstructor()：该类是在哪个构造函数中定义的，比如构造方法中定义的匿名内部类
     *
     * getEnclosingMethod()：该类是在哪个方法中定义的，比如方法中定义的匿名内部类
     *
     *
     */
    @Test
    public void test04(){

        printLine("enclosing");
        Student student = new Student();
        Class<?> clazz = Student.Favorite.class;

        Student.favorite.like();


        Class<?> declareClass = Student.Favorite.class.getEnclosingClass();
        System.out.println(declareClass);


        //内部类  匿名类
        printLine("isAnonymousClass");
        System.out.println(clazz.isAnonymousClass());
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println(111);
            }
        };
        System.out.println(thread.getClass().isAnonymousClass());


    }

    @Test
    public void test05(){

        Student student = new Student("詹胜男",2,'1');
        Class<?>[] clazzs = student.getClass().getClasses();
        System.out.println(Arrays.toString(clazzs));





    }


}
