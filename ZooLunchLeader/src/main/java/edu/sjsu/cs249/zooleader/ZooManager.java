package edu.sjsu.cs249.zooleader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static org.apache.zookeeper.ZooDefs.Ids.OPEN_ACL_UNSAFE;


/**
 * @author ashish
 */
public class ZooManager {

    String zooNodeName;
    String zooServers;
    String zooParentPath;
    ZooKeeper zk;

    Persister persister;

    boolean isSkipEnabled;

    Watcher readyForLunchWatcher;
    Watcher lunchTimeWatcher;

    boolean isLeader;

    String GrpcAddress;
    Timer leaderTimer;



    private static final Logger logger = LogManager.getLogger(ZooManager.class);

    ZooManager(String zooNodeName, String zooServers, String zooParentPath, Persister persister, String GrpcAddress) {
        this.zooNodeName = "zk-" + zooNodeName;
        this.zooServers = zooServers;
        this.zooParentPath =  zooParentPath;
        startZooKeeper();
        this.persister = persister;
        this.GrpcAddress = GrpcAddress;
        isSkipEnabled = false;
        process();
    }

    void startZooKeeper() {
        try {
            logger.info("Starting ZOOKEEPER");
            zk = new ZooKeeper(zooServers, 15000, System.out::println);
            System.out.println("Started ZOOKEEPER");
        } catch (Exception e) {
            System.out.println("Failed to start zookeeper due to exception :" + e.getMessage());
            e.printStackTrace();
        }
    }

