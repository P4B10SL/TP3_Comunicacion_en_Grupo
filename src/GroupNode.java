import java.net.*;

public class GroupNode {
    public static void main(String[] args) throws Exception {
        InetAddress groupAddress = InetAddress.getByName("224.0.0.1");
        NetworkInterface networkInterface = NetworkInterface.getByName("eth0"); // replace with your network interface

        // Use try-with-resources to ensure the MulticastSocket is closed when it's no longer needed
        try (MulticastSocket multicastSocket = new MulticastSocket(5001)) {
            multicastSocket.joinGroup(new InetSocketAddress(groupAddress, 5001), networkInterface);

            while (true) {
                // Receive a message from the coordinator node
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                multicastSocket.receive(packet);

                // Print the message
                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received message: " + message);
            }
        }
    }
}