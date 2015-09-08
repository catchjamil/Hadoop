package com.zooktutorial.app;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

/**
 * Hello world!
 *
 */
public class CreateZNode 
{
    public static void main( String[] args ) throws InterruptedException,IOException, KeeperException
    {
        ZKConnector zkConnector = new ZKConnector();
        ZooKeeper connect = zkConnector.connect("localhost");
        String create = connect.create("/SampleNode", "Sample Node Data".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        //[zk: localhost:2181(CONNECTED) 6] ls /SampleNode
        System.out.println("ZNode is created : "+create);
    }
}
