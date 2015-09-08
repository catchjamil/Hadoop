package com.zooktutorial.app;

import java.io.IOException;
import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;

/* ACL stand for Access Control List

Scheme= groupd of users or indiviuals that are authenticated to access the znode
(Shcheme)world:represents anyone in the world who has access to zookeeper ensemble
(Scheme)digest:represents one single individual with their own unique id and password
Host:represents groupd of users withing that host(myhost.come)
IP:represents groupd of users within that same ip address

permission sets
crdwa=31=>convert to binary
c=create,r=read,d:delete,w:write,admin
*/
public class GetACL 
{
    public static void main( String[] args ) throws InterruptedException,IOException, KeeperException
    {
        ZKConnector zkConnector = new ZKConnector();
        ZooKeeper connect = zkConnector.connect("localhost");
        List<ACL> acl = connect.getACL("/SampleNode", connect.exists("/SampleNode", true));
        /* from Zookeeper command prompt
        [zk: localhost:2181(CONNECTED) 17] getAcl /SampleNode
        'world,'anyone
        : cdrwa
        You can update default access by below command
        [zk: localhost:2181(CONNECTED) 27] setAcl /SampleNode world:anyone:card
        */
        for(ACL aclItem : acl){
        	System.out.println(aclItem.toString());
        }
        
    }
}
