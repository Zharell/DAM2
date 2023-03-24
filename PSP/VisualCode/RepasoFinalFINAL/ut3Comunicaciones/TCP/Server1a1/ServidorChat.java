package RepasoFinalFINAL.ut3Comunicaciones.TCP.Server1a1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServidorChat {

    private static final String MENSAJE_BIENVENIDA="Bienvenido al servidor";
    public static final String MENSAJE_DESPEDIDA="ByeServer";
    private static Scanner sc = new Scanner(System.in);

        public static void main(String[] args) {
        ServerSocket server;
        int port = Integer.parseInt(args[0]);

        try {

            server = new ServerSocket(port);
            System.out.println("Escuchando puerto: "+port);

            while (true) {

                //Acepta petición de cliente
                Socket socketaCliente = server.accept();

                //Muestra en el servidor quien ha entrado
                System.out.println("Ha entrado al chat: "+socketaCliente.getInetAddress());

                //Multihilo
                new Thread ( () -> {

                    entablarComunicacion(socketaCliente);

                }).start();

                
            }
            

            
        } catch(IOException x){
            x.getStackTrace();
        }

    }

    public static void entablarComunicacion(Socket socketaCliente) {

        try {
            //Para leer el cliente
            DataOutputStream outTCP = new DataOutputStream(socketaCliente.getOutputStream());
            
            //Para escribir al cliente
            DataInputStream inTCP = new DataInputStream(socketaCliente.getInputStream());

            outTCP.writeUTF(MENSAJE_BIENVENIDA);
            outTCP.flush();

            String mensaje="";
            do {

                //Lee mensaje del cliente
                mensaje = inTCP.readUTF();
                System.out.println("Cliente "+socketaCliente.getInetAddress()+" dice: "+mensaje);
                
                //Pide por teclado para enviar al cliente
                System.out.println("Que deseas enviar al cliente?");
                mensaje = sc.nextLine();

                //Luego lo envía
                outTCP.writeUTF(mensaje);
                outTCP.flush();

            } while (!mensaje.equalsIgnoreCase(MENSAJE_DESPEDIDA));


            inTCP.close();
            outTCP.close();
            socketaCliente.close();

        } catch (IOException x) {
            x.getStackTrace();

        }
    }
}
