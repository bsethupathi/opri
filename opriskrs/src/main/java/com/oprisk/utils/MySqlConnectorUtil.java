package com.oprisk.utils;

import javax.sql.DataSource;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class MySqlConnectorUtil {
	 private static Session session = null;
	 private DataSource dataSource;
	 private static void connectSSH(){ 
			 int lport=5656;
		     String rhost="localhost";
		     String host="ec2-52-35-166-255.us-west-2.compute.amazonaws.com";
		     int rport=3306;
		     String user="ec2-user";
		     String password="C:/Users/Bsethupathi/Desktop/opri_key_pair.pem";
     
		     try{
		         //Set StrictHostKeyChecking property to no to avoid UnknownHostKey issue
		         java.util.Properties config = new java.util.Properties(); 
		         config.put("StrictHostKeyChecking", "no");
		         JSch jsch = new JSch();
		         jsch.addIdentity(password);
		         session=jsch.getSession(user, host, 22);
		         session.setConfig(config);
		         session.connect();
		         System.out.println("Connected");
		         int assinged_port=session.setPortForwardingL(lport, rhost, rport);
		         System.out.println("localhost:"+assinged_port+" -> "+rhost+":"+rport);
		         System.out.println("Port Forwarded");
		          
		       }catch(Exception e){
		         e.printStackTrace();
		     }finally{
		           if(session !=null && session.isConnected()){
		             System.out.println("Closing SSH Connection");
		             session.disconnect();
		         }
		     }
}
	public DataSource getDataSource() {
		return dataSource;
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
