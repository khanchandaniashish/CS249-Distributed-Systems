package edu.sjsu.cs249.abd;

import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import picocli.CommandLine;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;



/**
 * @author ashish
 */


public class ABDClient {

    public void writeToDataStore(long addr, long value, String[] servers) {

        int n = servers.length;
        int majority = (n + 1) / 2;
        CountDownLatch latch = new CountDownLatch(majority);
        Long time = System.currentTimeMillis();
        for (String server : servers) {
            ManagedChannel channel = getChannel(server);

            //Create a stub
            var stub = this.createStub(channel);


            StreamObserver<Grpc.WriteResponse> responseStreamObserver = new StreamObserver<>() {
                @Override
                public void onNext(Grpc.WriteResponse writeResponse) {
                }

                @Override
                public void onError(Throwable throwable) {
                    System.out.println("failed");
                }

                @Override
                public void onCompleted() {
                    channel.shutdownNow();
                    latch.countDown();
                }
            };
            //Write
            stub.write(Grpc.WriteRequest.newBuilder().setLabel(time).setAddr(addr).setValue(value).build(), responseStreamObserver);
        }
            try {
                latch.await(3, TimeUnit.SECONDS);
                if (latch.getCount() == 0)
                    System.out.println("success");
                else {
                    System.out.println("failure");
                    System.exit(0);
                }

            } catch (InterruptedException e) {
//                System.out.println("failed");
                throw new RuntimeException(e);
            }
//            System.out.println(" Server gave me an ACK"+ server);
        }


    public void readFromRegister(long register, String[] servers) {

        int n = servers.length;
        int majority = (n + 1) / 2;
        CountDownLatch latch = new CountDownLatch(majority);
        ArrayList<Long[]> arrayList = new ArrayList<>();

        for (String server : servers) {
            ManagedChannel channel = getChannel(server);

            StreamObserver<Grpc.Read1Response> responseStreamObserver = new StreamObserver<>() {

                @Override
                public void onNext(Grpc.Read1Response read1Response) {
                    if (read1Response.getRc() == 0) {
                        arrayList.add(new Long[]{read1Response.getLabel(), read1Response.getValue()});
                    }
                }

                @Override
                public void onError(Throwable throwable) {
                }

                @Override
                public void onCompleted() {
                    channel.shutdownNow();
                    latch.countDown();
                }
            };

            var stub = this.createStub(channel);
            stub.read1(Grpc.Read1Request.newBuilder().setAddr(register).build(), responseStreamObserver);
        }
        Long[] longArray = new Long[2];
        try {
            latch.await(3, TimeUnit.SECONDS);
            if (arrayList.size() > 0) {
                longArray = getMaxLabel(arrayList);
//                System.out.println(longArray[1] + "(" + longArray[0] + ")");
            } else {
                System.out.println("failed");
                System.exit(0);
            }
        } catch (InterruptedException e) {
            System.out.println("failed");
            throw new RuntimeException(e);
        }


        // R2
        CountDownLatch R2latch = new CountDownLatch(majority);

        for(String server : servers) {
            ManagedChannel channel = getChannel(server);

            StreamObserver<Grpc.Read2Response> responseStreamObserver = new StreamObserver<>() {

                @Override
                public void onNext(Grpc.Read2Response read2Response) {
                }

                @Override
                public void onError(Throwable throwable) {
                    System.out.println("failed");
                    channel.shutdownNow();
                }

                @Override
                public void onCompleted() {
                    R2latch.countDown();
                    channel.shutdownNow();
                }
            };

                var stub = this.createStub(channel);
                stub.read2(Grpc.Read2Request.newBuilder().setAddr(longArray[1]).setLabel(longArray[0]).build(), responseStreamObserver);

        }

            try {
                R2latch.await(3, TimeUnit.SECONDS);
                if (R2latch.getCount() == 0)
                    System.out.println(longArray[1] + "(" + longArray[0] + ")");
//                    System.out.println("success");
                else
                    System.out.println("failed");

            } catch (InterruptedException e) {
//                System.out.println("failed");
                System.out.println("failed");
                throw new RuntimeException(e);
            }

    }
    private Long[] getMaxLabel(ArrayList<Long[]> arrayList) {
        Long[] max = new Long[2];
        max[0] = Long.MIN_VALUE;
        for (Long[] arr : arrayList) {
            if (arr[0] > max[0]) {
                max[0] = arr[0];
                max[1] = arr[1];
            }
        }
        return max;
    }

    private ManagedChannel getChannel(String serverAddress) {
        var lastColon = serverAddress.lastIndexOf(':');
        var host = serverAddress.substring(0, lastColon);
        var port = Integer.parseInt(serverAddress.substring(lastColon + 1));
        return ManagedChannelBuilder
                .forAddress(host, port)
                .usePlaintext()
                .build();
    }

    private ABDServiceGrpc.ABDServiceStub createStub(ManagedChannel channel) {
        return ABDServiceGrpc.newStub(channel);
    }

}
