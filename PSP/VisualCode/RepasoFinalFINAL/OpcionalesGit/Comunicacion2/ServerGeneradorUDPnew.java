package RepasoFinalFINAL.OpcionalesGit.Comunicacion2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ServerGeneradorUDPnew {

    private static final byte BUFFER_SERVER [] = new byte [63535];
    private static final String MENSAJE_BIENVENIDA = "Bienvenido al server renovado";
    private static final String MENSAJE_APAGADO = "ApagateServer";
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
        int port = Integer.parseInt("8888");
        System.out.println("Escuchando en el puerto: "+port);
        try (
                DatagramSocket ds = new DatagramSocket(port);
            )
        {

            //Creamos un paquete para obtener el puerto y el InetAddress del cliente
            DatagramPacket paqueteCliente = new DatagramPacket(BUFFER_SERVER, port);
            ds.receive(paqueteCliente);

            //Obtenemos datos del cliente
            int portClient = paqueteCliente.getPort();
            InetAddress addressClient = paqueteCliente.getAddress();
            ds.close();

            System.out.println("El cliente: "+addressClient+" ha accedido al servidor");

            //Instanciamos el socketServer
            SocketUDPServer socketUDPServer = new SocketUDPServer(portClient, addressClient);

            System.out.println("Server escuchando en el puerto: "+socketUDPServer.getPort());

            //Enviamos el mensaje de bienvenida
            socketUDPServer.enviarMensaje(MENSAJE_BIENVENIDA);

            String mensajeCliente = "";
            do {

                //Recibimos respuesta
                mensajeCliente = socketUDPServer.recibirMensaje();
                System.out.println(mensajeCliente);
                
                //Enviamos respuesta
                socketUDPServer.enviarMensaje(sc.nextLine());

                //Enviamos en el caso del que el servidor se apague
                if (mensajeCliente.equalsIgnoreCase(MENSAJE_APAGADO)) {
                    socketUDPServer.enviarMensaje("Servidor apagado");
                }

            } while (!mensajeCliente.equalsIgnoreCase(MENSAJE_APAGADO));

        } catch (IOException x) {
            x.getStackTrace();
        }



    }


}
