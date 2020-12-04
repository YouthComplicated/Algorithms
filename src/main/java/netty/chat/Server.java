package netty.chat;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 群聊系统
 *
 * 功能点
 * 1、有人会广播所有人(not self)
 * 2、下线会广播所有人(not self)
 * 3、群发
 * 4、私聊
 *
 *
 * 考虑的问，并发，压力的点在哪里
 *
 * @author: nj
 * @date: 2020-11-16 21:29
 * @version: 0.0.1
 */
public class Server {

    private int port;

    public Server(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void run() throws InterruptedException {

        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workGroup = new NioEventLoopGroup(12);
        ServerBootstrap  serverBootstrap = new ServerBootstrap();
        try{
            serverBootstrap.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class) //必需指定
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE,true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            //获取pipeline
                            ChannelPipeline pipeline = ch.pipeline();
                            //编解码处理器
                            pipeline.addLast("decoder", new StringDecoder());
                            pipeline.addLast("encoder", new StringEncoder());
                            //加入自己编码器
                            pipeline.addLast(new MyHandler());

                        }
                    });
            System.out.println("**************服务器启动了**********");
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            //监听关闭事件
            channelFuture.channel().closeFuture().sync();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Server server = new Server(9999);
        server.run();

    }

}


class MyHandler extends SimpleChannelInboundHandler<String> {


    public static Map<String,Channel> channelMap = new HashMap<>();

    //channelGroup 管理所有管道，全局单例
    private  static  ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {

    }

    //将当前channel 加入group
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
//        super.handlerAdded(ctx);

        Channel channel = ctx.channel();
        //底层遍历将所有channel,并发消息
        channelGroup.writeAndFlush("【客户端】:"+ channel.remoteAddress()+"*** 上线了");
        channelGroup.add(ctx.channel());


    }


    //上线
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        super.channelActive(ctx);
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress()+"上线了*****");
    }



    //下线
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
//        super.channelInactive(ctx);

        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress()+"离线了*****");
    }


    //断开连接，将客户离开信息推送客户
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
//        super.handlerRemoved(ctx);

        Channel channel = ctx.channel();

        channelGroup.writeAndFlush("【客户端】:"+channel.remoteAddress()+"断开连接");


    }


    //发送消息
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.forEach(x->{
            if(channel != x){
                x.writeAndFlush("【客户】"+ channel.remoteAddress()+"发送消息"+msg);
            }else{
                x.writeAndFlush("【自己】"+channel.remoteAddress()+msg);
            }


        });
    }
//
//    @Override
//    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//        super.channelReadComplete(ctx);
//    }
//


    //异常处理
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);

    }


}