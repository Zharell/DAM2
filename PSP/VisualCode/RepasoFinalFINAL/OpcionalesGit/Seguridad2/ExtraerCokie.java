package RepasoFinalFINAL.OpcionalesGit.Seguridad2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

public class ExtraerCokie {

    private static final int USER_NAME = 0;
    private static final int USER_PASS = 1;
    private static final String DIR_WEB = "aulavirtual33.educa.madrid.org";
    private static final int PORT_SSL = 443;

    public static void main(String[] args) {
        
        String cookie = obtenerCookie();


    }

    private static String obtenerCookie() {
        
        //Creamos la conexión a través de un socket seguro ssl / tsl
        SSLSocketFactory socketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        try (Socket socket = socketFactory.createSocket(DIR_WEB, PORT_SSL)) {

            //Para leer la respuesta
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //Para realizar la petición POST
            PrintWriter outSSL = new PrintWriter(socket.getOutputStream());

            //Construimos la petición y la enviamos
            String peticion = "username=" + Sp.getPalabra().get(USER_NAME) + "&password=" + Sp.getPalabra().get(USER_PASS);
            outSSL.print("POST /ies.juandelacierva.madrid/login/index.php HTTP/1.1\r\n");
            outSSL.print("Host: "+DIR_WEB+"\r\n");
            outSSL.print("Content-Type: application/x-www-form-urlencoded\r\n");
            outSSL.print("Content-Length: "+peticion.length()+"\r\n");
            outSSL.print("Connection: close\r\n");
            outSSL.print("\r\n");
            outSSL.print(peticion);
            outSSL.flush();

            String cookie="",linea;
            while ((linea = input.readLine()) != null) {
                System.out.println(linea);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
        return null;
    }

}
