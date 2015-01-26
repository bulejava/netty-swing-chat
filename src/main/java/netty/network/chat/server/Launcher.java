package netty.network.chat.server;

import netty.network.chat.server.swing.ClientManager;

/**
 * 
 * @author bulejava@126.com
 *
 */
public class Launcher {
	
	public static void main(String[] args){
		
		ClientManager clientManager=ClientManager.getInstacne();
		
		clientManager.start();
		
		
	}

}
