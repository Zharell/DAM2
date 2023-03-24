package RepasoFinalFINAL.ut3Comunicaciones.Servicios.Http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.SSLSocketFactory;

public class CambiarDNS {
    
    private static final String WEB_IPP = "www.cual-es-mi-ip.net"; 

    //Matcher / Pattern para filtrar información
    private static Matcher matcher;
    private static Pattern pattern = Pattern.compile("El IP [0-9\\.]* ");

    //SSL / TSL Siempre utilizan el mismo puerto
    private static final int PORT_SSL = 443; 

    public static void main(String[] args) {

        //Accedemos a la página web y extraemos la nueva IP
        String newIp = obtenerIp();

        asignarIp(newIp);

    }

    public static String obtenerIp() {
        
        //Instanciamos el String aquí
        String newIP="";

        //Genero el objeto fábrica de sockets SSL
        SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        try (
            //Creo el socket seguro
            Socket socket = sslSocketFactory.createSocket(WEB_IPP, PORT_SSL);
            ) 
        {

            //Creo el objeto que recibe el texto y es capaz de realizar la petición GET
            PrintWriter outTSL = new PrintWriter(socket.getOutputStream(), true);
            outTSL.println("GET / HTTP/1.1");
            outTSL.println("Host: "+WEB_IPP);
            outTSL.println();

            //Creamos el objeto que recibe la respuesta - Buffered es capaz de leer líneas
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String lineaRecibida = "";
            while ((lineaRecibida = input.readLine()) != null) {

                matcher = pattern.matcher(lineaRecibida);

                while (matcher.find()) {
                    System.out.println(matcher.group());
                    newIP = matcher.group();
                }

            }

            input.close();
            outTSL.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return newIP;
    };

    public static void asignarIp(String newIP){

    };

}
