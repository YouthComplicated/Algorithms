import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

/**
 * @author NJ
 * @date 2019/1/4 15:50
 */
public class test {

    public static void main(String[] args) {
//        for(int i = 0; i< 3; i++){
//            if( i == 1){
//                if(true){
//                    continue;
//                }
//            }
//            System.out.println(i);
//        }


        String.valueOf(1);

    }

    @Test
    public void test01(){
        String str = "clientIp_1";
        int index = str.lastIndexOf("_");
        System.out.println(str.substring(index+1));
    }

    @Test
    public void test02(){
        Map<String, Object> map = new HashMap<>();
        map.put("aa",111);
        System.out.println(map);
    }

    @Test
    public void test03(){
        String OS, ARCH;
        Properties props = System.getProperties();
        OS = String.valueOf(props.get("os.name")).toLowerCase();
        ARCH = String.valueOf(props.get("sun.arch.data.model"));

        System.out.println("OS:"+OS);
        System.out.println("ARCH:"+ARCH);

    }

    @Test
    public void test04(){
        StringBuilder sb = new StringBuilder("");
        for(int i = 1; i < 10; i++){
            sb.append("N00").append(i).append(";");
        }
        System.out.println(sb.toString());
        for(int i = 10; i < 20; i++){
            sb.append("N0").append(i).append(";");
        }
        System.out.println(sb.toString());
        for(int i = 30; i < 40; i++){
            sb.append("N0").append(i).append(";");
        }
        System.out.println(sb.toString());
        for(int i = 40; i < 50; i++){
            sb.append("N0").append(i).append(";");
        }
        System.out.println(sb.toString());
//        for(int i = 10; i < 20; i++){
//            sb.append("N000").append(i).append(";");
//        }
    }

    @Test
    public void test05(){
        String str2 = 3.5f + "";
        System.out.println(str2);
        System.out .println(3+4+"Hello!");
        System.out.println("Hello!"+3+4);
        System.out.println('a'+1+"Hello!");
        System.out.println("Hello"+'a'+1);
    }


    @Test
    public void test06(){
        short s = 5;
        //编译报错
//        s = s-2;
        int s1 = s - 2;
        System.out.println(s1);

        byte b = 3;
//        b = b + 4;  //编译报错
        b = (byte)(b+4);

        char c = 'a';
//        c = c + 1;

        int  i = 5;
        float d = .314F;
        double result = c+i+d;

        byte b1 = 5;
        short s2 = 3;
        short t1 = (byte)(s2 + b1);

        String a = "43";
        int i1 = Integer.parseInt(a);

    }

    @Test
    public void test07(){
        int i1 = 10;int i2 = 20;
        int i = i1++;
        System.out.print("i="+i);
        System.out.println("i1="+i1);
        i = ++i1;
        System.out.print("i="+i);
        System.out.println("i1="+i1);
        i = i2--;
        System.out.print("i="+i);
        System.out.println("i2="+i2);
        i = --i2;
        System.out.print("i="+i);
        System.out.println("i2="+i2);

    }

    @Test
    public void test08(){
        int i = 1;
        i *= 0.1;
        System.out.println(i);
        i++;
        System.out.println(i);

    }

    @Test
    public void test09(){
        int x = 1;
        int y = 1;
        if(x++  == 2 & ++y == 2){
            x =7;
        }
        System.out.println("x="+x+",y="+y);
    }

    @Test
    public void test10(){

        int x = 1,y = 1;
        if(x++ == 2 && ++y == 2){
            x =7;
        }
        System.out.println("x="+x+",y="+y);

    }

    @Test
    public void test11(){
        int x = 1,y = 1;

        if(x++==1 | ++y==1){
            x =7;
        }
        System.out.println("x="+x+",y="+y);

    }


    @Test
    public void test12(){
        int x = 1,y = 1;

        if(x++==1 || ++y==1){
            x =7;
        }
        System.out.println("x="+x+",y="+y);

    }

    @Test
    public void test13(){
        boolean x=true;
        boolean y=false;
        short z=42;
        //if(y = true)
        if((z++==42)&&(y==true))z++;
        if((x=false) || (++z==45))  z++;
        System. out.println("z="+z);


        int i = 1>>>2;
//        int a = 2 <<<3;
    }

    @Test
    public void test14(){
        boolean b = true;
        //如果写成if(b=false)能编译通过吗？如果能，结果是？
        if(b == false){
            System.out.println("a");
        }

        if(b = false){
            System.out.println("b");
        }
        //局部变量使用先赋值初始化
        boolean a = false;
//        System.out.println("a默认值："+ a);
        if( a = true){
            System.out.println("b");
        }

    }

    @Test
    public void test15(){

        int[] x; int[] y;

//        x[0] = y;

//         y[0] = x;

//        y[0][0] = x;

//        x[0][0] = y;

//        y[0][0] = x[0];

//        x = y;


    }