    void stopZooKeeper() {
        try {
            System.out.println("Shutting down zookeeper!");
            zk.close(1000);
        } catch (Exception e) {
            System.out.println("Failed to stop zookeeper due to exception :" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void registerReadyForLunch() {
        try {
            zk.exists(zooParentPath + "/readyforlunch", readyForLunchWatcher);
            System.out.println("Registering for readyforlunch");
            addBufferSpace();
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void registerLunchTime() {
        try {
            System.out.println("Registering for lunchtime");
            addBufferSpace();
            zk.exists(zooParentPath + "/lunchtime", lunchTimeWatcher);
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void registerAsEmployee() {
        try {
            addBufferSpace();
            System.out.println("Registering as Employee");
            zk.create(zooParentPath + "/employee/" + zooNodeName, GrpcAddress.getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void process() {
        System.out.println("EVENT HIT");

        readyForLunchWatcher = watchedEvent1 -> {
            System.out.println("readyForLunchWatcher RECEIVED");
            System.out.println(watchedEvent1.getType());

            if (ZooManager.this.isSkipEnabled) {
                System.out.println("SKIPPING LUNCH AS SKIP IS ENABLED");
                ZooManager.this.isSkipEnabled = false;
                System.out.println("NOW RESETTING SKIPS");
                return;
            }
                if (!(watchedEvent1.getType() == Watcher.Event.EventType.NodeDeleted) && watchedEvent1.getPath().equals(zooParentPath + "/readyforlunch")) {
                    System.out.println("GET READY BOIS! We LUNCHING ");
                    try {
                        zk.create(zooParentPath + "/" + zooNodeName, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
                        System.out.println("CREATED ENODE under /lunch : " + zooNodeName);
                    } catch (KeeperException | InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        LunchPerk lunchPerk1 = persister.getLunch();
                        System.out.println("GOT LUNCH : " + lunchPerk1);

                        if (lunchPerk1 != null) {
                            int sleep = lunchPerk1.currentSleep;
                            System.out.println("lunchperk name is " + persister.filePath);
                            System.out.println("Fetched sleep  is" + sleep);

                            lunchPerk1.currentSleep = Math.max(sleep - 1, 0);

                            persister.persist(lunchPerk1);
                            System.out.println("update LUNCH PERK TO" + lunchPerk1);
                            System.out.println("sleep  is " + sleep);

                            TimerTask delayTask = new TimerTask() {
                                @Override
                                public void run() {
                                    Stat readyForLunchPathExist;

                                    try {
                                        readyForLunchPathExist = zk.exists(zooParentPath + "/readyforlunch", false);
                                    } catch (KeeperException | InterruptedException e) {
                                        System.out.println("Error in checking for /readyforlunch");
                                        e.printStackTrace();
                                        throw new RuntimeException(e);
                                    }
                                    Stat lunchtimePathExist;
                                    try {
                                        lunchtimePathExist = zk.exists(zooParentPath + "/lunchtime", false);
                                    } catch (KeeperException | InterruptedException e) {
                                        System.out.println("Error in checking for /lunchtime");
                                        e.printStackTrace();
                                        throw new RuntimeException(e);
                                    }
                                    try {
                                        if (readyForLunchPathExist != null && lunchtimePathExist == null) {
                                            runForMaster();
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            };
                            leaderTimer = new Timer();
                            leaderTimer.schedule(delayTask, sleep * 1000L);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                registerReadyForLunch();
        };

        lunchTimeWatcher = watchedEvent1 -> {
            Long lunchtimeCreated = System.currentTimeMillis()-2L;
            System.out.println("WAS: "+lunchtimeCreated);

            if (watchedEvent1.getPath().equals(zooParentPath + "/lunchtime")) {
                if (watchedEvent1.getType() == Watcher.Event.EventType.NodeDeleted) {
                    ///delete leader
                    leaderTimer.cancel();
                    try {
                        System.out.println("DELETING LEADER");
                        System.out.println(watchedEvent1);
                        zk.delete(zooParentPath + "/" + zooNodeName, -1);
                        if (isLeader) {
                            zk.delete(zooParentPath + "/leader", -1);
                        }
                    } catch (InterruptedException | KeeperException e) {
                        e.printStackTrace();
                    }
                }

                else {
                    System.out.println("lunchtimeCreated!");
                    Stat lunchtimeStat = new Stat();
                    try {
                        zk.getData(zooParentPath+"/lunchtime",false,lunchtimeStat);
                        lunchtimeCreated = lunchtimeStat.getCtime();
                        System.out.println("lunchtimeCreated IS now : " + lunchtimeCreated);
                        zk.getData(zooParentPath+"/readyforlunch",false,lunchtimeStat);

                        Long readyForLunchtime = lunchtimeStat.getCtime();
                        System.out.println("readyForLunchtime IS now : " + readyForLunchtime);
                        Lunch lunch = new Lunch();
                        System.out.println("Finding lunchers");
                        Stat someStat = new Stat();
                        zk.getData(zooParentPath + "/lunchtime", false, someStat);

                        //Set lunch ID
                        lunch.lunchId = someStat.getCzxid();

                        //Set attendees
                        List<String> lunchers = zk.getChildren(zooParentPath + "", false,someStat);

                        for (String luncher : lunchers) {
                            Stat metaStats = new Stat();
                            zk.getData(zooParentPath+"/"+luncher,false,metaStats);
                            System.out.println("for :" +luncher+ " ctime : " + metaStats.getCtime());
                            System.out.println("lunchtimeCreated: " +lunchtimeCreated + " " + (metaStats.getCtime() < lunchtimeCreated));
                            System.out.println("readyForLunchtime: "+readyForLunchtime + " " + (metaStats.getCtime() > readyForLunchtime));
                            if (luncher.startsWith("zk") && metaStats.getCtime() < lunchtimeCreated && metaStats.getCtime() > readyForLunchtime ) {
                                System.out.println(luncher);
                                lunch.lunchMates.add(luncher);
                            }
                        }

                        //SetLeader
                        byte[] leader = zk.getData(zooParentPath + "/leader", false, new Stat());
                        lunch.lunchLeader = new String(leader);
                        System.out.println("Comparing :" + zooNodeName + "with" + lunch.lunchLeader);
                        System.out.println(zooNodeName.equals(lunch.lunchLeader));
                        lunch.isLeader = (zooNodeName.equals(lunch.lunchLeader));

                        //Add lunch to List of lunches
                        LunchPerk lunchPerk = persister.getLunch();
                        lunchPerk.lunches.put(lunch.lunchId, lunch);
                        System.out.println(lunch);
                        System.out.println(lunchPerk);

                        //Persist lunch into persistent memory
                        lunchPerk.currentSleep = lunch.isLeader ? lunch.lunchMates.size() - 1 : lunchPerk.currentSleep;
                        System.out.println(lunchPerk);
                        persister.persist(lunchPerk);
                    } catch (KeeperException | InterruptedException | IOException e) {
                        e.printStackTrace();
                    }
                }

            }
            registerLunchTime();
        };
        registerAsEmployee();
        registerReadyForLunch();
        registerLunchTime();
    }

    public void addBufferSpace() {
        System.out.println();
    }

    void runForMaster() {
        while (true) {
            try {
                zk.create(zooParentPath + "/leader", zooNodeName.getBytes(),
                        OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
                isLeader = true;
                break;
            } catch (InterruptedException | KeeperException e) {
                System.out.println("leader already exists");
            }
            if (checkMaster()) break;
        }
    }

    boolean checkMaster() {
        while (true) {
            try {
                Stat stat = new Stat();
                byte[] data = zk.getData(zooParentPath + "/leader", false, stat);
                System.out.println("Leader is " + new String(data));
                isLeader = new String(data).equals(zooNodeName);
                return true;
            } catch (InterruptedException | KeeperException e) {
                e.printStackTrace();
            }
        }
    }
}
