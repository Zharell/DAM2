package EVA2.java.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClienteUdp {
    

    public static void main(String[] args) {
        
        try( DatagramSocket ds = new DatagramSocket();) {
            
            byte [] buffer = "Hola mundo".getBytes();
         
            DatagramPacket p = new DatagramPacket(buffer
                                                    ,buffer.length
                                                    ,InetAddress.getLocalHost()
                                                    ,8881
                                                 );
            do {
                ds.send(p);

            } while (true);
            
        } catch (SocketException e) {
            e.printStackTrace();
        }  catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