    @Test
    public void test16(){
        int a = 15;
        float b = 15.0f;
        System.out.println(a == b);


    }


    @Test
    public void test17(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);

        System.out.println(sb.length());//4

        System.out.println(sb);//null

        StringBuffer sb1 = new StringBuffer(str); //java.lang.NullPointerException
        System.out.println(sb1);//

    }


    @Test
    public void test18(){

        String a = "123";
        String b = "123";
        String c = new String("123");
        String d = new String("123");
        System.out.println(a.equals(b)); //true
        System.out.println(a ==b); //true
        System.out.println(c.equals(d)); //true
        System.out.println(c == d); //false
        System.out.println(a.equals(c));//true
        System.out.println(a == c);//false


        System.out.println("学java".length());
        System.out.println("学java".getBytes().length);

        System.out.println(Math.round(11.5)); //12
        System.out.println(Math.round(-11.5));//-11
    }


    @Test
    public void test20(){
        BigInteger bi = new BigInteger("12433241123");
        BigDecimal bd = new BigDecimal("12435.351");
        BigDecimal bd2 = new BigDecimal("11");
        System.out.println(bi);
        //System.out.println(bd.divide(bd2));
        System.out.println(bd.divide(bd2,BigDecimal.ROUND_HALF_UP));
        System.out.println(bd.divide(bd2,15,BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void test21(){
        Collection<?> c = new ArrayList<String>();
//        c.add(new Object());

        String a = "aaa";
        Object obj = new Object();
//        c.add(a);
//        c.add(obj);

        c.add(null);

    }


    @Test
    public void test22(){
        List<?> list = null;
        list = new ArrayList<String>();
        list = new ArrayList<Double>();
        //list.add(3);
        list.add(null);
        List<String> l1 = new ArrayList<String>();
        List<Integer> l2 = new ArrayList<Integer>();
        l1.add("尚硅谷");
        l2.add(15);
        read(l1);
        read(l2);
    }
    static void read(List<?> list){
        for(Object o : list){
            System.out.println(o);
        }
    }


    @Test
    public void test23(){

        Path path = Paths.get("index.html");
        System.out.println(path);

    }


    /**
     * 使用直接缓冲区完成文件的复制(内存映射文件)
     */
    @Test
    public void test24() throws Exception{
        long start = System.currentTimeMillis();
        FileChannel inChannel = FileChannel.open(Paths.get("f://1.mp4"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("f://2.mp4"), StandardOpenOption.WRITE,
                StandardOpenOption.READ, StandardOpenOption.CREATE);
        // 内存映射文件
        MappedByteBuffer inMappedByteBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedByteBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());
        // 直接对缓冲区进行数据的读写操作
        byte[] dsf = new byte[inMappedByteBuf.limit()];
        inMappedByteBuf.get(dsf);
        outMappedByteBuffer.put(dsf);
        inChannel.close();
        outChannel.close();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
    /**
     * 1.利用通道完成文件的复制(非直接缓冲区)
     * @throws Exception
     */
    @Test
    public void test25() throws Exception{
        long start = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("f://1.mp4");
        FileOutputStream fos = new FileOutputStream("f://2.mp4");
        // ①获取通道
        FileChannel inChannel = fis.getChannel();
        FileChannel outChannel = fos.getChannel();
        // ②分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        while (inChannel.read(buf) != -1) {
            buf.flip();// 切换为读取数据
            // ③将缓冲区中的数据写入通道中
            outChannel.write(buf);
            buf.clear();
        }
        outChannel.close();
        inChannel.close();
        fos.close();
        fis.close();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    @Test
    public void test26() throws ClassNotFoundException {
        //1.获取一个系统类加载器
        ClassLoader classloader = ClassLoader.getSystemClassLoader();
        System.out.println(classloader);
        //2.获取系统类加载器的父类加载器，即扩展类加载器
        classloader = classloader.getParent();
        System.out.println(classloader);
        //3.获取扩展类加载器的父类加载器，即引导类加载器
        classloader = classloader.getParent();
//        System.out.println(classloader);
        //4.测试当前类由哪个类加载器进行加载
        classloader = Class.forName("exer2.ClassloaderDemo").getClassLoader();
        System.out.println(classloader);
        //5.测试JDK提供的Object类由哪个类加载器加载
        classloader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classloader);
        //*6.关于类加载器的一个主要方法：getResourceAsStream(String str):获取类路径下的指定文件的输入流
        InputStream in = null;
        in = this.getClass().getClassLoader().getResourceAsStream("exer2\\test.properties");
        System.out.println(in);

    }

    @Test
    public void test27() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
        System.out.println(inetAddress.getAddress());
        System.out.println(inetAddress.getHostName());
        System.out.println(inetAddress.getHostAddress() );


    }

    @Test
    public void test28() throws UnknownHostException {

    }



}




