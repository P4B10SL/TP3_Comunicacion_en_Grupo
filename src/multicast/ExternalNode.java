package multicast;
import java.net.*;
import java.io.*;

public class ExternalNode {
    public static void main(String[] args) throws Exception {
        //Creación del Socket para conectarse al nodo Coordinador
        Socket socket = new Socket("localhost", 5000); //LocalHost se reemplaza con la IP del coordinador en caso de que no se ejecute en la misma máquina
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        // Envío de un mensaje al nodo Coordinador
        String message = "Prueba de Mensaje Multicast Enviado desde un Nodo Externo hacia el coordinador";
        out.writeUTF(message);

        // Cierre del socket
        socket.close();
    }
}