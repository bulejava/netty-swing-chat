package netty.network.chat.server.swing;

import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.UIManager;

import netty.network.chat.server.model.Client;

public class ClientManager extends JFrame {
	private static final long serialVersionUID = 1L;
	private static ClientManager clientManager;
	
	public static ClientManager getInstacne(){
		if(clientManager==null){
			clientManager=new ClientManager();
		}
		return clientManager;
	}
	
	private ClientManager(){
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			this.setSize(700, 500);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void start(){
		
		initUI();
		this.setVisible(true);
	}

	private void initUI() {
		FlowLayout fl=new FlowLayout();  
		clientManager.setLayout(fl);   //创建一个表格对象  
	    JTable table=new JTable();   //得到要显示的用户列表对象：   
		List<Client> clientList=getUserList();      //创建我们实现的TableModel对象,创建时要传入用户列表对象 
   ClientTableModel tm=new ClientTableModel(clientList);  
   table.setModel(tm);//将模型设给表格     
   clientManager.add(table);        
		
	}

	private List<Client> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
