import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.knoldus.grpc.User;
import com.knoldus.grpc.userGrpc;

public class GRPCClient {

 public static void main(String[] args){

     ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext().build();

     //stub from proto file

     userGrpc.userBlockingStub stub =  userGrpc.newBlockingStub(channel);

     User.loginRequest request = User.loginRequest.newBuilder().setUserName("Hello").setPassword("Hello").build();

     User.APIResponse response = stub.login(request);

     System.out.println("Response : "+ response.getResponse());

 }

}
