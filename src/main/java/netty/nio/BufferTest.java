package netty.nio;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: nj
 * @date: 2020-11-15 20:30
 * @version: 0.0.1
 */
public class BufferTest {


    public static void main(String[] args) {

        IntBuffer intBuffer = IntBuffer.allocate(5);
        //放数据
        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i * 2);
        }

        //读写切换
        intBuffer.flip();

        while (intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }

    }


    /**
     *
     * 堆外存  与普通分配的区别
     *
     */
    @Test
    public void TestMapperBuffer() throws IOException {

        RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/sunzuo/Desktop/nio/111111.txt","rw");

        FileChannel channel = randomAccessFile.getChannel();

        //读写模式、开始位置，读写大小
        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        mappedByteBuffer.put(0,(byte) '5');
        mappedByteBuffer.put(4,(byte) 'P');
        randomAccessFile.close();

        System.out.println("修改成功！！！！");




    }







}