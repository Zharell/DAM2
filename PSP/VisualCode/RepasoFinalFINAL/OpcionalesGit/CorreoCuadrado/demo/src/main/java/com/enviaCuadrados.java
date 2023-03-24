package com;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class enviaCuadrados {
    public static void main(String[] args) {
        
        //Desde launch.json introducimos los parámetros
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        String dirMail = args[2];

        //Explícame como ejecutar con visual un código java que espera parámetros en args

        String cuadrado = crearCuadrado(num1, num2);
        
        enviarCorreo(cuadrado, dirMail);


    }

    private static void enviarCorreo (String cuadrado, String dirMail) {

        try {
            Email email = new SimpleEmail();
            
            email.setHostName("smtp.educa.madrid.org");
            email.setSmtpPort(587);
            
            email.setAuthentication(Sp.getPalabra().get(0), Sp.getPalabra().get(1));
            email.setStartTLSEnabled(true);

            email.setFrom("tuquieremipingaentuculo@educa.madrid.org");
            email.setSubject("El cuadrado amarillo");
            email.setMsg(cuadrado);

            email.addTo("francisco.lopez82@educa.madrid.org");
            email.send();

            System.out.println("Correo enviado papi");
        } catch (EmailException f) {
            f.getStackTrace();
        }

    }

    private static String crearCuadrado(int num1, int num2) {
        String cuadrado="";
        for (int i = 0; i < num1; i++) {
            for (int j = 0; j < num2; j++) {
                if (i == 0 || i == (num1 - 1) || j == 0 || j == (num2 - 1)) { 
                    cuadrado+="* ";
                } else {                                                      
                    cuadrado+="  ";
                } 
            } 
            cuadrado+="\n";
        } 
        return cuadrado;
    } 

}
