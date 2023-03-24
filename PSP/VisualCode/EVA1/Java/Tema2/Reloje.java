package PSP.Tema2;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.*;

public class Reloje extends JFrame {
    public Reloje(){
        super("Mi primera ventana");
        JLabel l= new JLabel();
        JLabel v=new JLabel();

        l.setText("0");

        v.setText(" - ");
        
        setLayout(new FlowLayout());

        getContentPane().add(l);

        getContentPane().add(v);
        

        JButton b = new JButton("¡Comienza!");
        getContentPane().add(b);

           
        Contador c= new Contador(l,v);
        Thread t= new Thread(c);
        b.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
            if(t.isAlive()){
                t.resume();
            }else{
                t.start();
            }
         }
        });
        JButton bPara = new JButton("¡Para!");
        getContentPane().add(bPara);
        
        bPara.addActionListener(new ActionListener(){
            @Override
                public void actionPerformed(ActionEvent e){
                    c.miniJuego();
                    t.suspend();
                }
        });
        //Botón reinicio
        
        JButton bRestart = new JButton("Reiniciar");
        getContentPane().add(bRestart);
        bRestart.addActionListener(new ActionListener() {
            @Override
                public void actionPerformed(ActionEvent e){
                    c.reiniciarContador();
                }
        });
        

        setSize(500, 400);
        setVisible(true); //
    }
    public static void main(String[] args) {
        new Reloje();
    }
}
