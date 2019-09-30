package jdk.byteCode.javassist;

import java.lang.management.ManagementFactory;

public class Login {


    public static void main(String[] args) {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String s = name.split("@")[0];
        //打印当前Pid
        System.out.println("pid:"+s);
        while (true) {
            try {
                Thread.sleep(5000L);
            } catch (Exception e) {
                break;
            }
            login();
        }
    }


    public static void login(){
        System.out.println("######登录成功######");
    }


}
