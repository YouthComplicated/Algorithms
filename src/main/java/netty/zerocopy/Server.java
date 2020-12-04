package netty.zerocopy;

import io.netty.buffer.ByteBuf;
import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/**
 * @author: nj
 * @date: 2020-11-16 10:23
 * @version: 0.0.1
 */
public class Server {




    @Test
    public void OldServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(7001);
        while (true){
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            byte[] bytes = new byte[4096];
            while (true){
                int read = dataInputStream.read(bytes, 0, bytes.length);
                if(-1 == read){
                    break;
                }
            }
        }
    }

    @Test
    public void  OldClient() throws IOException {
        Socket socket = new Socket("localhost", 7001);
        String fileName =  "/Users/sunzuo/Desktop/nio/aa.png";
        File file = new File(fileName);
        FileInputStream fileInputStream = new FileInputStream(file);

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        byte[] buffer = new byte[4096];
        long readCount; long total = 0;
        long startTime = System.currentTimeMillis();
        while ( (readCount = fileInputStream.read()) > 0){
            total += readCount;
            dataOutputStream.write(buffer);
        }
        System.out.println("发送的总字节数:"+total+", 耗时:" + (System.currentTimeMillis() - startTime));
        dataOutputStream.close();
        socket.close();
        fileInputStream.close();

    }


    /**
     *
     * NIO url
     *     channel
     *     socket
     *     绑定
     *
     */
    @Test
    public void NewServer() throws IOException {

        //url
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 7001);

        //channel
        ServerSocketChannel socketChannel = ServerSocketChannel.open();

        //从channel获取socket
        ServerSocket serverSocket = socketChannel.socket();

        //绑定地址
        serverSocket.bind(address);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (true){
            SocketChannel socket = socketChannel.accept();
            long readCount = 0;
            while ( readCount != -1){
                readCount = socket.read(byteBuffer);
                //position = 0;
                //mark = -1;
                byteBuffer.rewind();
            }
        }
    }

    @Test
    public void NIOClient() throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 7002));
        String fileName =  "/Users/sunzuo/Desktop/nio/aa.png";
        FileChannel channel = new FileInputStream(fileName).getChannel();
        long start = System.currentTimeMillis();


        //transfer  windows transferTo 只能8m 传输的位置
        long total = channel.transferTo(0, channel.size(), socketChannel);
        System.out.println("发送的总字节数:"+total+", 耗时:" + (System.currentTimeMillis() - start));



    }









}