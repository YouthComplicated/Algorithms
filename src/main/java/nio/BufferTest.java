package nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class BufferTest {


    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(
                new File("/Users/sunzuo/Work/IdeaProjects/Algorithms/buffertest.txt"));
        FileChannel fc = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        fc.read(byteBuffer);

        //java.nio.HeapByteBuffer[pos=39 lim=1024 cap=1024]
        System.out.println("byteBuffer:"+byteBuffer.toString());

        fc.close();

        //重置位置
        byteBuffer.flip();

    }


    /**
     * 复制文件
     * @param from
     * @param to
     * @throws IOException
     */
    public static void  nioCopyFile(String from, String to) throws IOException {
        FileInputStream fis = new FileInputStream(from);
        FileOutputStream fos = new FileOutputStream(to);
        FileChannel readChannel = fis.getChannel();
        FileChannel writeChannel = fos.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (true) {
            byteBuffer.clear();
            int len = readChannel.read(byteBuffer);
            if(len == -1){
                break;
            }
            byteBuffer.flip();
            writeChannel.write(byteBuffer);

        }

        fis.close();
        fos.close();

    }

    /**
     * 文件映射内存
     */
    public static void MapToMem() throws IOException {

        RandomAccessFile raf= new RandomAccessFile("C:\\mapfile.txt", "rw");
        FileChannel fc = raf.getChannel();
        //将文件映射到内存中
        MappedByteBuffer mbb= fc.map(FileChannel.MapMode.READ_WRITE, 0, raf.length());
        while(mbb.hasRemaining()){
            System.out.print((char)mbb.get());
        }
        //修改文件
        mbb.put(0,(byte)98);
        raf.close();

    }


}
