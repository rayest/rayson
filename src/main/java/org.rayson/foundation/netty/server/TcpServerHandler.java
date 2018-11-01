package org.rayson.foundation.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.ReferenceCountUtil;
import org.rayson.foundation.netty.ConvertCodeUtils;
import org.rayson.foundation.netty.DateUtils;
import org.rayson.foundation.netty.MessageUtils;
import org.rayson.foundation.netty.tcp.TcpMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;

import static io.netty.handler.codec.stomp.StompHeaders.HEART_BEAT;


@ChannelHandler.Sharable
@Component
public class TcpServerHandler extends ChannelInboundHandlerAdapter {

    @Resource
    private MessageUtils messageUtils;

    private final Logger logger = LoggerFactory.getLogger(TcpServerHandler.class);

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
            if (idleStateEvent.state() == IdleState.READER_IDLE) {
                logger.info("已经5秒没有收到信息！");
                ctx.writeAndFlush(HEART_BEAT).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
            }
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        logger.info("======================接收报文[channelId={}]=====================================", ctx.channel().id().asShortText());
        ByteBuf in = (ByteBuf) msg;
        try {
            byte[] bytes = new byte[in.readableBytes()];
            //复制内容到字节数组bytes
            in.readBytes(bytes);
            //得到的16进制字符串
            String receiveMessage = ConvertCodeUtils.receiveHexToString(bytes);
            logger.info("接收报文:{}", receiveMessage);
            logger.debug("接收报文长度:{}", receiveMessage.length());

            //响应报文数据
            String backData;
            TcpMessage messageHead = new TcpMessage();
            try {
                messageHead = messageUtils.getMessageHead(receiveMessage);
                logger.debug("接受请求头数据：{}", messageHead.toHeadString());
                Integer length = Integer.valueOf(messageHead.getDataLength(), 16);
                logger.debug("数据内容长度：{}字节", length);

                //校验开始标识
                if ("66E3".equals(messageHead.getStartFlag())) {
                    int head = 14;
                    byte[] needValid;
                    needValid = Arrays.copyOfRange(bytes, head, head + length);
                    String myCrc = ConvertCodeUtils.crc32(needValid);
                    logger.info("接收校验和：{}，我的校验和：{}", messageHead.getCrcSign(), myCrc);
                    if (myCrc.equals(messageHead.getCrcSign())) {
                        logger.debug("校验和成功");
                        backData = "2222";
                    } else {
                        logger.debug("校验和失败");
                        backData = "123" + DateUtils.getHexTime();
                    }
                } else {
                    //请求开始标识有误
                    backData = "23345" + DateUtils.getHexTime();
                }
            } catch (Exception e) {
                logger.error(e.getLocalizedMessage());
                //请求开始标识有误
                backData = "46565" + DateUtils.getHexTime();
            }
            logger.info("backData: {}", backData);
            backData = messageUtils.getRespStr(messageHead, backData);
            logger.info("backData2: {}", backData);
            byte[] returnBytes = ConvertCodeUtils.HexToByte(backData);
            ByteBuf resp = Unpooled.copiedBuffer(returnBytes);
            ctx.writeAndFlush(resp);
            logger.info("响应报文:{}", backData);
        } finally {
            ReferenceCountUtil.release(msg);
        }
        logger.info("======================响应报文[channelId={}]=====================================", ctx.channel().id().asShortText());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.error("exceptionCaught!:", cause);
    }
}
