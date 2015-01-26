package netty.network.chat.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class ChatClientInitializer extends ChannelInitializer<SocketChannel>  {

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		
		ChannelPipeline pipline=ch.pipeline();
		
		pipline.addLast("framer",new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()))
				.addLast("decoder",new StringDecoder())		
				.addLast("encoder",new StringEncoder())
				.addLast("handler",new ChatClientHandler());
		
		
	}

	
	

	
}
