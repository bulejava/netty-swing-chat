package netty.network.chat.server;

import netty.network.chat.server.face.ClientManager;

public class Launcher {

	public static void main(String[] args){
		
		ClientManager clientManager=ClientManager.getInstacne();
		
		clientManager.start();
		
		
	}
	
}
