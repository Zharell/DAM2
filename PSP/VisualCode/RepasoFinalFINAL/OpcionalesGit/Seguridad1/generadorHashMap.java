package RepasoFinalFINAL.OpcionalesGit.Seguridad1;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Scanner;

public class generadorHashMap {

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Introduce cadena");
        String cadena = args[0];
        String cadenaHash = args[1];
        
        try {

            //Creamos el HashMap (clave : valor)
            HashMap<String, String> mapHash = new HashMap<>();

            //Almacenamos en el HashMap la cadena normal y convertida
            mapHash.put(cadena,cadenaHash);

            String compruebaHash = "";
            for (String key : mapHash.keySet()) {
                
                //Comprueba si es hash, envía clave del HashMap y comprueba
                compruebaHash = comprobarHash(key);

                if (compruebaHash.equals(mapHash.get(key))) {
                    
                    //La cadena MD5 es legítima
                    System.out.println("El hash de la cadena: "+cadena+" es correcto y es el siguiente: "+cadenaHash);
                } else {
                    System.out.println("El hash de la cadena: "+cadena+" no es correcto y es el siguiente: "+compruebaHash);
                }

            }
        
        } catch (NoSuchAlgorithmException x) {
            x.getStackTrace();
        }

    }

    public static String comprobarHash (String cadenaHash) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte [] messageDigest = md.digest(cadenaHash.getBytes());

        StringBuilder sb = new StringBuilder();
        for (byte b : messageDigest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }


}
