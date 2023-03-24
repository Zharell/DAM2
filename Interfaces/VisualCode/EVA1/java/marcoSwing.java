package Interfaces;
import java.awt.Frame;

import javax.swing.*;

public class marcoSwing {
    
    public static void main (String [] args) {

        miMarco marco1 = new miMarco ();
        marco1.setVisible(true);
        marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}

class miMarco extends JFrame{

    public miMarco() {
        
        setSize(500,500);

        setLocation(500,500);

        setBounds(550,300,400,400);

        setTitle("Calculadora");

        //setResizable(false);

        //setExtendedState(Frame.MAXIMIZED_BOTH);

    }

   


}
