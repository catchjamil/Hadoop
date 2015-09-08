package com.zooktutorial.app;

import java.io.IOException;
import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

/**
 * Hello world!
 *
 */
public class TestZKConnector 
{
    public static void main( String[] args ) throws InterruptedException,IOException, KeeperException
    {
        ZKConnector zkConnector = new ZKConnector();
        ZooKeeper connect = zkConnector.connect("localhost");
        List<String> children = connect.getChildren("/", true);
        for(String child:children){
        	System.out.println(child);
        }
    }
}
