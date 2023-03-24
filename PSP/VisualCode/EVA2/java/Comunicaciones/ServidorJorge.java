package EVA2.java.Comunicaciones;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorJorge {

    public static void main(String[] args) {
        
        ServerSocket server;

        int port = Integer.parseInt(args[0]);
        String msg = args[1]+"\n";


        try {

            server = new ServerSocket(port);
            System.out.println("\nEscuchando el puerto: "+port);

            // Acepta conexiones de clientes de manera continua
            while (true) {
                Socket connCliente = server.accept();

                // Envia mensaje al cliente
                DataOutputStream out = new DataOutputStream(connCliente.getOutputStream());
                out.write(msg.getBytes());
                out.flush();

                // Recibe mensaje del cliente
                DataInputStream input = new DataInputStream(connCliente.getInputStream());
                byte[] info = input.readAllBytes();
                String cadena = new String(info);
                System.out.println("Cliente nos manda: "+ cadena);

                // Responde al cliente
                DataOutputStream outToClient = new DataOutputStream(connCliente.getOutputStream());
                outToClient.writeUTF("Mensaje recibido. Gracias.");
                outToClient.flush();

                out.close();
                input.close();
                connCliente.close();
            }
        } catch (Exception x) {
            x.getStackTrace();
        }
    }
}

