package RepasoFinalFINAL.OpcionalesGit.Comunicacion1;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerGenerador {
    
    private static final String MENSAJE_SALIR = "bye";
    private static final String MENSAJE_INICIO = "Bienvenido a la calculadora de primos";
    public static void main(String[] args) {
        
        int port = Integer.parseInt(args[0]);

        try ( ServerSocket socketServer = new ServerSocket(port) ) {
            
            System.out.println("Calculadora de primos escuchando en: "+port);
            
            while (true) {

                Socket conCliente = socketServer.accept();

                new Thread (() -> {

                    detectorPrimo(conCliente);
                    
                }).start();
            }

        } catch (IOException e) {
            e.getStackTrace();
        }

    }


    public static void detectorPrimo (Socket conCliente) {
        int num=0;
        try (
            DataOutputStream outTCP = new DataOutputStream(conCliente.getOutputStream());
            DataInputStream inTCP = new  DataInputStream(conCliente.getInputStream());
            ) 
        {

            //Da la bienvenida
            outTCP.writeUTF(MENSAJE_INICIO);
            outTCP.flush();

            String msg="";
            while (!msg.equalsIgnoreCase(MENSAJE_SALIR)) {

                //Obtengo el valor de un número introducido
                num = Integer.parseInt(inTCP.readUTF());
            
                if (esPrimo(num)) {

                    //Si es true es primo
                    outTCP.writeUTF("Es un numero primo: "+String.valueOf(num));
                    outTCP.flush();

                } else {

                    //No es primo
                    outTCP.writeUTF("No es un numero primo: "+String.valueOf(num));
                    outTCP.flush();

                }

            }


        } catch (IOException i) {
            i.getStackTrace();
        }


    }

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
