package Interfaces;
import javax.swing.*;
import java.awt.*;

public class escribiendoMarco {
    public static void main(String[] args) {
        
        MarcoConTexto miMarco = new MarcoConTexto();

        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


}

class MarcoConTexto extends JFrame {

    public MarcoConTexto () {
        
        setVisible(true);

        setSize(600,450);

        setLocation(400,200);

        setTitle("Primer Texto");
        
        lamina miLamina = new lamina();

        add(miLamina);
    }


}


class lamina extends JPanel{

    public void paintComponent (Graphics g) {
        
        super.paintComponent(g);

        g.drawString("Hola Mundo", 100, 100);

    }

}