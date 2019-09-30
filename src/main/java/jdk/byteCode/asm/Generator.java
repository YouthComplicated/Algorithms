package jdk.byteCode.asm;


import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;

public class Generator {

    public static void main(String[] args) throws Exception {


//        InputStream inputStream =  ClassLoader.
//                getSystemResourceAsStream("Login.class");
//
//        InputStream inputStream1 =  ClassLoader.
//                getSystemResourceAsStream("aa.txt");
//
//        if(inputStream == null){
//            System.out.println("aaaa");
//        }
//
//        if(inputStream1 == null){
//            System.out.println("bbb");
//        }


        //读取
        ClassReader classReader = new ClassReader("Login");
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        //处理
        ClassVisitor classVisitor = new MyClassVisitor(classWriter);
        classReader.accept(classVisitor, ClassReader.SKIP_DEBUG);
        byte[] data = classWriter.toByteArray();
        //输出
        File f = new File("/Users/sunzuo/Work/IdeaProjects/Algorithms/target/classes/jdk/asm/Login.class");
        FileOutputStream fout = new FileOutputStream(f);
        fout.write(data);
        fout.close();
        System.out.println("now generator cc success!!!!!");


    }
}


