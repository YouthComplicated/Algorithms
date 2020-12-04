package netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author: nj
 * @date: 2020-11-15 22:12
 * @version: 0.0.1
 */
public class NIOServer {


    public static void main(String[] args) throws IOException {

        //serverSocket
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //selector
        Selector selector = Selector.open();

        //监听端口
        serverSocketChannel.socket().bind(new InetSocketAddress(7777));

        //非阻塞
        serverSocketChannel.configureBlocking(false);

        //四种事件  接收、read、write、connect
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true){
            if(selector.select(1000) == 0){
                System.out.println("可以干别的了");
                continue;
            }
            //返回的>0
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            //判断事件
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                if(key.isAcceptable()){
                    //如果可以接收，为客户端生成socketChannel
                    SocketChannel socketChannel = serverSocketChannel.accept();

                    socketChannel.configureBlocking(false);
                    //绑定关联的buffer
                    socketChannel.register(selector,SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }

                if(key.isReadable()){
                    //如果可以读取
                    SocketChannel channel = (SocketChannel)key.channel();
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    channel.read(buffer);
                    System.out.println("*******server读取客户端:"+new String(buffer.array()));
                }
                iterator.remove();
            }

        }

    }

}