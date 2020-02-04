package jvm.classload;

import java.io.IOException;
import java.io.InputStream;

/**
 * 不同类的加载器对instanceOf关键字的运算的影响
 */
public class ClassLoadTest {

    public static void main(String[] args) {

        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
                InputStream is = getClass().getResourceAsStream(fileName);
                if(is == null){
                    return super.loadClass(name);
                }
                try {
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return super.loadClass(name);
            }
        };

        try {
            Object obj = myLoader.loadClass("jvm.classload.ClassLoadTest").newInstance();
            System.out.println(obj.getClass());
            System.out.println(obj instanceof jvm.classload.ClassLoadTest);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
