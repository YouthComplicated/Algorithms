package jdk.byteCode.javassist;

import javassist.*;

import java.io.IOException;

public class javassistTest {


    public static void main(String[] args) throws CannotCompileException, NotFoundException, IOException, IllegalAccessException, InstantiationException {

        /**
         * JVM是不允许在运行时动态重载一个类的
         */
        //Login login = new Login();

        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("jdk.byteCode.javassist.Login");
        CtMethod m = cc.getDeclaredMethod("login");
        m.insertBefore("{ System.out.println(\"start\"); }");
        m.insertAfter("{ System.out.println(\"end\"); }");
        Class c = cc.toClass();
        cc.writeFile("/Users/sunzuo/Work/IdeaProjects/Algorithms/src/main/resources");
        Login h = (Login)c.newInstance();
        h.login();

    }
}
