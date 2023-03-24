package com.example.pantallalogin;

import java.io.Serializable;

//Clase objeto que almacena nombre y correo, lo envía de una actividad a otra
public class Login implements Serializable {

    String correo,password;

    public Login (String correo,String password) {
        this.correo=correo;
        this.password=password;
    }

    //Método que devuelve la información del objeto
    @Override
    public String toString() {
        return
                "Correo: " + correo + "\n"+"\n" +
                "Password: " + password;
    }
}
