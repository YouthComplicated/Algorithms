package netty.InboundHander;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.MessageToByteEncoder;

import java.util.List;

/**
 * @author: nj
 * @date: 2020-11-18 17:33
 * @version: 0.0.1
 */
public class Client {


    public static void main(String[] args) throws InterruptedException {

        EventLoopGroup works = new NioEventLoopGroup(3);
        Bootstrap bootstrap = new Bootstrap();
        try{

            bootstrap.group(works).channel(NioSocketChannel.class)
                    .handler(new MyClientChannelInitializer());

            ChannelFuture future = bootstrap.connect("127.0.0.1", 7777).sync();
            future.channel().closeFuture().sync();


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            works.shutdownGracefully();
        }

    }

}


class MyClientChannelInitializer extends ChannelInitializer<SocketChannel>{

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        ChannelPipeline pipeline = ch.pipeline();
        //加入解码器
        pipeline.addLast(new MyMessageLongToByteDecode());
        //加入handler
        pipeline.addLast(new MyClientHandler());

    }
}

class MyClientHandler extends SimpleChannelInboundHandler<Long>{


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Long msg) throws Exception {

    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        super.channelInactive(ctx);

        System.out.println("myClient发送数据.....");

        ctx.writeAndFlush(12345679L);

    }
}

class MyMessageLongToByteDecode extends MessageToByteEncoder<Long> {


    @Override
    protected void encode(ChannelHandlerContext ctx, Long msg, ByteBuf out) throws Exception {
        System.out.println("客户端编码MyMessageLongToByteDecode被调用！！");
        System.out.println("msg:" + msg);
        out.writeLong(msg);
    }
}