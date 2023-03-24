package Interfaces;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

public class figuras {
    public static void main(String[] args) {
        
        marcoDibujos miMarco =new marcoDibujos();

        miMarco.setVisible(true);
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }



}


class marcoDibujos extends JFrame{
    public marcoDibujos() {
        setTitle("Prueba de dibujo");
        setSize(400,400);

        laminaDibujos miLamina = new laminaDibujos();

        add(miLamina);

        miLamina.setForeground(Color.red);
    }
}


class laminaDibujos extends JPanel{

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        
        //g.drawRect(20, 20, 200, 200);
        //g.drawLine(100,100,300,200);
        //g.drawArc(50,100,100,200,120,150);

        Graphics2D g2 = (Graphics2D) g;

        Rectangle2D rectangulo = new Rectangle2D.Double(100,100,200,200);
        //Rectangle2D rectangulo2 = new Rectangle2D.Double(110,90,250,220);
        
        //Pinta el cuadrado
        g2.setPaint(Color.PINK);
        g2.fill(rectangulo);
        //

        Ellipse2D ellipse = new Ellipse2D.Double();
        ellipse.setFrame(rectangulo);
        g2.setPaint(new Color(161,255,252).brighter().darker());
        //g2.draw(ellipse);
        g2.fill(ellipse);

        //g2.draw(new Line2D.Double(100,100,300,250));

        //Punto central
        double CentroenX = rectangulo.getCenterX();
        double CentroenY= rectangulo.getCenterY();
        double radio=150;
        
        Ellipse2D circulo = new Ellipse2D.Double();
        circulo.setFrameFromCenter(CentroenX,CentroenY,CentroenX+radio,CentroenY+radio);
        
        //g2.draw(circulo);

        //font letras
        Font miFuente = new Font("Arial",Font.BOLD,26);
        g2.setColor(Color.BLUE);
        g2.setFont(miFuente);
        g2.drawString("Juan",90,90);
        g2.setFont(new Font("Arial",Font.ITALIC,14));
        g2.setColor(new Color(128,90,50));
        g2.drawString("Curso de java",70,70);

    }

}