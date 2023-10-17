import java.awt.image.DataBufferInt;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Main {
    public static void main(String[] args) {
       SistemaComunicaciones Coms= new SistemaComunicaciones();
        try {
            /*
            DataInputStream ipConsola;
            //String ipDestino= "172.24.1.15";
            System.out.println("Ingrese la dirección IP a la que se desea conectar:");
            ipConsola=new DataInputStream(System.in);
            String ipDestino=ipConsola.readLine();
            Coms.init(ipDestino);
            System.out.println("Ingrese el mensaje a enviar:");
            DataInputStream mensajeEnviar = new DataInputStream(System.in);
            String mensaje = mensajeEnviar.readLine();
            //String respuesta = Coms.Send(mensaje);
            //System.out.println(respuesta);
            //String respuesta2= Coms.Receive();
            //System.out.println(respuesta2);
            String respuestaSocketTCP=Coms.SendTCP(mensaje);    //Descomentar esta línea y la de abajo para probar el Socket TCP
            System.out.println(respuestaSocketTCP);
            //String respuestaServerTCP=Coms.ReceiveTCP2();      //Descomentar esta línea y la de abajo para probar el Server TCP
            //System.out.println(respuestaServerTCP);

*/
            /*
            //Codigo de Bard para el Multicast ---SERVIDOR
            MulticastSocket multicastSocket = new MulticastSocket(733);

            // Crea las direcciones de grupo para cada nodo
            InetAddress nodo1 = InetAddress.getByName("224.0.0.1");
            InetAddress nodo2 = InetAddress.getByName("224.0.0.2");

            // Une cada nodo al grupo de difusión
            multicastSocket.joinGroup(nodo1);
            multicastSocket.joinGroup(nodo2);

            // Envia un mensaje al grupo
            String mensaje2 = "Hola, mundo!";
            byte[] buffer = mensaje2.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length, nodo1, 733);
            multicastSocket.send(datagramPacket);
            // Cierra el socket de difusión
           // multicastSocket.close();

            //CODIGO CLIENTE DE BARD
            // Crea un socket de difusión
            MulticastSocket multicastSocketCliente = new MulticastSocket(733);

            // Une el socket al grupo de difusión
            multicastSocketCliente.joinGroup(InetAddress.getByName("224.0.0.1"));

            // Se queda escuchando mensajes
            while (true) {
                byte[] buffer2 = new byte[1024];
                DatagramPacket datagramPacket2 = new DatagramPacket(buffer2, buffer2.length);
                multicastSocketCliente.receive(datagramPacket2);
                // Imprime el mensaje recibido
                String mensaje3 = new String(datagramPacket2.getData(), 0, datagramPacket2.getLength());
                System.out.println(mensaje3);
            }

*/
            //CODIGO CLIENTE DE BARD CLIENTE 2
            // Crea un socket de difusión
            MulticastSocket multicastSocketCliente = new MulticastSocket(733);

            // Une el socket al grupo de difusión
            multicastSocketCliente.joinGroup(InetAddress.getByName("224.0.0.2"));

            // Se queda escuchando mensajes
            while (true) {
                byte[] buffer2 = new byte[1024];
                DatagramPacket datagramPacket2 = new DatagramPacket(buffer2, buffer2.length);
                multicastSocketCliente.receive(datagramPacket2);
                // Imprime el mensaje recibido
                String mensaje3 = new String(datagramPacket2.getData(), 0, datagramPacket2.getLength());
                System.out.println(mensaje3);
            }

            // Cierra el socket de difusión
            //multicastSocketCliente.close();
        }
        catch (IOException e)
        {
            System.out.print("Error al ingresar el mensaje");
            System.out.print(e);
        }
    }

}