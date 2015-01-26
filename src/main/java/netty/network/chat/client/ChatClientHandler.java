package netty.network.chat.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ChatClientHandler extends SimpleChannelInboundHandler<String>{

	@Override
	protected void messageReceived(ChannelHandlerContext ctx, String msg)
			throws Exception {
		 System.out.println("�ͻ����յ�����:"+msg);
	}

}
