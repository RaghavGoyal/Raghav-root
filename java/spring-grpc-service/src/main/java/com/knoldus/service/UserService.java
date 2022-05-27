package com.knoldus.service;

import com.knoldus.grpc.User;
import com.knoldus.grpc.userGrpc;
import io.grpc.stub.StreamObserver;

public class UserService extends userGrpc.userImplBase {
    @Override
    public void login(User.loginRequest request, StreamObserver<User.APIResponse> responseObserver) {
        String userName = request.getUserName();
        String password = request.getPassword();

        User.APIResponse.Builder response = User.APIResponse.newBuilder();

        if(userName.equals(password)){
            // success
            response.setResponseStatus(200).setResponse("Success");
        } else{
            // failure
            response.setResponseStatus(404).setResponse("Failure");
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(User.Empty request, StreamObserver<User.APIResponse> responseObserver) {
        System.out.println("logout method...");
        User.APIResponse.Builder response = User.APIResponse.newBuilder();
        response.setResponse("logged out.").setResponseStatus(200);
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
