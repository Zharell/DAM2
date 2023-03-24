package Interfaces;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import javax.imageio.*;
import java.io.*;
import java.util.Observer;

public class imagenInterfaces {
    public static void main(String[] args) {
        
        marcoImagen miImage = new marcoImagen();
        miImage.setVisible(true);
        miImage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}


class marcoImagen extends JFrame {
    public marcoImagen() {
        setTitle("Imagen");
        setBounds(750,300,300,300);
        
        laminaImage nuevaLamina = new laminaImage();

        add(nuevaLamina);

    }
}

class laminaImage extends JPanel {
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        try {
            imagen=ImageIO.read(new File("Tidus.png"));
        } catch (IOException E) {
            System.out.println("NO encontró la imagen");
        }

        g.drawImage(imagen,5,5,null);

    }

    

    private Image imagen;

}

