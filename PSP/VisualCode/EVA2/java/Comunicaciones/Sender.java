package EVA2.java.Comunicaciones;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Sender {

    public static String MENSAJE_ENVIAR = "Hola amigo\n";
    public static void main(String[] args) {
    
        try {
            Socket con = new Socket("192.168.20.203", 1221);
            //con el socket puedo escribir y leer, inputstream outputstream 
            BufferedOutputStream out= new BufferedOutputStream(con.getOutputStream());
            
            for (int i=0;i<args.length;i++) {
                out.write(args[i].getBytes());
            }
            out.close();
            con.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
