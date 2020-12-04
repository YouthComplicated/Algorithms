package netty.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *
 * 文件写入
 *
 * @author: nj
 * @date: 2020-11-15 21:04
 * @version: 0.0.1
 */
public class NioFileChannel {

    public static void main(String[] args) throws FileNotFoundException {

        String str = "哈VN万恶百万富翁";
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/sunzuo/Desktop/111111.txt");

        //FileChannelImpl
        FileChannel channel = fileOutputStream.getChannel();

        //创建ByteBuffer,分配内存
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //将内容放入ByteBuffer中
        byteBuffer.put(str.getBytes());
        //反转
        byteBuffer.flip();

        try {
            //将buffer写入channle
            channel.write(byteBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}