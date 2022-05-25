package com.knoldus.server;

import com.knoldus.service.UserService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GRPCServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        int portNumber = 8080;
        Server server = ServerBuilder.forPort(portNumber).addService(new UserService()).build();
        server.start();
        System.out.println("Server started on port: " + portNumber);

        server.awaitTermination();
    }
}
