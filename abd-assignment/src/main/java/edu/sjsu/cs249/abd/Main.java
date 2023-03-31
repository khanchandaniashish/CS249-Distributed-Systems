package edu.sjsu.cs249.abd;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

public class Main {

    public static void main(String[] args) {
        System.exit(new CommandLine(new Cli()).execute(args));
    }

    @Command(subcommands = {ServerCli.class, ClientCli.class})
    static class Cli {}

    @Command(name = "server", mixinStandardHelpOptions = true, description = "start an ABD register server.")
    static class ServerCli implements Callable<Integer> {
        @Parameters(index = "0", description = "host:port listen on.")
        int serverAddress;
        @Override
        public Integer call() throws Exception {
            System.out.printf("will contact %s\n", serverAddress);
//            var lastColon = serverAddress.lastIndexOf(':');
//            var host = serverAddress.substring(0, lastColon);
//            var serverPort = Integer.parseInt(serverAddress.substring(lastColon+1));
            Server server = ServerBuilder.forPort(serverAddress)
                    .addService(new ABDServer())
                    .build();
            server.start();
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                server.shutdown();
                System.out.println("Successfully stopped the server");
            }));
            server.awaitTermination();
            return 0;
        }
    }

    @Command(name = "client", mixinStandardHelpOptions = true, description = "start and ADB client.")
    static class ClientCli {
        @Parameters(index = "0", description = "comma separated list of servers to use.")
        String serverPorts;

        @Command
        public void read(@Parameters(paramLabel = "register") long register) {
//            System.out.printf("Going to read %s from %s\n", register, serverPorts);
//            System.out.println("Read called");
            String[] serversList = serverPorts.split(",");
            new ABDClient().readFromRegister(register, serversList);
        }

        @Command
        public void write(@Parameters(paramLabel = "register") long register,
                          @Parameters(paramLabel = "value") long value) {
//            System.out.printf("Going to write %s to %s on %s\n", value, register, serverPorts);
            String[] serversList = serverPorts.split(",");
            new ABDClient().writeToDataStore(register, value, serversList);
        }
    }
}
