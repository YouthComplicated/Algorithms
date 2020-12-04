package netty.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
 * 文件读取
 *
 *
 * @author: nj
 * @date: 2020-11-15 21:13
 * @version: 0.0.1
 */
public class NioFileChannelRead {


    public static void main(String[] args) throws FileNotFoundException {


        File file = new File("/Users/sunzuo/Desktop/111111.txt");

        FileInputStream fileInputStream = new FileInputStream(file);

        FileChannel channel = fileInputStream.getChannel();


        ByteBuffer buffer = ByteBuffer.allocate((int)file.length());
        try {
            channel.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String s = new String(buffer.array());

        System.out.println("读取文件内容为:"+s);
        try {
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }
}