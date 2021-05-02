import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

/**
 * @Description:复用链接
 * @Date: 2021-05-02 18:46
 * @param:
 * @return:
 **/
public class Zookeeper_Constructor_Sid_Passwd implements Watcher {
    private static final  CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) throws Exception{
        ZooKeeper zookeeper = new ZooKeeper("localhost:2181",5000,new  Zookeeper_Constructor_Sid_Passwd());
        latch.await();
        long sessionId = zookeeper.getSessionId();
        byte[] sessionPasswd= zookeeper.getSessionPasswd();
        //使用非法的sessionId 和 sessionPassWd
        zookeeper = new ZooKeeper("localhost:2181",5000,new  Zookeeper_Constructor_Sid_Passwd(),1l,"test".getBytes());
        //使用当前的sessionId 和 sessionPassWd
        zookeeper = new ZooKeeper("localhost:2181",5000,new  Zookeeper_Constructor_Sid_Passwd(),sessionId,sessionPasswd);
        Thread.sleep(Integer.MAX_VALUE);
    }
    public void process(WatchedEvent event) {
        System.out.println("Receive watched event:"+event);
        if(Event.KeeperState.SyncConnected == event.getState()){
            latch.countDown();
        }
    }
}
