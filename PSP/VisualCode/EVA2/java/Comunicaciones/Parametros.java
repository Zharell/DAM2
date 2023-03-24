package EVA2.java.Comunicaciones;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Parametros {
    public static void main(String[] args) {
        System.out.println("Lista de parámetros");
        for (String s : args){
            System.out.println(String.format("\tParámetro %s", s));
        }
    }
}
