import java.net.*;
import java.io.*;

public class ExternalNode {
    public static void main(String[] args) throws Exception {
        // Create a Socket to connect to the coordinator node
        Socket socket = new Socket("localhost", 5000);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        // Send a message to the coordinator node
        String message = "Hello, multicast group!";
        out.writeUTF(message);

        // Close the connection
        socket.close();
    }
}