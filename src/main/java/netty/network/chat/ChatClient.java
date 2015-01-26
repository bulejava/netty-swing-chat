package netty.network.chat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class ChatClient {
	
	public static void main(String[] args) throws Exception{
		
		new ChatClient("127.0.0.1",8000).run();;
		
	}
	
	private final String host;
	
	private final  int port;
	
	public ChatClient(String host,int port){
		this.host=host;
		this.port=port;
	}
	
	
	public void run() throws Exception{
		EventLoopGroup group=new NioEventLoopGroup();
		Bootstrap boot=new Bootstrap();
		boot.group(group)
			.channel(NioSocketChannel.class)
			.handler(new ChatClientInitializer());
		Channel channel=boot.connect(host,port).sync().channel();
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		 while(true){
			 channel.writeAndFlush(in.readLine()+"\r\n");
		 }
	}
	
	

}
