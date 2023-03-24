package PSP.Tema2;

import javax.swing.JLabel;

public class Contador implements Runnable {
    private static final long INTERVALO =100;
    JLabel _salida,_salidaJuego;
    private int segundos=0,minutos=0,horas=0;
    String cadenaTiempo="";

    public Contador(JLabel salida,JLabel salidajogo){
        _salida=salida;
        _salidaJuego=salidajogo;
    }
    @Override
    public void run() {
    
        while (true){
            String cadenaTiempo="";
            if (horas<=9) {
                cadenaTiempo+="0"+horas+":";
            } else {
                cadenaTiempo+=horas+":";
            }
            if (minutos<=9) {
                cadenaTiempo+="0"+minutos+":";
            } else {
                cadenaTiempo+=minutos+":";
            }
            if (segundos<=9) {
                cadenaTiempo+="0"+segundos;
            } else {
                cadenaTiempo+=segundos;
            }
            
            cadenaArmado();
            temporizador();

            _salida.setText(cadenaTiempo);


            try {
                
                Thread.sleep(INTERVALO);

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

            }
        }

        

    }

    public void cadenaArmado(){
        cadenaTiempo="";
            if (horas<=9) {
                cadenaTiempo+="0"+horas+":";
            } else {
                cadenaTiempo+=horas+":";
            }
            if (minutos<=9) {
                cadenaTiempo+="0"+minutos+":";
            } else {
                cadenaTiempo+=minutos+":";
            }
            if (segundos<=9) {
                cadenaTiempo+="0"+segundos;
            } else {
                cadenaTiempo+=segundos;
            }
    }

    public void temporizador () {
        segundos++;
        if (segundos==60) {
            minutos++;
            segundos=0;
        }
        if (minutos==60) {
            horas++;
            minutos=0;
        }
        if (horas==60) {
            horas=0;
        }
    }
    
    public void reiniciarContador () {
        minutos=horas=segundos=0;
        cadenaArmado();
        _salida.setText(cadenaTiempo);
        _salidaJuego.setText(" - ");
    }
    
    public void miniJuego () {
        if (segundos==11) {
            _salidaJuego.setText("golaso macakiño");
        } else {
            if (segundos==16) {
                _salidaJuego.setText("Penalti");
            } else {
                if (segundos==21) {
                    _salidaJuego.setText("otra cosa");
                }
            }
        }
    }

}