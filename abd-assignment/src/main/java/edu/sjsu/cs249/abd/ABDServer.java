package edu.sjsu.cs249.abd;

import io.grpc.*;
import io.grpc.stub.StreamObserver;
import picocli.CommandLine;

import java.net.SocketAddress;
import java.util.HashMap;
import java.util.concurrent.Callable;

import static io.grpc.Grpc.TRANSPORT_ATTR_REMOTE_ADDR;

/**
 * @author ashish
 */
public class ABDServer extends ABDServiceGrpc.ABDServiceImplBase  {

//    @CommandLine.Command(subcommands = {ServerCli.class})
//    static class Cli {
//    }
//
//    @CommandLine.Command(name = "server", mixinStandardHelpOptions = true, description = "attendance server for class.")
//    static class ServerCli implements Callable<Integer> {
//        @CommandLine.Parameters(index = "0", description = "port to connect listen on.")
//        int port;
//
//
//        public class Server extends ABDServiceGrpc.ABDServiceImplBase {

            HashMap<Long, Long[]> dataStore;
            boolean read1 ;
            boolean write ;
            boolean read2 ;

            public ABDServer() {
                dataStore = new HashMap<>();
                read1 = true;
                read2 = true;
                write = true;
            }
            @Override
            public void name(Grpc.NameRequest request, StreamObserver<Grpc.NameResponse> response) {
                response.onNext(Grpc.NameResponse.newBuilder().setName("Ashish Khanchandani!").build());
                response.onCompleted();
            }

            @Override
            public void exit(Grpc.ExitRequest exitRequest, StreamObserver<Grpc.ExitResponse> response){
                System.out.println("Server Shutdown request received");
                response.onNext(Grpc.ExitResponse.newBuilder().build());
                response.onCompleted();
                System.out.println("Shutting the Server down in 3..2...1");
                System.exit(0);
            }

            @Override
            public void write(Grpc.WriteRequest writeRequest, StreamObserver<Grpc.WriteResponse> writeResponse) {
                if (write) {
                    System.out.println("Write request received from addr : " + writeRequest.getAddr());
                    Long[] array = new Long[2];
                    array[0]= writeRequest.getLabel();
                    array[1] = writeRequest.getValue();
                    dataStore.put(writeRequest.getAddr(), array);
                    writeResponse.onNext(Grpc.WriteResponse.newBuilder().build());
                    writeResponse.onCompleted();
                }
            }

            @Override
            public void read1(Grpc.Read1Request read1Request, StreamObserver<Grpc.Read1Response> read1ResponseStreamObserver) {
                System.out.println("Read1 invoked.");
                if (read1) {

                    System.out.println("Reading..");
                    Long addr = read1Request.getAddr();
                    Grpc.Read1Response response = Grpc.Read1Response.newBuilder().setRc(1).build();

                    //Success case
                    if (dataStore.containsKey(addr)) {
                        Long[] array= dataStore.get(addr);
                        response = Grpc.Read1Response.newBuilder().setRc(0).setLabel(array[0]).setValue(array[1]).build();
                    }
//                    System.out.println("Read Value  at addr:" + addr + " Label " + response.getLabel() + " Value : " + response.getValue());
                    read1ResponseStreamObserver.onNext(response);
                    read1ResponseStreamObserver.onCompleted();
                }
            }

            @Override
            public void read2(Grpc.Read2Request read2Request, StreamObserver<Grpc.Read2Response> read2Response){
                if(read2) {
                    Long[] latest = new Long[2];
                    latest[0] = read2Request.getLabel();
                    latest[1] = read2Request.getValue();
                    Long addr = read2Request.getAddr();
                    if (dataStore.containsKey(addr)) {
                        System.out.println("executing read 2");
                        Long[] curr = dataStore.get(read2Request.getAddr());
                        if (latest[0] > curr[0]) {
                            dataStore.put(read2Request.getAddr(), latest);
                            System.out.println("register value : Addr + " + addr + " Label " + latest[0] + " Value " + latest[1]);
                        }
                    } else {
                        dataStore.put(addr,latest);
                    }
                    read2Response.onNext(Grpc.Read2Response.newBuilder().build());
                    read2Response.onCompleted();
                }
            }

            @Override
            public void enableRequests(Grpc.EnableRequest request, StreamObserver<Grpc.EnableResponse> enableResponse){
                read1 = request.getRead1();
                read2 = request.getRead2();
                write = request.getWrite();

                enableResponse.onNext(Grpc.EnableResponse.newBuilder().build());
                enableResponse.onCompleted();
            }

//            rpc enableRequests(EnableRequest) returns (EnableResponse);
//            rpc read1(Read1Request) returns (Read1Response);
//            rpc read2(Read2Request) returns (Read2Response);
//            rpc write(WriteRequest) returns (WriteResponse);
//            // causes the server to immediately exit
//            rpc exit(ExitRequest) returns (ExitResponse);
        }


//        static private Context.Key<SocketAddress> REMOTE_ADDR = Context.key("REMOTE_ADDR");
//
//        @Override
//        public Integer call() throws Exception {
//            System.out.printf("listening on %d\n", port);
//            var server = ServerBuilder.forPort(port).intercept(new ServerInterceptor() {
//                @Override
//                public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> sc, Metadata h,
//                                                                             ServerCallHandler<ReqT, RespT> next) {
//                    var remote = sc.getAttributes().get(TRANSPORT_ATTR_REMOTE_ADDR);
//                    return Contexts.interceptCall(Context.current().withValue(REMOTE_ADDR, remote),
//                            sc, h, next);
//                }
//            }).addService(new Server()).build();
//            server.start();
//            server.awaitTermination();
//            return 0;
//        }
//    }
//
//
//    public static void main(String[] args) {
//        System.exit(new CommandLine(new Cli()).execute(args));
//    }
//}
