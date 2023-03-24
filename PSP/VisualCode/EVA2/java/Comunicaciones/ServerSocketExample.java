package EVA2.java.Comunicaciones;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class ServerSocketExample {

    public static int PUERTO_SERVIDOR = 8080;
    public static Scanner sc = new Scanner(System.in);
    public static Socket socket;

        public static void main(String[] args) {

            // Conectar al host y puerto especificado
            try (Socket socket = new Socket("192.168.2.54", 8008)) {
    
                // Crear los objetos de lectura y escritura
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
    
                while(true) {
                    // Leer un mensaje del usuario
                    System.out.print("Mensaje a enviar: ");
                    String message = sc.nextLine();
    
                    // Enviar el mensaje al servidor
                    output.println(message);
    
                    // Leer una respuesta del servidor
                    String respuesta = input.readLine();
                    System.out.println("Servidor: " + respuesta);
                }
            

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
