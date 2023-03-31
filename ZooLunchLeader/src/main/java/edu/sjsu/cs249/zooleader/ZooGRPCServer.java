package edu.sjsu.cs249.zooleader;

import edu.sjsu.cs249.zooleader.Zoo;
import edu.sjsu.cs249.zooleader.ZooLunchGrpc;
import io.grpc.stub.StreamObserver;

import java.util.Objects;

/**
 * @author ashish
 */
public class ZooGRPCServer extends ZooLunchGrpc.ZooLunchImplBase {
    /**
     * <pre>
     * request an audit of the last or current lunch situation
     * </pre>
     *
     * @param request
     * @param responseObserver
     */

    Persister persister;
    String zooNodeName;

    ZooManager zooManager;

    ZooGRPCServer(Persister persister,String zooNodeName, ZooManager zooManager){
        this.persister = persister;
        this.zooNodeName = "zk-"+zooNodeName;
        this.zooManager = zooManager;
    }

    @Override
    public void goingToLunch(Zoo.GoingToLunchRequest request, StreamObserver<Zoo.GoingToLunchResponse> responseObserver)  {
        System.out.println("goingToLunch Called");
        Zoo.GoingToLunchResponse response = Zoo.GoingToLunchResponse.newBuilder().build();
        LunchPerk lunchMap = persister.getLunch();
        Lunch prevLunch = lunchMap.getLastLunch();

        if(prevLunch != null) {
            System.out.println("prev lunch is " + prevLunch);
            if (prevLunch.isLeader) {
                response = Zoo.GoingToLunchResponse.newBuilder()
                        .setRc(0) //// 0 - if current lunch leader, 1 - if not current lunch leader
                        .setLeader(prevLunch.lunchLeader)
                        .addAllAttendees(prevLunch.lunchMates)
                        .setRestaurant("NIRVANA SOUL!")
                        .build();
            }
            else {
                System.out.println("Not the leader.. setting rc1 and returning response object");
                response = Zoo.GoingToLunchResponse.newBuilder().setRc(1).build();
            }
        }
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * <pre>
     * request an audit of the last or current lunch situation
     * </pre>
     *
     * @param request
     * @param responseObserver
     */
    @Override
    public void lunchesAttended(Zoo.LunchesAttendedRequest request, StreamObserver<Zoo.LunchesAttendedResponse> responseObserver) {
        Zoo.LunchesAttendedResponse response = Zoo.LunchesAttendedResponse.newBuilder()
                .addAllZxids(persister.getLunch().lunches.keySet()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * <pre>
     * request an audit of the last or current lunch situation
     * </pre>
     *
     * @param request
     * @param responseObserver
     */
    @Override
    public void getLunch(Zoo.GetLunchRequest request, StreamObserver<Zoo.GetLunchResponse> responseObserver) {
        Zoo.GetLunchResponse response;
        LunchPerk lunchPerk = persister.getLunch();
        Lunch lunch = lunchPerk.lunches.getOrDefault(request.getZxid(),null);
//        Lunch lunch = lunchPerk.lunches.getOrDefault(request.getZxid(),null);

        System.out.println("Get lunch called");
        int rc = lunch.isLeader ? 0 : 1;

        if(Objects.isNull(lunch)){
            response = Zoo.GetLunchResponse.newBuilder()
                    .setRc(2)
                    .build();
        } else if(lunch.isLeader){
            response = Zoo.GetLunchResponse.newBuilder()
                    .setRc(rc)
                    .setLeader(lunch.lunchLeader)
                    .addAllAttendees(lunch.lunchMates)
                    .setRestaurant("NIRVANA SOUL!")
                    .build();
        } else {
            response = Zoo.GetLunchResponse.newBuilder()
                    .setRc(rc)
                    .setLeader(lunch.lunchLeader)
                    .build();
        }

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    /**
     * <pre>
     * skip the next readyforlunch announcement
     * </pre>
     *
     * @param request
     * @param responseObserver
     */
    @Override
    public void skipLunch(Zoo.SkipRequest request, StreamObserver<Zoo.SkipResponse> responseObserver) {
        System.out.println("Received skipLunch");
        zooManager.isSkipEnabled = request.isInitialized();
        System.out.println("Set to skip next Lunch");
        responseObserver.onNext(Zoo.SkipResponse.newBuilder().build());
        responseObserver.onCompleted();
    }

    /**
     * <pre>
     * exit your process right away
     * </pre>
     *
     * @param request
     * @param responseObserver
     */
    @Override
    public void exitZoo(Zoo.ExitRequest request, StreamObserver<Zoo.ExitResponse> responseObserver) {
        Zoo.ExitResponse exitResponse = Zoo.ExitResponse.newBuilder().build();
        zooManager.startZooKeeper();
        System.exit(0);
        responseObserver.onNext(exitResponse);
        responseObserver.onCompleted();
    }

}
