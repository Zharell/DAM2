package EVA2.java.UDP.MultiCasta;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;

public class MultiCastSend {
    public static void main(String[] args) {
        
        

        try {


            MulticastSocket ms = new MulticastSocket();
            InetAddress group = InetAddress.getByName("230.0.0.0");



        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
