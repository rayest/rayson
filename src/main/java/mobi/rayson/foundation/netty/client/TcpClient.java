package mobi.rayson.foundation.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import mobi.rayson.foundation.netty.ConvertCodeUtils;

public class TcpClient {


    public static String HOST = "127.0.0.1";
    public static int PORT = 9624;
    public static Bootstrap bootstrap = getBootstrap();
    public static Channel channel = getChannel(HOST, PORT);

    /**
     * 初始化Bootstrap
     */
    public static final Bootstrap getBootstrap() {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        b.group(group).channel(NioSocketChannel.class);
        b.handler(new ChannelInitializer<Channel>() {
            @Override
            protected void initChannel(Channel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast("handler", new TcpClientHandler());
            }
        });
        b.option(ChannelOption.SO_KEEPALIVE, true);
        return b;
    }

    public static final Channel getChannel(String host, int port) {
        Channel channel = null;
        try {
            channel = bootstrap.connect(host, port).sync().channel();
        } catch (Exception e) {
            return null;
        }
        return channel;
    }

    public static void sendMsg(ByteBuf msg) throws Exception {
        if (channel != null) {
            channel.writeAndFlush(msg).sync();
        } else {
        }
    }

    private static String sendOrderRecord() {
        return "66E3210181610031000C0000008A02BB96CBD017A720000020180712000001120000015B470A3112345678100220180D913B87D67500000000000000000000000000000F3C20180D913B87D6755B470A2B0000000A333714D60381610031000000395B470A37000000000000000888B1400001000000640000006400000000000000000066A91BBD000000000000000000000000000000009CE4657C";
    }

    public static void main(String[] args) throws Exception {
        try {
            String sendStr = sendOrderRecord();
            byte[] a = ConvertCodeUtils.HexToByte(sendStr);
            ByteBuf bResp = Unpooled.copiedBuffer(a);
            sendMsg(bResp);
        } catch (Exception e) {
        }
    }
}

