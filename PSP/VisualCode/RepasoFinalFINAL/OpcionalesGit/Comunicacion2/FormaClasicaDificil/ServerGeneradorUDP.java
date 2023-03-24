package RepasoFinalFINAL.OpcionalesGit.Comunicacion2.FormaClasicaDificil;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ServerGeneradorUDP {

    private static final int MAX_LENGTH = 63535;
    //private static final String MENSAJE_SALIR = "bye";
    private static final String MENSAJE_BIENVENIDA = "Bienvenido a la calculadora de Primos - UDP - \n";
    public static void main(String[] args) {

        //Puerto del servidor
        //int port = Integer.parseInt(args[0]);
        int port = 8888;

        //Información del cliente
        int portCliente;
        InetAddress addressCliente;

        //Buffer utilizados 
        byte bufferServer[] = new byte[MAX_LENGTH];

        try (
            DatagramSocket ds = new DatagramSocket(port)
            ) 
        {

            //Para poder dar el mensaje de bienvenida se requiere recibir información del cliente
            DatagramPacket paquete = new DatagramPacket(bufferServer, bufferServer.length);
            ds.receive(paquete);

            //Obtengo información del cliente
            portCliente = paquete.getPort();
            addressCliente = paquete.getAddress();
            System.out.println("Ha entrado al servidor "+addressCliente);
            
            //Damos la bienvenida
            bufferServer = MENSAJE_BIENVENIDA.getBytes();
            paquete = new DatagramPacket(bufferServer, bufferServer.length, addressCliente, portCliente);
            ds.send(paquete);

            String msgServer="";
            while (true) {
                
                //Recibo el número del cliente
                paquete = new DatagramPacket(bufferServer, bufferServer.length);
                ds.receive(paquete);

                //Convierte en información leíble y tratable
                msgServer = new String (paquete.getData(),0,paquete.getLength()).replace("\n","");
                int num = Integer.parseInt(msgServer);

                //Contestamos respuesta
                if (esPrimo(num)) {

                    //Construimos el mensaje
                    msgServer = "Se considera primo el numero: "+num+"\n";
                    bufferServer = msgServer.getBytes();

                    //Creamos el paquete y enviamos
                    paquete = new DatagramPacket(bufferServer, bufferServer.length, addressCliente, portCliente);
                    ds.send(paquete);
                } else {

                    //Construimos el mensaje
                    msgServer = "No se considera primo el numero: "+num+"\n";
                    bufferServer = msgServer.getBytes();

                    //Creamos el paquete y enviamos
                    paquete = new DatagramPacket(bufferServer, bufferServer.length, addressCliente, portCliente);
                    ds.send(paquete);
                }

            }

        } catch (IOException x) {
            x.getStackTrace();
        }
    }

    //Analizador de primos
    public static boolean esPrimo(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }


}
