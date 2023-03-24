package EVA2.java.UDP.BroadCast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClienteBroadCast {
    

    public static void main(String[] args) {
        
        try( DatagramSocket ds = new DatagramSocket();) {
            ds.setBroadcast(true);

            byte [] buffer = "Hola mundo".getBytes();
            String ip ="255.255.255.255";
            DatagramPacket p = new DatagramPacket(buffer
                                                    ,buffer.length
                                                    ,InetAddress.getByName(ip)
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
