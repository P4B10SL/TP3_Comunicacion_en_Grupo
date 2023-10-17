import java.awt.image.DataBufferInt;
import java.io.DataInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
       SistemaComunicaciones Coms= new SistemaComunicaciones();
        try {
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

        }
        catch (IOException e)
        {
            System.out.print("Error al ingresar el mensaje");
            System.out.print(e);
        }
    }

}