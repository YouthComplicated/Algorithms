package netty.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: nj
 * @date: 2020-11-15 20:11
 * @version: 0.0.1
 */
public class BioServer {


    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("**********serverSocket启动***********");
        while (true){
            Socket socket = serverSocket.accept();
            System.out.println("链接到客户端");
            executorService.execute(()->{
                handler(socket);
            });
        }
    }


    public static void handler(Socket socket){

        System.out.println("**********线程id:"+Thread.currentThread().getId()+"***********");

        byte[] bytes = new byte[1024];
        try {
            //通过socket输入流
            InputStream inputStream = socket.getInputStream();
            //死循环
            while (true){
                //阻塞
                System.out.println("****阻塞在read****");
                int read = inputStream.read(bytes);
                if(read != 1){
                    System.out.println(new String(bytes,0, read));
                }else{
                    //读取完成
                    break;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }


    }
}