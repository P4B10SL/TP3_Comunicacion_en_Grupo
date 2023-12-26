package multicast;
import java.net.*;
import java.io.*;

public class CoordinatorNode {
    public static void main(String[] args) throws Exception {
        // Creación del ServerSocket para recibir mensajes de los nodos externos
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            // Creación del MulticastSocket para enviar mensajes a los nodos del grupo
            try (MulticastSocket multicastSocket = new MulticastSocket()) {
                InetAddress groupAddress = InetAddress.getByName("239.255.0.1");

                while (true) {
                    // Esperar a que un nodo externo se conecte
                    try (Socket socket = serverSocket.accept();
                         DataInputStream in = new DataInputStream(socket.getInputStream())) {

                        // Leer el mensaje del nodo externo
                        String message = in.readUTF();

                        // Enviar el mensaje a los nodos del grupo
                        byte[] buffer = message.getBytes();
                        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, groupAddress, 5001);
                        multicastSocket.send(packet);
                    }
                    // Cierre del socket
                }
            }
        }
    }
}
