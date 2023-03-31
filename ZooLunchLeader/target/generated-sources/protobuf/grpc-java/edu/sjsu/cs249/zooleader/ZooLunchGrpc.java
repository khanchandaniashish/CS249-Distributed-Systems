package edu.sjsu.cs249.zooleader;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.53.0)",
    comments = "Source: zoo.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ZooLunchGrpc {

  private ZooLunchGrpc() {}

  public static final String SERVICE_NAME = "edu.sjsu.cs249.zooleader.ZooLunch";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<edu.sjsu.cs249.zooleader.Zoo.GoingToLunchRequest,
      edu.sjsu.cs249.zooleader.Zoo.GoingToLunchResponse> getGoingToLunchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "goingToLunch",
      requestType = edu.sjsu.cs249.zooleader.Zoo.GoingToLunchRequest.class,
      responseType = edu.sjsu.cs249.zooleader.Zoo.GoingToLunchResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.sjsu.cs249.zooleader.Zoo.GoingToLunchRequest,
      edu.sjsu.cs249.zooleader.Zoo.GoingToLunchResponse> getGoingToLunchMethod() {
    io.grpc.MethodDescriptor<edu.sjsu.cs249.zooleader.Zoo.GoingToLunchRequest, edu.sjsu.cs249.zooleader.Zoo.GoingToLunchResponse> getGoingToLunchMethod;
    if ((getGoingToLunchMethod = ZooLunchGrpc.getGoingToLunchMethod) == null) {
      synchronized (ZooLunchGrpc.class) {
        if ((getGoingToLunchMethod = ZooLunchGrpc.getGoingToLunchMethod) == null) {
          ZooLunchGrpc.getGoingToLunchMethod = getGoingToLunchMethod =
              io.grpc.MethodDescriptor.<edu.sjsu.cs249.zooleader.Zoo.GoingToLunchRequest, edu.sjsu.cs249.zooleader.Zoo.GoingToLunchResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "goingToLunch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.sjsu.cs249.zooleader.Zoo.GoingToLunchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.sjsu.cs249.zooleader.Zoo.GoingToLunchResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ZooLunchMethodDescriptorSupplier("goingToLunch"))
              .build();
        }
      }
    }
    return getGoingToLunchMethod;
  }

  private static volatile io.grpc.MethodDescriptor<edu.sjsu.cs249.zooleader.Zoo.LunchesAttendedRequest,
      edu.sjsu.cs249.zooleader.Zoo.LunchesAttendedResponse> getLunchesAttendedMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "lunchesAttended",
      requestType = edu.sjsu.cs249.zooleader.Zoo.LunchesAttendedRequest.class,
      responseType = edu.sjsu.cs249.zooleader.Zoo.LunchesAttendedResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.sjsu.cs249.zooleader.Zoo.LunchesAttendedRequest,
      edu.sjsu.cs249.zooleader.Zoo.LunchesAttendedResponse> getLunchesAttendedMethod() {
    io.grpc.MethodDescriptor<edu.sjsu.cs249.zooleader.Zoo.LunchesAttendedRequest, edu.sjsu.cs249.zooleader.Zoo.LunchesAttendedResponse> getLunchesAttendedMethod;
    if ((getLunchesAttendedMethod = ZooLunchGrpc.getLunchesAttendedMethod) == null) {
      synchronized (ZooLunchGrpc.class) {
        if ((getLunchesAttendedMethod = ZooLunchGrpc.getLunchesAttendedMethod) == null) {
          ZooLunchGrpc.getLunchesAttendedMethod = getLunchesAttendedMethod =
              io.grpc.MethodDescriptor.<edu.sjsu.cs249.zooleader.Zoo.LunchesAttendedRequest, edu.sjsu.cs249.zooleader.Zoo.LunchesAttendedResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "lunchesAttended"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.sjsu.cs249.zooleader.Zoo.LunchesAttendedRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.sjsu.cs249.zooleader.Zoo.LunchesAttendedResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ZooLunchMethodDescriptorSupplier("lunchesAttended"))
              .build();
        }
      }
    }
    return getLunchesAttendedMethod;
  }

  private static volatile io.grpc.MethodDescriptor<edu.sjsu.cs249.zooleader.Zoo.GetLunchRequest,
      edu.sjsu.cs249.zooleader.Zoo.GetLunchResponse> getGetLunchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getLunch",
      requestType = edu.sjsu.cs249.zooleader.Zoo.GetLunchRequest.class,
      responseType = edu.sjsu.cs249.zooleader.Zoo.GetLunchResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.sjsu.cs249.zooleader.Zoo.GetLunchRequest,
      edu.sjsu.cs249.zooleader.Zoo.GetLunchResponse> getGetLunchMethod() {
    io.grpc.MethodDescriptor<edu.sjsu.cs249.zooleader.Zoo.GetLunchRequest, edu.sjsu.cs249.zooleader.Zoo.GetLunchResponse> getGetLunchMethod;
    if ((getGetLunchMethod = ZooLunchGrpc.getGetLunchMethod) == null) {
      synchronized (ZooLunchGrpc.class) {
        if ((getGetLunchMethod = ZooLunchGrpc.getGetLunchMethod) == null) {
          ZooLunchGrpc.getGetLunchMethod = getGetLunchMethod =
              io.grpc.MethodDescriptor.<edu.sjsu.cs249.zooleader.Zoo.GetLunchRequest, edu.sjsu.cs249.zooleader.Zoo.GetLunchResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getLunch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.sjsu.cs249.zooleader.Zoo.GetLunchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.sjsu.cs249.zooleader.Zoo.GetLunchResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ZooLunchMethodDescriptorSupplier("getLunch"))
              .build();
        }
      }
    }
    return getGetLunchMethod;
  }

  private static volatile io.grpc.MethodDescriptor<edu.sjsu.cs249.zooleader.Zoo.SkipRequest,
      edu.sjsu.cs249.zooleader.Zoo.SkipResponse> getSkipLunchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "skipLunch",
      requestType = edu.sjsu.cs249.zooleader.Zoo.SkipRequest.class,
      responseType = edu.sjsu.cs249.zooleader.Zoo.SkipResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.sjsu.cs249.zooleader.Zoo.SkipRequest,
      edu.sjsu.cs249.zooleader.Zoo.SkipResponse> getSkipLunchMethod() {
    io.grpc.MethodDescriptor<edu.sjsu.cs249.zooleader.Zoo.SkipRequest, edu.sjsu.cs249.zooleader.Zoo.SkipResponse> getSkipLunchMethod;
    if ((getSkipLunchMethod = ZooLunchGrpc.getSkipLunchMethod) == null) {
      synchronized (ZooLunchGrpc.class) {
        if ((getSkipLunchMethod = ZooLunchGrpc.getSkipLunchMethod) == null) {
          ZooLunchGrpc.getSkipLunchMethod = getSkipLunchMethod =
              io.grpc.MethodDescriptor.<edu.sjsu.cs249.zooleader.Zoo.SkipRequest, edu.sjsu.cs249.zooleader.Zoo.SkipResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "skipLunch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.sjsu.cs249.zooleader.Zoo.SkipRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.sjsu.cs249.zooleader.Zoo.SkipResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ZooLunchMethodDescriptorSupplier("skipLunch"))
              .build();
        }
      }
    }
    return getSkipLunchMethod;
  }

  private static volatile io.grpc.MethodDescriptor<edu.sjsu.cs249.zooleader.Zoo.ExitRequest,
      edu.sjsu.cs249.zooleader.Zoo.ExitResponse> getExitZooMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "exitZoo",
      requestType = edu.sjsu.cs249.zooleader.Zoo.ExitRequest.class,
      responseType = edu.sjsu.cs249.zooleader.Zoo.ExitResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<edu.sjsu.cs249.zooleader.Zoo.ExitRequest,
      edu.sjsu.cs249.zooleader.Zoo.ExitResponse> getExitZooMethod() {
    io.grpc.MethodDescriptor<edu.sjsu.cs249.zooleader.Zoo.ExitRequest, edu.sjsu.cs249.zooleader.Zoo.ExitResponse> getExitZooMethod;
    if ((getExitZooMethod = ZooLunchGrpc.getExitZooMethod) == null) {
      synchronized (ZooLunchGrpc.class) {
        if ((getExitZooMethod = ZooLunchGrpc.getExitZooMethod) == null) {
          ZooLunchGrpc.getExitZooMethod = getExitZooMethod =
              io.grpc.MethodDescriptor.<edu.sjsu.cs249.zooleader.Zoo.ExitRequest, edu.sjsu.cs249.zooleader.Zoo.ExitResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "exitZoo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.sjsu.cs249.zooleader.Zoo.ExitRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  edu.sjsu.cs249.zooleader.Zoo.ExitResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ZooLunchMethodDescriptorSupplier("exitZoo"))
              .build();
        }
      }
    }
    return getExitZooMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ZooLunchStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ZooLunchStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ZooLunchStub>() {
        @java.lang.Override
        public ZooLunchStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ZooLunchStub(channel, callOptions);
        }
      };
    return ZooLunchStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ZooLunchBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ZooLunchBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ZooLunchBlockingStub>() {
        @java.lang.Override
        public ZooLunchBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ZooLunchBlockingStub(channel, callOptions);
        }
      };
    return ZooLunchBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ZooLunchFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ZooLunchFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ZooLunchFutureStub>() {
        @java.lang.Override
        public ZooLunchFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ZooLunchFutureStub(channel, callOptions);
        }
      };
    return ZooLunchFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ZooLunchImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * request an audit of the last or current lunch situation
     * </pre>
     */
    public void goingToLunch(edu.sjsu.cs249.zooleader.Zoo.GoingToLunchRequest request,
        io.grpc.stub.StreamObserver<edu.sjsu.cs249.zooleader.Zoo.GoingToLunchResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGoingToLunchMethod(), responseObserver);
    }

    /**
     * <pre>
     * request an audit of the last or current lunch situation
     * </pre>
     */
    public void lunchesAttended(edu.sjsu.cs249.zooleader.Zoo.LunchesAttendedRequest request,
        io.grpc.stub.StreamObserver<edu.sjsu.cs249.zooleader.Zoo.LunchesAttendedResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLunchesAttendedMethod(), responseObserver);
    }

    /**
     * <pre>
     * request an audit of the last or current lunch situation
     * </pre>
     */
    public void getLunch(edu.sjsu.cs249.zooleader.Zoo.GetLunchRequest request,
        io.grpc.stub.StreamObserver<edu.sjsu.cs249.zooleader.Zoo.GetLunchResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetLunchMethod(), responseObserver);
    }

    /**
     * <pre>
     * skip the next readyforlunch announcement
     * </pre>
     */
    public void skipLunch(edu.sjsu.cs249.zooleader.Zoo.SkipRequest request,
        io.grpc.stub.StreamObserver<edu.sjsu.cs249.zooleader.Zoo.SkipResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSkipLunchMethod(), responseObserver);
    }

    /**
     * <pre>
     * exit your process right away
     * </pre>
     */
    public void exitZoo(edu.sjsu.cs249.zooleader.Zoo.ExitRequest request,
        io.grpc.stub.StreamObserver<edu.sjsu.cs249.zooleader.Zoo.ExitResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExitZooMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGoingToLunchMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                edu.sjsu.cs249.zooleader.Zoo.GoingToLunchRequest,
                edu.sjsu.cs249.zooleader.Zoo.GoingToLunchResponse>(
                  this, METHODID_GOING_TO_LUNCH)))
          .addMethod(
            getLunchesAttendedMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                edu.sjsu.cs249.zooleader.Zoo.LunchesAttendedRequest,
                edu.sjsu.cs249.zooleader.Zoo.LunchesAttendedResponse>(
                  this, METHODID_LUNCHES_ATTENDED)))
          .addMethod(
            getGetLunchMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                edu.sjsu.cs249.zooleader.Zoo.GetLunchRequest,
                edu.sjsu.cs249.zooleader.Zoo.GetLunchResponse>(
                  this, METHODID_GET_LUNCH)))
          .addMethod(
            getSkipLunchMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                edu.sjsu.cs249.zooleader.Zoo.SkipRequest,
                edu.sjsu.cs249.zooleader.Zoo.SkipResponse>(
                  this, METHODID_SKIP_LUNCH)))
          .addMethod(
            getExitZooMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                edu.sjsu.cs249.zooleader.Zoo.ExitRequest,
                edu.sjsu.cs249.zooleader.Zoo.ExitResponse>(
                  this, METHODID_EXIT_ZOO)))
          .build();
    }
  }

  /**
   */
  public static final class ZooLunchStub extends io.grpc.stub.AbstractAsyncStub<ZooLunchStub> {
    private ZooLunchStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ZooLunchStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ZooLunchStub(channel, callOptions);
    }

    /**
     * <pre>
     * request an audit of the last or current lunch situation
     * </pre>
     */
    public void goingToLunch(edu.sjsu.cs249.zooleader.Zoo.GoingToLunchRequest request,
        io.grpc.stub.StreamObserver<edu.sjsu.cs249.zooleader.Zoo.GoingToLunchResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGoingToLunchMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * request an audit of the last or current lunch situation
     * </pre>
     */
    public void lunchesAttended(edu.sjsu.cs249.zooleader.Zoo.LunchesAttendedRequest request,
        io.grpc.stub.StreamObserver<edu.sjsu.cs249.zooleader.Zoo.LunchesAttendedResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLunchesAttendedMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * request an audit of the last or current lunch situation
     * </pre>
     */
    public void getLunch(edu.sjsu.cs249.zooleader.Zoo.GetLunchRequest request,
        io.grpc.stub.StreamObserver<edu.sjsu.cs249.zooleader.Zoo.GetLunchResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLunchMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * skip the next readyforlunch announcement
     * </pre>
     */
    public void skipLunch(edu.sjsu.cs249.zooleader.Zoo.SkipRequest request,
        io.grpc.stub.StreamObserver<edu.sjsu.cs249.zooleader.Zoo.SkipResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSkipLunchMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * exit your process right away
     * </pre>
     */
    public void exitZoo(edu.sjsu.cs249.zooleader.Zoo.ExitRequest request,
        io.grpc.stub.StreamObserver<edu.sjsu.cs249.zooleader.Zoo.ExitResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExitZooMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ZooLunchBlockingStub extends io.grpc.stub.AbstractBlockingStub<ZooLunchBlockingStub> {
    private ZooLunchBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ZooLunchBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ZooLunchBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * request an audit of the last or current lunch situation
     * </pre>
     */
    public edu.sjsu.cs249.zooleader.Zoo.GoingToLunchResponse goingToLunch(edu.sjsu.cs249.zooleader.Zoo.GoingToLunchRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGoingToLunchMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * request an audit of the last or current lunch situation
     * </pre>
     */
    public edu.sjsu.cs249.zooleader.Zoo.LunchesAttendedResponse lunchesAttended(edu.sjsu.cs249.zooleader.Zoo.LunchesAttendedRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLunchesAttendedMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * request an audit of the last or current lunch situation
     * </pre>
     */
    public edu.sjsu.cs249.zooleader.Zoo.GetLunchResponse getLunch(edu.sjsu.cs249.zooleader.Zoo.GetLunchRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLunchMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * skip the next readyforlunch announcement
     * </pre>
     */
    public edu.sjsu.cs249.zooleader.Zoo.SkipResponse skipLunch(edu.sjsu.cs249.zooleader.Zoo.SkipRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSkipLunchMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * exit your process right away
     * </pre>
     */
    public edu.sjsu.cs249.zooleader.Zoo.ExitResponse exitZoo(edu.sjsu.cs249.zooleader.Zoo.ExitRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExitZooMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ZooLunchFutureStub extends io.grpc.stub.AbstractFutureStub<ZooLunchFutureStub> {
    private ZooLunchFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ZooLunchFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ZooLunchFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * request an audit of the last or current lunch situation
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.sjsu.cs249.zooleader.Zoo.GoingToLunchResponse> goingToLunch(
        edu.sjsu.cs249.zooleader.Zoo.GoingToLunchRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGoingToLunchMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * request an audit of the last or current lunch situation
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.sjsu.cs249.zooleader.Zoo.LunchesAttendedResponse> lunchesAttended(
        edu.sjsu.cs249.zooleader.Zoo.LunchesAttendedRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLunchesAttendedMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * request an audit of the last or current lunch situation
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.sjsu.cs249.zooleader.Zoo.GetLunchResponse> getLunch(
        edu.sjsu.cs249.zooleader.Zoo.GetLunchRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLunchMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * skip the next readyforlunch announcement
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.sjsu.cs249.zooleader.Zoo.SkipResponse> skipLunch(
        edu.sjsu.cs249.zooleader.Zoo.SkipRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSkipLunchMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * exit your process right away
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<edu.sjsu.cs249.zooleader.Zoo.ExitResponse> exitZoo(
        edu.sjsu.cs249.zooleader.Zoo.ExitRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExitZooMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GOING_TO_LUNCH = 0;
  private static final int METHODID_LUNCHES_ATTENDED = 1;
  private static final int METHODID_GET_LUNCH = 2;
  private static final int METHODID_SKIP_LUNCH = 3;
  private static final int METHODID_EXIT_ZOO = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ZooLunchImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ZooLunchImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GOING_TO_LUNCH:
          serviceImpl.goingToLunch((edu.sjsu.cs249.zooleader.Zoo.GoingToLunchRequest) request,
              (io.grpc.stub.StreamObserver<edu.sjsu.cs249.zooleader.Zoo.GoingToLunchResponse>) responseObserver);
          break;
        case METHODID_LUNCHES_ATTENDED:
          serviceImpl.lunchesAttended((edu.sjsu.cs249.zooleader.Zoo.LunchesAttendedRequest) request,
              (io.grpc.stub.StreamObserver<edu.sjsu.cs249.zooleader.Zoo.LunchesAttendedResponse>) responseObserver);
          break;
        case METHODID_GET_LUNCH:
          serviceImpl.getLunch((edu.sjsu.cs249.zooleader.Zoo.GetLunchRequest) request,
              (io.grpc.stub.StreamObserver<edu.sjsu.cs249.zooleader.Zoo.GetLunchResponse>) responseObserver);
          break;
        case METHODID_SKIP_LUNCH:
          serviceImpl.skipLunch((edu.sjsu.cs249.zooleader.Zoo.SkipRequest) request,
              (io.grpc.stub.StreamObserver<edu.sjsu.cs249.zooleader.Zoo.SkipResponse>) responseObserver);
          break;
        case METHODID_EXIT_ZOO:
          serviceImpl.exitZoo((edu.sjsu.cs249.zooleader.Zoo.ExitRequest) request,
              (io.grpc.stub.StreamObserver<edu.sjsu.cs249.zooleader.Zoo.ExitResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ZooLunchBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ZooLunchBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return edu.sjsu.cs249.zooleader.Zoo.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ZooLunch");
    }
  }

  private static final class ZooLunchFileDescriptorSupplier
      extends ZooLunchBaseDescriptorSupplier {
    ZooLunchFileDescriptorSupplier() {}
  }

  private static final class ZooLunchMethodDescriptorSupplier
      extends ZooLunchBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ZooLunchMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ZooLunchGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ZooLunchFileDescriptorSupplier())
              .addMethod(getGoingToLunchMethod())
              .addMethod(getLunchesAttendedMethod())
              .addMethod(getGetLunchMethod())
              .addMethod(getSkipLunchMethod())
              .addMethod(getExitZooMethod())
              .build();
        }
      }
    }
    return result;
  }
}
