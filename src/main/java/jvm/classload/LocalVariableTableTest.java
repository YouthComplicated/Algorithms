package jvm.classload;


/**
 * 局部变量表
 * 变量槽solt
 *
 * boolean,byte,char,short,int,float,reference或returnAddress
 *
 * long和double分割存储
 *
 *
 *
 */
public class LocalVariableTableTest {

    public static void main(String[] args) {

        {
            byte[] placeholder = new byte[64 * 1024 * 1204];
        }
        int a = 0;
        System.gc();


    }

}
