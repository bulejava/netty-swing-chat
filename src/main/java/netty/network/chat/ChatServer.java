package netty.network.chat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class ChatServer {
	public static void main(String[] arsg) throws Exception{
		new ChatServer(8000).run();
	}
	
	private final int port;
	
	public ChatServer(int port){
		this.port=port;
	}
	
	public void run() throws Exception{
		EventLoopGroup bossGroup=new NioEventLoopGroup();
		EventLoopGroup workerGroup=new NioEventLoopGroup();
		try{
			ServerBootstrap boot=new ServerBootstrap();
			boot.group(bossGroup, workerGroup)
			    .channel(NioServerSocketChannel.class)
			    .childHandler(new ChatServerInitializer());
			boot.bind(port).sync().channel().closeFuture().sync();
		}finally{
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}

}
