package com.zooktutorial.app;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

// ACL stand for Access Control List
public class GetACLAuthentication 
{
	private static String userName="userName";
	private static String password="password";
    public static void main( String[] args ) throws InterruptedException,IOException, KeeperException
    {
        ZKConnector zkConnector = new ZKConnector();
        ZooKeeper connect = zkConnector.connect("localhost");
        
       connect.addAuthInfo("digest", (userName+":"+password).getBytes());
        
        byte[] data = connect.getData("/SampleNode", true, connect.exists("/SampleNode", true));
        for(byte b:data){
        	System.out.print((char)b);
        }
        
    }
}
