package netty.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;
import org.junit.Test;

import java.net.URI;

/**
 * @author: nj
 * @date: 2020-11-16 19:48
 * @version: 0.0.1
 */
public class Server {




    @Test
    public void httpServer(){

        //两个线程池  bossGroup处理accept  workerGroup 处理 read/write send
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        try{
            serverBootstrap.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class) //指定通道
                    .option(ChannelOption.SO_BACKLOG,128) //设置线程队列的连接个数
                    .childOption(ChannelOption.SO_KEEPALIVE, true)//保持连接
                    //加入处理器 workGroup的handler
                    .childHandler(
                            new MyChannelInitializer()

                    );

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
}

/**
 * 抽象出channel 初始化逻辑
 */
class MyChannelInitializer extends ChannelInitializer<SocketChannel>{


    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        //管道
        ChannelPipeline pipeline = ch.pipeline();
        //编解码器
        pipeline.addLast("myHttpServerCodec", new HttpServerCodec());
        pipeline.addLast("MyHandler", new MyHandler());

    }
}

/**
 * 处理器
 */
class MyHandler extends SimpleChannelInboundHandler<HttpObject>{

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {


        if(msg instanceof HttpRequest){
            System.out.println("msg 类型：" + msg.getClass());
            System.out.println("客户端地址:" + ctx.channel().remoteAddress());

            HttpRequest request = (HttpRequest)msg;
            URI uri = new URI(request.uri());
            System.out.println("uri:" + uri.getPath());
            if("favicon.ico".equals(uri.getPath())){
                return;
            }

            ByteBuf buf = Unpooled.copiedBuffer("sfwefew", CharsetUtil.UTF_8);


            //构造httpResponse
            DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_0,
                    HttpResponseStatus.OK, buf);

            response.headers().add(HttpHeaderNames.CONTENT_TYPE,"text/plain");
            response.headers().add(HttpHeaderNames.CONTENT_LENGTH, buf.readableBytes());

            //写出
            ctx.writeAndFlush(response);

        }
    }
}