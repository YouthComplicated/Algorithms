package jdk.reflect;

import org.junit.Test;

import java.lang.reflect.*;
import java.util.Arrays;

public class MyReflect {


    private void printLine(String ... args){
        if(args.length > 0){
            System.out.println("=============" + args[0]);
        }else{
            System.out.println("=============");
        }
    }

    private static Class clazzA = Teacher.class;

    /**
     * 获取类实例的三种方式
     */
    @Test
    public void test01(){
        Class clazz1 = null;
        try {
            clazz1 = Class.forName("jdk.reflect.Teacher");
            System.out.println(clazz1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Teacher teacher = new Teacher();
        Class clazz2 = teacher.getClass();
        System.out.println(clazz2);

        Class clazz3 = Teacher.class;
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz2 == clazz3);


    }

    /**
     * 获取方法
     */
    @Test
    public void test02(){

        Teacher teacher = new Teacher();
        Class clazz = teacher.getClass();

        Method[] methods = teacher.getClass().getMethods();
        for(Method method : methods){
            System.out.println("method = " + method.getName());
        }
        printLine("getMethods");
        Method[] methods1 = Teacher.class.getMethods();
        for(Method method : methods1){
            System.out.println("method = " + method.getName());
        }




    }

    /**
     * 获取构造方法  Constructor
     */
    @Test
    public void test03(){
        Teacher teacher = new Teacher();
        Class clazz = teacher.getClass();
        printLine("getConstructors");
        Constructor[] constructors = clazz.getConstructors();
        for(Constructor constructor : constructors){
            System.out.println("Constructor = " + constructor);
            Class[] parameterTypes = constructor.getParameterTypes();
            for(Class type : parameterTypes){
                System.out.println(type);
            }
            System.out.println();
        }

        try {
            Constructor constructor = clazz.getConstructor(String.class);
            Teacher teacher1 = (Teacher)constructor.newInstance("aaaa");
            System.out.println(teacher1.getUserName());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }catch (InstantiationException e) {
        e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }


    /**
     * Field相关
     */
    @Test
    public void test04(){


        Class clazz = Teacher.class;
        /**
         * 获取变量
         */
        Field[] fields = clazz.getFields();
        for(Field field : fields){
            System.out.println(field.toString());
        }

        Field field1 = null;
        try {
//            Field field = clazz.getField("aa");
//            System.out.println(field);
            field1 = clazz.getField("workExperience");
            System.out.println(field1);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        /**
         * 获取变量的类型
         */
        Class cls = field1.getType();
        System.out.println(cls);

        /**
         * 获取set/get变量值
         *
         */

        Teacher teacher = new Teacher();
        System.out.println(teacher);
        try {
            field1.set(teacher, 123);
            System.out.println(teacher);
            System.out.println(field1.get(teacher));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }

    /**
     * Method
     */
    @Test
    public void test05(){
        Method[]  methods = clazzA.getMethods();
        System.out.println(Arrays.toString(methods));

        Method method = null;
        try {
//            method = clazzA.getMethod("doSomething", new Class[] {int.class});
            method = clazzA.getDeclaredMethod("doSomething", new Class[] {int.class});
            System.out.println(method);
            printLine("getParameterTypes");

            Class<?>[] types = method.getParameterTypes();
            System.out.println(Arrays.toString(types));
            printLine("getReturnType");
            Class clazz = method.getReturnType();
            System.out.println(clazz);

            //invoke  静态方法调用可以用null代替指定对象作为invoke()的参数
            Teacher teacher = new Teacher();
            method.setAccessible(true);
            Object returnValue = method.invoke(teacher, 9822);
            System.out.println("返回值" + returnValue);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }catch (IllegalAccessException e) {
            e.printStackTrace();
        }catch (InvocationTargetException e){
            e.printStackTrace();
        }

    }

    /**
     * getter and setter
     */
    @Test
    public void test06(){
        Method[] methods = clazzA.getMethods();
        for(Method method : methods){
            if(isGetter(method)) {
                System.out.println("getter: " + method);
            }
            if(isSetter(method)) {
                System.out.println("setter: " + method);
            }
        }

    }

    public static boolean isGetter(Method method){
        if(!method.getName().startsWith("get")){
            return false;
        }
        if(method.getParameterTypes().length != 0) {
            return false;
        }
        if(void.class.equals(method.getReturnType())){
            return false;
        }
        return true;
    }

    public static boolean isSetter(Method method){
        if(!method.getName().startsWith("set")) {
            return false;
        }
        if(method.getParameterTypes().length != 1){
            return false;
        }
        return true;
    }


    /**
     * 私有变量和私有方法
     *
     * 从对象的外部访问私有变量以及方法是不允许的，但是Java反射机制可以做到这一点。
     *
     * 使用DeclaredFields 获取所有的声明的方法 包括private
     */
    @Test
    public void test07(){
        Teacher teacher = new Teacher();

        printLine("getFields");
        Field[] fields1 = Teacher.class.getFields();
        for(Field field : fields1){
            System.out.println(field);
        }
        printLine("getDeclaredFields");
        Field[] fields = Teacher.class.getDeclaredFields();
        for(Field field : fields){
            System.out.println(field);
        }

        try {
            teacher.privateField("aaa", 1);
            Field field = Teacher.class.getDeclaredField("nameStr");
            //是否访问
            field.setAccessible(true);
            Object returnValue = field.get(teacher);
            System.out.println("returnValue===="+ returnValue);


            Method method = Teacher.class.getDeclaredMethod("privateMethod", String.class,Integer.class);
            method.setAccessible(true);
            Object returnMethodValue  = method.invoke(teacher, "wefefw",1111);
            System.out.println("returnMethodValue===="+returnMethodValue);


        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void test08(){
        Integer i = null;
        if(i > 7){
            System.out.println(111);
        }
    }


}
