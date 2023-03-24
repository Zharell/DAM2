import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class prueba {
   public static void main(String[] args) {
      // Crear un nuevo marco
      JFrame marco = new JFrame("Interfaz sencilla");
      marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      marco.setSize(300, 100);
      marco.setLayout(new BorderLayout());

      // Crear dos botones
      JButton boton1 = new JButton("Botón 1");
      JButton boton2 = new JButton("Botón 2");

      // Añadir los botones al marco en la zona inferior
      marco.add(boton1, BorderLayout.WEST);
      marco.add(boton2, BorderLayout.EAST);

      // Mostrar el marco
      marco.setVisible(true);
   }
}







