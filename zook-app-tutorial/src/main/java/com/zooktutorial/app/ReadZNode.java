package com.zooktutorial.app;

import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

/**
 * Hello world!
 *
 */
public class ReadZNode 
{
    public static void main( String[] args ) throws InterruptedException,IOException, KeeperException
    {
        ZKConnector zkConnector = new ZKConnector();
        ZooKeeper connect = zkConnector.connect("localhost");
      //[zk: localhost:2181(CONNECTED) 6] get /SampleNode
        byte[] data = connect.getData("/SampleNode", true, connect.exists("/SampleNode", true));
        for(byte b:data){
        	System.out.print((char)b);
        }
    }
}
