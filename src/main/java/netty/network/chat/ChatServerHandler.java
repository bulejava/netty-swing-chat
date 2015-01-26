package netty.network.chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class ChatServerHandler extends  SimpleChannelInboundHandler<String> {
	
	static final ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		channels.add(ctx.channel());
		System.out.println("�ͻ��ˣ�"+channels.size());
	}

	@Override
	protected void messageReceived(ChannelHandlerContext ctx, String msg)
			throws Exception {
		for(Channel c:channels){
			if(c!=ctx.channel()){
				c.writeAndFlush(ctx.channel().remoteAddress().toString()+":"+msg+"\n");	
			}else {
				c.writeAndFlush("[you] " + msg + '\n');
            }
		}
		
/*		 for (Channel c: channels) {
	            if (c != ctx.channel()) {
	                c.writeAndFlush("[" + ctx.channel().remoteAddress() + "] " +
	                        msg + '\n');
	            } else {
	                c.writeAndFlush("[you] " + msg + '\n');
	            }
	        }

	        // Close the connection if the client has sent 'bye'.
	        if ("bye".equals(msg.toLowerCase())) {
	            ctx.close();
	        }*/
		
	}

	

}
