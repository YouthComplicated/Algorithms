package jdk.classTest;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

@MyAnnotation
public class Student extends  Eat implements Serializable, Learn, Course {


    private String userName;
    private Integer age;
    private Character sex;

    public Student(String userName, Integer age, Character sex) {
        this.userName = userName;
        this.age = age;
        this.sex = sex;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    //构造方法内部类
    public Student(){
        Favorite innerCls = new Favorite(){
            @Override
            public void like() {
                getEnclosing(this.getClass());
            }
        };
        innerCls.like();
    }


    static Favorite favorite = new Favorite(){
        @Override
        public void like() {
            getEnclosing(this.getClass());
        }
    };

    //静态内部类
    static class Favorite{
        private String misc;
        private String kind;

        public void like(){

        }

        public String getMisc() {
            return misc;
        }

        public void setMisc(String misc) {
            this.misc = misc;
        }

        public String getKind() {
            return kind;
        }

        public void setKind(String kind) {
            this.kind = kind;
        }
    }



    @Override
    public int max() {
        return 0;
    }

    @Override
    public String project(String[] strings) {
        return null;
    }

    @Override
    public String toString() {
        return "Student{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    /**
     * getEnclosingClass:该类是在那个类中定义的， 比如直接定义的内部类或匿名内部类
     * getEnclosingConstructor：该类是在哪个构造函数中定义的，比如构造方法中定义的匿名内部类
     * getEnclosingMethod：该类是在哪个方法中定义的，比如方法中定义的匿名内部类
     *
     * @param cls
     */
    private static void getEnclosing(Class cls) {
        Class enclosingClass = cls.getEnclosingClass();
        Constructor enclosingConstructor = cls.getEnclosingConstructor();
        Method enclosingMethod = cls.getEnclosingMethod();
        System.out.println("enclosingClass=" + enclosingClass);
        System.out.println("enclosingConstructor=" + enclosingConstructor);
        System.out.println("enclosingMethod=" + enclosingMethod);
    }

}
