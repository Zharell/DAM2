package EVA2.java.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServerUdp {
    
    public static int MAX_LENGTH = 65535;
    public static void main(String[] args) {

        try (DatagramSocket ds = new DatagramSocket(8881);) {
            
            byte buffer[] = new byte[MAX_LENGTH];

            DatagramPacket p = new DatagramPacket(
                                            buffer,
                                            MAX_LENGTH
                                                  );
            
            ds.receive(p);
            
            System.out.println(new String(p.getData(),0,p.getLength()));

            

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
