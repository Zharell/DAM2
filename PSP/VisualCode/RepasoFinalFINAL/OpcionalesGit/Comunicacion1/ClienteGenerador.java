package RepasoFinalFINAL.OpcionalesGit.Comunicacion1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteGenerador {

    private static Scanner sc = new Scanner(System.in);

    private static final String FINALIZAR_CALCULADORA = "BYE";
    public static void main(String[] args) {
        
        //Introducimos información del servidor
        String ip = args[0];
        int port = Integer.parseInt(args[1]);

        //Instanciamos objeto socket y de comunicación
        try (
                Socket socketCliente = new Socket(ip,port);
                DataInputStream inTCP = new DataInputStream(socketCliente.getInputStream());
                DataOutputStream outTCP = new DataOutputStream(socketCliente.getOutputStream())
            ) 
        {
            //Lee mensaje de bienvenida
            System.out.println(inTCP.readUTF());

            String mensaje="";
            while (!mensaje.equals(FINALIZAR_CALCULADORA)) {

                //Envío
                System.out.println("Cual numero deseas comprobar?");
                mensaje = sc.nextLine();
                outTCP.writeUTF(mensaje);
                outTCP.flush();

                //Recibe el resultado
                System.out.println(inTCP.readUTF());


            }

        } catch (UnknownHostException e) {
            e.getStackTrace();
        } catch (IOException x) {
            x.getStackTrace();
        }

    }

}
