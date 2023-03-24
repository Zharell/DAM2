package RepasoFinalFINAL.ut3Comunicaciones.TCP.Server1a1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteChat {
    private static final String MENSAJE_DESPEDIDA ="bye";
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        String ip = args[0];
        int port = Integer.parseInt(args[1]);
        
        try {

            Socket connServer = new Socket(ip,port);

            //Para escribir el server
            DataOutputStream outTCP = new DataOutputStream(connServer.getOutputStream());
        
            //Para leer al server
            DataInputStream inTCP = new DataInputStream(connServer.getInputStream());

            //Lee el mensaje de bienvenida del servidor
            System.out.println(inTCP.readUTF());

            String mensaje="";
            String mensajeServer="";
            do {

                //Creo el mensaje
                System.out.println("Escribe al servidor");
                mensaje = sc.nextLine();

                //Se lo envío
                outTCP.writeUTF(mensaje);
                outTCP.flush();

                //Recibo respuesta
                mensajeServer = inTCP.readUTF();
                System.out.println(mensajeServer);

            } while (!mensaje.equalsIgnoreCase(MENSAJE_DESPEDIDA));

            inTCP.close();
            outTCP.close();
            connServer.close();
        } catch (UnknownHostException h) {
            h.getStackTrace();

        } catch (IOException h) {
            h.getStackTrace();

        }
    

    }
}
