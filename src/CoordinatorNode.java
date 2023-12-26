import java.net.*;
import java.io.*;

public class CoordinatorNode {
    public static void main(String[] args) throws Exception {
        // Create a ServerSocket to receive messages from external sources
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            // Create a MulticastSocket to send messages to the multicast group
            try (MulticastSocket multicastSocket = new MulticastSocket()) {
                InetAddress groupAddress = InetAddress.getByName("239.255.0.1");

                while (true) {
                    // Accept a connection from an external source
                    try (Socket socket = serverSocket.accept();
                         DataInputStream in = new DataInputStream(socket.getInputStream())) {

                        // Read the message
                        String message = in.readUTF();

                        // Forward the message to the multicast group
                        byte[] buffer = message.getBytes();
                        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, groupAddress, 5001);
                        multicastSocket.send(packet);
                    }
                    // 'socket' is closed automatically due to try-with-resources
                }
            }
        }
    }
}
