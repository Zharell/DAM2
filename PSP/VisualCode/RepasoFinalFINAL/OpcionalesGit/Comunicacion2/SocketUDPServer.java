package RepasoFinalFINAL.OpcionalesGit.Comunicacion2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class SocketUDPServer {
    private DatagramSocket socket;
    private InetAddress inetAdressCliente;
    private int port;
    private int MAX_LENGTH = 63535;

    public SocketUDPServer(int port, InetAddress inetAdress) throws SocketException {
        try {
            this.socket = new DatagramSocket(port);
            this.inetAdressCliente = inetAdress;
            this.port = port;
        } catch (SocketException e) {
            System.out.println("PUERTO USADO, ASIGNANDO OTRO");
            this.socket = new DatagramSocket();
            this.inetAdressCliente = inetAdress;
            this.port = port;
        }
    }

    public void enviarMensaje(String message) throws IOException {
        byte[] buffer = message.getBytes();
        DatagramPacket p = new DatagramPacket(buffer, buffer.length, inetAdressCliente, port);
        this.socket.send(p);
    }

    public String recibirMensaje() throws IOException {
        byte[] buffer = new byte[MAX_LENGTH];
        DatagramPacket p = new DatagramPacket(buffer, MAX_LENGTH);
        this.socket.receive(p);
        return new String(p.getData(), 0, p.getLength());
    }

    public void cerrar() {
        this.socket.close();
    }

    public int getPort() {
        return port;
    }

}
