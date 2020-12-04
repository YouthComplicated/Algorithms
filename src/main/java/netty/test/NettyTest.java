package netty.test;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;
import io.netty.util.NettyRuntime;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author: nj
 * @date: 2020-11-16 14:20
 * @version: 0.0.1
 */
public class NettyTest {


    /**
     * netty 服务端
     */
    @Test
    public void server() throws InterruptedException {


//        System.out.println(NettyRuntime.availableProcessors());
        System.out.println("cpu核数:" + Runtime.getRuntime().availableProcessors());
        System.out.println("nettyRuntime:" + NettyRuntime.availableProcessors());

        //两个线程池  bossGroup处理accept  workerGroup 处理 read/write send
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        try{
            serverBootstrap.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class) //指定通道
                    .option(ChannelOption.SO_BACKLOG,128) //设置线程队列的连接个数
                    .childOption(ChannelOption.SO_KEEPALIVE, true)//保持连接
                    //加入处理器
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        //给pipeline 设置处理器
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new MyNettyServerHandler());
                        }
                    });

            System.out.println("**********服务器 is ready *************");
            ChannelFuture channelFuture = serverBootstrap.bind(8090).sync();
            channelFuture.channel().closeFuture().sync();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //线程池的shutdown
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();

        }
    }



    @Test
    public void Client() throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup();

        //客户端使用bootstrap不使用ServerBootstrap
        Bootstrap bootstrap = new Bootstrap();
        try{

            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new MyNettyClientHandler());
                        }
                    });

            System.out.println("**********客户端 ok *************");

            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 8090).sync();

            channelFuture.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if(future.isSuccess()){
                        System.out.println("监听事件.....c");
                    }
                }
            });

            channelFuture.channel().closeFuture().sync();



        }catch (Exception e){
            e.printStackTrace();
        }finally {
            group.shutdownGracefully();
        }


    }



}






/**
 * 自定义处理器
 */
class MyNettyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 读取数据实际情况
     * ChannelHandlerContext:
     *   ctx 可以获取管道、通道、地址
     * @param ctx
     * @param msg  数据
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {


//        System.out.println("server ctx:" + ctx.toString());
//        System.out.println("server channel:" + ctx.channel());
//        System.out.println("server pipeline:" + ctx.channel().pipeline());
//        //msg ==> byteBuf
//        ByteBuf buf = (ByteBuf)msg;
//        System.out.println("客户端发送消息是:" + buf.toString(CharsetUtil.UTF_8));
//        System.out.println("客户端地址:" + ctx.channel().remoteAddress());


        /**
         * 1、使用自定义线程
         * eventLoop  队列中  taskqueue
         * 2、定时队列
         * 3、
         */
        ctx.channel().eventLoop().execute(()->{

            System.out.println("server ctx:" + ctx.toString());
            System.out.println("server channel:" + ctx.channel());
            System.out.println("server pipeline:" + ctx.channel().pipeline());
            //msg ==> byteBuf
            ByteBuf buf = (ByteBuf)msg;
            System.out.println("客户端发送消息是:" + buf.toString(CharsetUtil.UTF_8));
            System.out.println("客户端地址:" + ctx.channel().remoteAddress());
        });

        ctx.channel().eventLoop().schedule(()->{

            System.out.println("定时任务队列");

        },3, TimeUnit.SECONDS);




//        super.channelRead(ctx, msg);
    }


    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

//        super.channelReadComplete(ctx);
        //write + flush
        ctx.writeAndFlush(Unpooled.copiedBuffer("ssssssss", CharsetUtil.UTF_8));
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        super.exceptionCaught(ctx, cause);
        ctx.channel().close();
    }
}


/**
 *
 */
class MyNettyClientHandler extends ChannelInboundHandlerAdapter{

    /**
     * 通道就绪就会触发该方法
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        super.channelActive(ctx);

        System.out.println("client:" + ctx);
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello Server", CharsetUtil.UTF_8));
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        super.channelRead(ctx, msg);
        System.out.println("client ctx:" + ctx.toString());
        //msg ==> byteBuf
        ByteBuf buf = (ByteBuf)msg;
        System.out.println("服务端发送消息是:" + buf.toString(CharsetUtil.UTF_8));
        System.out.println("服务端地址:" + ctx.channel().remoteAddress());

    }
}