package EVA2.java.Comunicaciones;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class holaCliente {

    public static final String MENSAJE_SALIR = "SALIR";

    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String ip = args[0];
        int port = Integer.parseInt(args[1]);
        
        try {

            Socket conn;
            conn = new Socket(ip,port);
            DataOutputStream outTCP = new DataOutputStream(conn.getOutputStream());
            DataInputStream inTCP = new DataInputStream(conn.getInputStream());

            String msg;
            System.out.print("Server dice: "+inTCP.readUTF());

            do {

                msg = sc.nextLine();

                outTCP.writeUTF(msg);

                String msgModificado = inTCP.readUTF();

                System.out.println("El server dice: "+msgModificado);

            } while (msg.equalsIgnoreCase(MENSAJE_SALIR));

            inTCP.close();
            outTCP.close();
            conn.close();
            sc.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       

    }
}
