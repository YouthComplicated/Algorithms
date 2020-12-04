package netty.nio;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
 *
 * 文件拷贝
 *
 *
 * @author: nj
 * @date: 2020-11-15 21:19
 * @version: 0.0.1
 */
public class NioCopy {



    public static void main(String[] args) throws IOException {

        File file = new File("/Users/sunzuo/Desktop/111111.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();
        //规定缓冲区大小
        ByteBuffer buffer = ByteBuffer.allocate(512);

        File srcFile = new File("/Users/sunzuo/Desktop/22222.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(srcFile);
        //FileChannelImpl
        FileChannel srcChannel = fileOutputStream.getChannel();

        while (true){
            //必需属性重置  没有clear position=limit ==> read = 0
            buffer.clear();
            int read = channel.read(buffer);
            if(read == -1){
                break;
            }
            buffer.flip();
            srcChannel.write(buffer);

        }

    }

    @Test
    public  void TestCopy() throws IOException {

        //读数据
        FileInputStream src = new FileInputStream("/Users/sunzuo/Desktop/nio/111111.txt");
        //写流
        FileOutputStream dest = new FileOutputStream("/Users/sunzuo/Desktop/nio/2222.txt");


        FileChannel srcChannel = src.getChannel();
        FileChannel destChannel = dest.getChannel();

        //transfer 拷贝
        destChannel.transferFrom(srcChannel,0,srcChannel.size());

        //关闭
        src.close();
        dest.close();

    }



}