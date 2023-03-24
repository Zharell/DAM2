package RepasoFinalFINAL.OpcionalesGit.Comunicacion2;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;

public class ClienteGeneradorUDP {

    private static final String MENSAJE_SALIR = "bye";

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        //String ip = args[0];
        //int port = Integer.parseInt(args[1]);

        String ip = "localhost";
        int port = Integer.parseInt("8889");

        //Variable que utilizamos para enviar
        String msg="10 10 x";

        try (
                DatagramSocket ds = new DatagramSocket();
            ) 
        {

            //Creamos el objeto que se conectará
            SocketUDP conexionCliente = new SocketUDP(port, ip);

            //Enviamos el mensaje para que el servidor nos reconozca
            conexionCliente.enviarMensaje(msg);

            //Leemos la bienvenida
            msg = conexionCliente.recibirMensaje();
            System.out.println(msg);

            System.out.println("Usando puerto: "+conexionCliente.getPort());

            while (!msg.equalsIgnoreCase(MENSAJE_SALIR)) {

                //Método que envía información al servidor
                msg = sc.nextLine();
                conexionCliente.enviarMensaje(msg);

                //Recibe el resultado
                System.out.println(conexionCliente.recibirMensaje());

            }
            conexionCliente.cerrar();
            System.out.println("La comunicación se ha cerrado");
        } catch (SocketException x) {
            x.getStackTrace();
        } catch (IOException f) {
            f.getStackTrace();
        }

    }

}
