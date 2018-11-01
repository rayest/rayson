package org.rayson.foundation.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Component
public class NettyServer {

  private static final Logger logger = LoggerFactory.getLogger(NettyServer.class);

  @Value("${nettyServer.host}")
  String host;
  @Value("${nettyServer.ioThreadNum}")
  int ioThreadNum;
  @Value("${nettyServer.backlog}")
  int backlog;
  @Value("${nettyServer.port}")
  int port;

  private Channel channel;
  /**
   * 内核为此套接口排队的最大连接个数，对于给定的监听套接口，内核要维护两个队列，未链接队列和已连接队列大小总和最大值
   */
  private EventLoopGroup bossGroup;
  private EventLoopGroup workerGroup;

  @Resource
  private TcpServerHandler tcpServerHandler;

  /**
   * 启动
   *
   * @throws InterruptedException
   */
  @PostConstruct
  public void start() throws InterruptedException {
    logger.info("begin to start rpc server");
    bossGroup = new NioEventLoopGroup();
    workerGroup = new NioEventLoopGroup(ioThreadNum);
    ServerBootstrap serverBootstrap = new ServerBootstrap();
    serverBootstrap.group(bossGroup, workerGroup)
        .channel(NioServerSocketChannel.class)
        .option(ChannelOption.SO_BACKLOG, backlog)
        //注意是childOption
        .childOption(ChannelOption.SO_KEEPALIVE, true)
        .childOption(ChannelOption.TCP_NODELAY, true)
        .childHandler(new ChannelInitializer<SocketChannel>() {
          @Override
          protected void initChannel(SocketChannel socketChannel) throws Exception {
            socketChannel.pipeline().addLast(tcpServerHandler);
          }
        });

    channel = serverBootstrap.bind(host, port).sync().channel();
    logger.info("NettyRPC server listening on port " + port + " and ready for connections...");
    channel.closeFuture().sync();
  }

  @PreDestroy
  public void stop() {
    logger.info("destroy server resources");
    if (null == channel) {
      logger.error("server channel is null");
    }
    bossGroup.shutdownGracefully();
    workerGroup.shutdownGracefully();
    channel.closeFuture().syncUninterruptibly();
    bossGroup = null;
    workerGroup = null;
    channel = null;
  }
}
