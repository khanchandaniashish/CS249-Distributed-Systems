Implement a simple version of the ABD protocol presented in the paper with a couple of small changes:

1) only clients will read and write. the servers that host the registers will only store the register.

2) registers in the service have a string key, a string value, and a uint64 timestamp.

3) to make it possible for new writers to pick valid timestamps, the writer's timestamp will be milliseconds since the "epoch" (midnight, January 1, 1970 UTC). this is what System.currentTimeMillis() gives you in java.

4) You can find the proto file and some skeleton code at https://github.com/breed/CS249-S23/tree/main/abd-assignment. You must not change the commandline or anything outside of the src/main/java directory.

------------------------------------------------------------------------------------------------------------------------------------------------
CLIENT SPECS
------------------------------------------------------------------------------------------------------------------------------------------------
the client should be invoked in two ways:

client host1:port1,host2:port2,.... write register_name new_value
client host1:port1,host2:port2,.... read register_name
(note: client is a placeholder for java -jar ...jar client.)

the write command should finish by printing either success or failure.

the read command should finish by printing the value of the register with the version number in parenthesis or the message failed.

when issuing gRPC calls, you should use a timeout of 3 seconds.

------------------------------------------------------------------------------------------------------------------------------------------------
Server Specs
------------------------------------------------------------------------------------------------------------------------------------------------
the server should take a port number on the command line to startup. it should just run. you may print informational lines if they aren't too distracting and convey information that anyone looking at the output could understand. the server does not need to persist data, so when a server is killed, it is okay for it to startup again with no data.

example code
you might find the full code (with server) from the hello assignment helpful: https://github.com/breed/CS249-S23/tree/main/here-assignment-server