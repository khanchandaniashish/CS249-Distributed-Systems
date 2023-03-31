package edu.sjsu.cs249.zooleader;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import picocli.CommandLine;

import java.util.concurrent.Callable;

/**
 * @author ${USER}
 */
public class Main {
    public static void main(String[] args) {
        System.exit(new CommandLine(new ServerCli()).execute(args));
    }


    static class ServerCli implements Callable<Integer> {

        @CommandLine.Parameters(index = "0", description = "ZooNode name")
        String yourName;

        @CommandLine.Parameters(index = "1", description = "host:port listen on.")
        String serverAddress;

        @CommandLine.Parameters(index = "2", description = "List of zooServers")
        String zooServerList;

        @CommandLine.Parameters(index = "3", description = "Path to look out for changes")
        String zooPath;

        ZooManager zooManager;


        @Override
        public Integer call() throws Exception {
                Persister persister = new Persister(yourName);
                zooManager = new ZooManager(yourName, zooServerList, zooPath, persister, serverAddress);
                System.out.printf("will contact %s\n", serverAddress);
                var lastColon = serverAddress.lastIndexOf(':');
                var host = serverAddress.substring(0, lastColon);
                var serverPort = Integer.parseInt(serverAddress.substring(lastColon + 1));
                Server server = ServerBuilder.forPort(serverPort)
                        .addService(new ZooGRPCServer(persister, yourName,zooManager))
                        .build();
                server.start();
                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                    server.shutdown();
                    zooManager.stopZooKeeper();
                    System.out.println("Successfully shutdown zk server");
                }));
                server.awaitTermination();
                return 0;
        }
    }
}