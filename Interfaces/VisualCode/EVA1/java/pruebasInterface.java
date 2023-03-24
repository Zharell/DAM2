package Interfaces;
import java.awt.*;
import java.util.Scanner;

public class pruebasInterface {
    public static void main(String[] args) {
        
        Scanner lc = new Scanner(System.in);

        String [] nombresFuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

        boolean fuente = false;
        System.out.println("Introduce la fuente");
        String fuenteIntro = lc.nextLine();

        for (String nombredeFuentes : nombresFuentes) {
            System.out.println(nombredeFuentes);
            if (nombredeFuentes.equalsIgnoreCase(fuenteIntro)) {
                fuente=true;
            }
        }


    }
}
