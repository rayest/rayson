package org.rayson.foundation.netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.rayson.foundation.netty.ConvertCodeUtils;

public class TcpClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("============接收响应报文[channelId={}]" + ctx.channel().id());
        ByteBuf in = (ByteBuf) msg;
        byte[] bytes = new byte[in.readableBytes()];
        //复制内容到字节数组bytes
        in.readBytes(bytes);
        //得到的16进制字符串
        String receiveMessage = ConvertCodeUtils.receiveHexToString(bytes);
        System.out.println("receiveMessage: " + receiveMessage);

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //ctx.close();
    }
}
