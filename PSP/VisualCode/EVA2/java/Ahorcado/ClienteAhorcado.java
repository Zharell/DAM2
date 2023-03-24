package EVA2.java.Ahorcado;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteAhorcado {
    
    public static final String MENSAJE_SALIR = "Adios";
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
    
        //Recibirá por parámetros la ip y el puerto
        // 0 = ip - 1 = port
        String ip = args[0];
        int port = Integer.parseInt(args[1]);

        try {

            //Realiza la conexion
            Socket conn = new Socket(ip,port);

            //Encargado de enviar
            DataOutputStream outTCP = new DataOutputStream(conn.getOutputStream());

            //Encargado de leer
            DataInputStream inTCP = new DataInputStream(conn.getInputStream());

            //Cliente lee la bienvenida con
            System.out.println("Server dice: "+inTCP.readUTF());


            String msg="",msgRecibido;
            do {

                //Envía la letra al servidor
                msg = sc.nextLine();
                outTCP.writeUTF(msg);
                outTCP.flush();

                //Muestra el estado de la partida
                msgRecibido = inTCP.readUTF();
                System.out.println(msgRecibido);
                
                //Muestra en pantalla el dibujo del ahorcado
                msgRecibido = inTCP.readUTF();
                System.out.println(msgRecibido);

                //Recibe información sobre si continúa la partida, también muestra resultado final de la partida
                msgRecibido = inTCP.readUTF();
                System.out.println(msgRecibido);

            } while (!msg.equalsIgnoreCase(MENSAJE_SALIR));
            

            //Cerramos todas las conexciones, etc
            inTCP.close();
            outTCP.close();
            conn.close();
            sc.close();
            
        } catch (UnknownHostException h) {
            h.printStackTrace();
        } catch (IOException i) {
            System.out.println("Se cierra el programa");
        };

    }

}
