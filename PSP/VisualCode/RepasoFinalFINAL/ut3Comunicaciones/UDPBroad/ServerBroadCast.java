package RepasoFinalFINAL.ut3Comunicaciones.UDPBroad;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ServerBroadCast {

    private static final int MAX_LENGTH = 63535;
    private static final String MENSAJE_BIENVENIDA = "Enviando en BroadCast \n";
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {

        //Puerto del servidor
        //int port = Integer.parseInt(args[0]);
        int port = 8888;

        //Información del cliente
        String direccionIP;

        //Buffer utilizados 
        byte bufferServer[] = new byte[MAX_LENGTH];

        try (
                DatagramSocket ds = new DatagramSocket(port)
            ) 
        {

            //Activamos el BroadCast
            ds.setBroadcast(true);

            //Asignamos port y direccion Broadcast
            direccionIP = "192.168.1.255";
            System.out.println("Enviando en BroadCast en la dirección "+direccionIP);

            String msgServer="";
            while (true) {
                

                //Envío BroadCast
                msgServer = sc.nextLine();
                bufferServer = msgServer.getBytes();
                DatagramPacket paquete = new DatagramPacket(bufferServer, bufferServer.length, InetAddress.getByName(direccionIP), port);
                ds.send(paquete);
                
                System.out.println("El paquete enviado en BroadCast en la direccion: "+paquete.getAddress()+"/");

                //Recibo cualquier respuesta
                paquete = new DatagramPacket(bufferServer, bufferServer.length);
                ds.receive(paquete);

                System.out.println("El cliente: "+paquete.getAddress()+"/ ha respondido");

                //Convierte en información leíble y tratable
                msgServer = new String (paquete.getData(),0,paquete.getLength()).replace("\n","");
                System.out.println(msgServer);
                
            }

        } catch (IOException x) {
            x.getStackTrace();
        }

    }

}
