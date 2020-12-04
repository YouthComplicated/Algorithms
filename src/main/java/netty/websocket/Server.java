package netty.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

import java.time.LocalDateTime;


/**
 * @author: nj
 * @date: 2020-11-16 23:33
 * @version: 0.0.1
 */
public class Server {


    public static void main(String[] args) throws InterruptedException {
            EventLoopGroup bossGroup = new NioEventLoopGroup(1);
            EventLoopGroup workGroup = new NioEventLoopGroup(12);
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            try{
                serverBootstrap.group(bossGroup, workGroup)
                        .channel(NioServerSocketChannel.class) //必需指定
                        .option(ChannelOption.SO_BACKLOG, 128)
                        .childOption(ChannelOption.SO_KEEPALIVE, true)
                        .handler(new LoggingHandler(LogLevel.INFO))
                        .childHandler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel ch) throws Exception {
                                //获取pipeline
                                ChannelPipeline pipeline = ch.pipeline();


                                pipeline.addLast(new HttpServerCodec());
                                //c->s  chunkedWriteHandler
                                pipeline.addLast(new ChunkedWriteHandler());

                                /**
                                 * http传输过程中是分段的，httpObjectAggreator,将多个段聚合
                                 * 发送大量数据会发生多次http请求
                                 */
                                pipeline.addLast(new HttpObjectAggregator(8192));
                                /**
                                 * webSocket,它的数据以frame实现
                                 * 浏览器请求时  ws://localhost:7000/hello
                                 * 将http协议升级为ws协议
                                 *
                                 * 101 通过状态码
                                 */
                                pipeline.addLast(new WebSocketServerProtocolHandler("/hello"));

                                pipeline.addLast(new MyTextWebSocketFrameHandelr());

                            }
                        });
                System.out.println("**************服务器启动了**********");
                ChannelFuture channelFuture = serverBootstrap.bind(7777).sync();
                //监听关闭事件
                channelFuture.channel().closeFuture().sync();
            }finally {
                bossGroup.shutdownGracefully();
                workGroup.shutdownGracefully();
            }
    }

}

class MyTextWebSocketFrameHandelr extends SimpleChannelInboundHandler<TextWebSocketFrame>{

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {

        System.out.println("服务器接收的消息:" + msg.text());
        ctx.channel().writeAndFlush(new TextWebSocketFrame("服务器时间"+ LocalDateTime.now())+msg.text());

    }

    /**
     * 当客户链接，触发方法
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
//        super.handlerAdded(ctx);

        System.out.println("handler add 被调用" + ctx.channel().id().asShortText());
        System.out.println("handler add 被调用" + ctx.channel().id().asLongText());


    }


    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
//        super.handlerRemoved(ctx);
        System.out.println("handler remove 被调用" + ctx.channel().id().asLongText());
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        super.exceptionCaught(ctx, cause);
        System.out.println("异常中断");
        ctx.channel().close();
    }
}