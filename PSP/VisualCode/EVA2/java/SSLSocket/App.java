package EVA2.java.SSLSocket;

import java.io.*;
import java.util.Base64;
import java.util.regex.Matcher;
import javax.net.ssl.SSLSocketFactory;
import java.net.Socket;


import java.util.regex.Pattern;

public class App {

    public static int NOMBRE_USUARIO = 3;
    public static int PASSWORD_USUARIO = 4;
    public static int DOMINIO_USUARIO = 5;
    private static final String DIR="www.cual-es-mi-ip.net";
    private static final String FREE_DNS = "freedns.afraid.org";
    private static final int PORT_SSL = 443;
    private static Pattern pattern = Pattern.compile("El IP [0-9\\.]* ");
    private static Matcher matcher;

    public static void main(String[] args) throws Exception {
        
        //Obtiene la nueva IP
        String newIp = obtenerIP();

        //Asignar al dominio nueva IP
        asignarIP(newIp);

    }


    //Método que obtiene la nueva IP
    public static String obtenerIP () throws IOException {

        //Se crea el Socket SSL
        SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        Socket socket = sslsocketfactory.createSocket(DIR, PORT_SSL);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("GET / HTTP/1.1");
        out.println("Host: "+DIR);
        out.println();
        String newIP="";

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) {

            matcher = pattern.matcher(inputLine);
            while (matcher.find()) {
                System.out.println(matcher.group());
                newIP = matcher.group().replace("El IP ","");
            }
            
        }
        in.close();
        out.close();
        socket.close();
        return newIP;
    }

    //Método que asigna la nueva IP al dominio
    public static void asignarIP(String newIP) throws IOException {

        //Creamos el socket SSL asignamos el dominio y el puerto (normalmente: 443)
        SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        Socket socket = sslsocketfactory.createSocket(FREE_DNS,PORT_SSL);
        
        //Creamos la conexión para enviar la petición
        PrintWriter outDNS = new PrintWriter(socket.getOutputStream(),true);

        //Creamos la conexión para recibir la petición
        BufferedReader inDNS = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        //Se debe codificar las credenciales
        String credenciales=Sp.getPalabra().get(NOMBRE_USUARIO)+":"+Sp.getPalabra().get(PASSWORD_USUARIO);

        String credencialesCodificadas = Base64.getEncoder().encodeToString(credenciales.getBytes());

        //Realización de petición 
        outDNS.print("GET /nic/update?hostname="+Sp.getPalabra().get(DOMINIO_USUARIO)+"&myip="+newIP+" HTTP/1.1\r\n");
        outDNS.print("Host: "+FREE_DNS+"\r\n");
        outDNS.print("Authorization: Basic "+credencialesCodificadas+"\r\n");
        outDNS.print("\r\n");
        outDNS.flush();

        //Comprobar la respuesta a ver si mamamos o no
        String lineaRespuesta;
        int finBucle = 0;
        while ((lineaRespuesta = inDNS.readLine()) != null ) {
            System.out.println(lineaRespuesta);

            //Comprueba que ha terminado la petición para terminar el bucle
            //En la respuesta de la petición hay muchas líneas vacías
            if (lineaRespuesta.equalsIgnoreCase("")) {
                finBucle++;
                if (finBucle==3) {
                    break;
                }
            }
        }

        System.out.println("Se ha realizado el cambio de IP");
        inDNS.close();
        outDNS.close();
        socket.close();
    }


}




