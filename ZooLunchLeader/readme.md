Context : 

You are a zookeeper at the local zoo. work is hard! pay is lousy, and all you do is shovel poop! to make up for it the zoo pays for lunch, but all of you must go to lunch together. fortunately, the zoo uses ZooKeeper!

there is a designated znode in ZooKeeper for lunch. In this example, we will call it /lunch. (you will take the znode path as a command line parameter.) when it is time for lunch, the supervisor will create a znode called /lunch/readyforlunch which indicates that the zookeepers should get cleaned up and ready for lunch. it is also the time for zookeepers to figure out who is going to pick the place to go. once the shuttle is ready to take the zookeepers to lunch, the supervisor will create a znode called /lunch/lunchtime. at which point, the lunch leader decide where to go to lunch and who is going.

the supervisor will call the goingToLunch() method of the ZooLunch gRPC service on the lunch leader to find out who is going to lunch and where. sometimes the supervisor gets confused, so if goingToLunch() is called on an non-lunch leader, the appropriate return code should be returned.

the zoo also has an auditor to make sure lunches are billed correctly. the auditor uses two calls to do audits: lunchesAttended() to get the zxids of the /lunchtime znodes of the lunches attended and getLunch() that will return information about the lunch.

only zookeepers that registered their znodes before the /lunch/lunchtime znode and after /lunch/readyforlunch will be able to go to lunch. zookeepers that attend a lunch must persistently record it so that they can produce information for auditors even if they are restarted.

------------------------------------------------------------------------------------------------------------------------------------------------
attendance and choosing the leader
------------------------------------------------------------------------------------------------------------------------------------------------
the leader will need to know all the zookeepers that go to lunch, so all available zookeepers will create an emphemeral znode of the form /lunch/zk-<zookeeper_name> (use _ for spaces). zookeepers will create their znode when the /lunch/readyforlunch appears and will delete their znode when /lunch/lunchtime disappears.

zookeepers use an ephemeral node in /lunch/leader to choose a leader. the zookeeper who is able to create that znode will be the leader. the content of that znode will be the name of the leader. zookeeping can be a dangerous job, so sometimes an leader has to miss lunch. when that happens (the zookeeper process crashes), another zookeeper should grab leadership.

zookeepers are a rather polite group, so they try to take turns. if they are a lunch leader, they remember how many people attended lunch with them and sleep that many seconds before trying to become leader the next time. if they are not able to become leader the next time, they will sleep one minus the previous number of seconds the next time they try to become leader, and so on. for example, a leader of 3 zookeepers, will sleep 3 seconds the next time they have an opportunity to become leader. 2 seconds the time after that (assuming they don't become leader). 1 second after that, and then no delay from then on until they become leader again.

------------------------------------------------------------------------------------------------------------------------------------------------
gRPC ZooLunch service
------------------------------------------------------------------------------------------------------------------------------------------------
this lunch perk is pretty expense, so management wants to ensure there is no fraud. all zookeepers must create an ephemeral znode in /lunch/employee/zk-<zookeeper_name> it is kind of the company directory. the content of each of the files is the host:port of the gRPC audit server used by that zookeeper.