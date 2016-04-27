package com.oprisk.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;


public class MySqlConnectSSH {

	 
    /**
     * Java Program to connect to remote database through SSH using port forwarding
     * @author Pankaj@JournalDev
     * @throws SQLException 
     */
    public static void main(String[] args) throws SQLException {
 
		int lport = 5656;
		String rhost = "localhost";
		String host = "ec2-52-35-166-255.us-west-2.compute.amazonaws.com";
		int rport = 3306;
		String user = "ec2-user";
		String password = "C:/Users/Bsethupathi/Desktop/opri_key_pair.pem";
        String dbuserName = "opriadmin";
        String dbpassword = "opriadmin";
        String url = "jdbc:mysql://127.0.0.1:3306/test";
        String driverName="com.mysql.jdbc.Driver";
        Connection conn = null;
        Session session= null;
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
             
            //mysql database connectivity
            Class.forName(driverName).newInstance();
            conn = DriverManager.getConnection (url, dbuserName, dbpassword);
            System.out.println ("Database connection established");
            System.out.println("DONE");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(conn != null && !conn.isClosed()){
                System.out.println("Closing Database Connection");
                conn.close();
            }
            if(session !=null && session.isConnected()){
                System.out.println("Closing SSH Connection");
                session.disconnect();
            }
        }
    }

}
