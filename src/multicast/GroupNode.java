package multicast;
import java.net.*;

public class GroupNode {
    public static void main(String[] args) throws Exception {
        InetAddress groupAddress = InetAddress.getByName("239.255.0.1"); //Direccion multicast elegida
        NetworkInterface networkInterface = NetworkInterface.getByName("Radmin VPN"); // Cambiar por "Wi-Fi" o "Ethernet" segun sea necesario

        try (MulticastSocket multicastSocket = new MulticastSocket(5001)) {
            multicastSocket.joinGroup(new InetSocketAddress(groupAddress, 5001), networkInterface);

            while (true) {
                //Recepcion del mensaje del nodo coordinador
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                multicastSocket.receive(packet);

                // Mostrar el mensaje por consola
                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received message: " + message);
            }
        }
    }
}