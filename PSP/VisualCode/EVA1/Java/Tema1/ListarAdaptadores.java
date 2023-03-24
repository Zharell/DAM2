package PSP.Tema1;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ListarAdaptadores {
        public static void main(String[] args) throws IOException {
            
           
            Process p = new ProcessBuilder("bash", "-c", "ifconfig").start();
            
            String cadena = " ";
            try {
    
                InputStream is = p.getInputStream();
                
                // mostramos en pantalla caracter a caracter
                 int c;
                 String varL="";
                 while ((c = is.read()) != -1){
                   // System.out.print((char) c);
                    varL+=(char)c;
                 }
                 
                String [] adaptadores = varL.split(" ");
                 for (int i=0;i<adaptadores.length-1;i++) {
                    if (adaptadores[i].equalsIgnoreCase("enp3s0:")) {
                        System.out.print(adaptadores[i]+" ");
                    }
                    if (adaptadores[i].equalsIgnoreCase("50:b7:c3:91:d3:8c")) {
                        System.out.println(adaptadores[i]);
                    }
                    
                    
                 }
                
                is.close();
                 
            } catch (Exception e) {
                e.printStackTrace();
            }
    
            // COMPROBACION DE ERROR - 0 bien - 1 mal
            int exitVal;
            try {
                exitVal = p.waitFor();
                System.out.println("Valor de Salida: " + exitVal);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }// Ejemplo2