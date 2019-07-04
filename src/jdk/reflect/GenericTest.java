package jdk.reflect;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class GenericTest {


    /**
     * 泛型方法 返回类型
     */
    @Test
    public void test01(){
        Method method = null;
        Type returnType = null;
        try {
            method = GenericsClass.class.getMethod("getStringList", null);
            returnType = method.getGenericReturnType();
            if(returnType instanceof ParameterizedType){
                ParameterizedType type = (ParameterizedType) returnType;
                Type[] typeArguments = type.getActualTypeArguments();
                for(Type typeArgument : typeArguments){
                    Class typeArgClass = (Class) typeArgument;
                    System.out.println("typeArgClass = " + typeArgClass);
                }
            }

            method = GenericsClass.class.getDeclaredMethod("getTeachers", Teacher.class);
            returnType = method.getGenericReturnType();
            if(returnType instanceof ParameterizedType){
                ParameterizedType type = (ParameterizedType) returnType;
                Type[] typeArguments = type.getActualTypeArguments();
                for(Type typeArgument : typeArguments){
                    Class typeArgClass = (Class) typeArgument;
                    System.out.println("typeArgClass = " + typeArgClass);
                }
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    /**
     * 泛型方法 参数类型
     * @throws NoSuchMethodException
     */
    @Test
    public void test02() throws NoSuchMethodException {

        Method method = GenericsClass.class.getDeclaredMethod("getIds", List.class);
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for(Type genericParameterType : genericParameterTypes){
            if(genericParameterType instanceof ParameterizedType){
                ParameterizedType aType = (ParameterizedType) genericParameterType;
                Type[] parameterArgTypes = aType.getActualTypeArguments();
                for(Type parameterArgType : parameterArgTypes){
                    Class parameterArgClass = (Class) parameterArgType;
                    System.out.println("parameterArgClass = " + parameterArgClass);
                }
            }
        }
    }

    /**
     * 泛型变量的类型
     */
    @Test
    public void test03() throws NoSuchFieldException {

        Field field = GenericsClass.class.getDeclaredField("stringList");

        Type genericFieldType = field.getGenericType();

        if(genericFieldType instanceof ParameterizedType){
            ParameterizedType aType = (ParameterizedType) genericFieldType;
            Type[] fieldArgTypes = aType.getActualTypeArguments();
            for(Type fieldArgType : fieldArgTypes){
                Class fieldArgClass = (Class) fieldArgType;
                System.out.println("fieldArgClass = " + fieldArgClass);
            }
        }

    }

}
