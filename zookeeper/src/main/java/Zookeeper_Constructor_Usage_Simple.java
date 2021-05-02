import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

public class Zookeeper_Constructor_Usage_Simple implements Watcher {
    private static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) throws Exception{
        /**
         * 1 new ZooKeeper() canBeReadOnly 是否支持只读模式
         * sessionId  sessionPasswd 唯一确认一个会话，可以实现对会话的复用。
         * 2 注意:会话的建立是一个异步的过程。
         */
        ZooKeeper zookeeper = new ZooKeeper("127.0.0.1:2181",5000,new Zookeeper_Constructor_Usage_Simple());
        System.out.println(zookeeper.getState());
        latch.await();
     }
    public void process(WatchedEvent watchedEvent) {
        System.out.println("Receive watched event:"+watchedEvent);
        if(Event.KeeperState.SyncConnected == watchedEvent.getState()){
            latch.countDown();
        }
    }
}
