package jdk.byteCode.javassist;

import java.lang.instrument.Instrumentation;

public class TestAgent {

    public static void main(String[] args) {

    }

    public static void agentmain(String args, Instrumentation inst) {
        //指定我们自己定义的Transformer，在其中利用Javassist做字节码替换
        inst.addTransformer(new TestClassFileTransformer(), true);
        try {
            //重定义类并载入新的字节码
            inst.retransformClasses(Login.class);
            System.out.println("Agent Load Done.");
        } catch (Exception e) {
            System.out.println("agent load failed!");
        }
    }
}
