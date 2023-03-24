import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.awt.*;


public class App {

    private static JFrame frame;
    private static JPanel panel;
    private static Container contentPanel;


  public static void main(String[] args) {

    creaVentana();

    

    
  }

    public static void creaVentana() {

        //Creamos la ventana, le damos título e indícamos que el programa debe cerrarse al cerrar la ventana
        frame = new JFrame("First Journey");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500, 400));

        // Crea una imagen vacía
        BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);

        // Asigna la imagen vacía como el icono de la ventana
        frame.setIconImage(image);

        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        frame.add(panel);

        //Hace visible la interfaz
        frame.setVisible(true);
    }
    


}

