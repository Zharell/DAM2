package com.example.pantallalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.io.Serializable;

import java.io.Serializable;

public class LoginApp extends AppCompatActivity {

    EditText ECorreo,EPassword;
    Button ELogin,ERegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asigno IDs a las variables
        ECorreo = findViewById(R.id.ECorreo);
        EPassword = findViewById(R.id.EPassword);
        ELogin = findViewById(R.id.ELogin);
        ERegistro = findViewById(R.id.ERegistro);

        //Método que se activa al hacer click en el botón LOGIN
        ELogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Método validar explicado más abajo
                validarEnviar();
            }
        });

        //Método que se activa al hacer click en el botón SIGN UP
        ERegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Método validar explicado más abajo
                validarEnviar();
            }
        });
    }

    //Método que valida los datos introducidos
        // 1 - Extrae los datos introducidos en los EditText
        // 2 - Si no es correcto, pinta de rojo el fallo
        // 3 - Si ha validado, envía a otra actividad

    public void validarEnviar() {
        String Correo = String.valueOf(ECorreo.getText());
        String Password = String.valueOf(EPassword.getText());
        boolean validado=true;
        if (Correo.equalsIgnoreCase("javier@gmail.com")) {
        } else {
            ECorreo.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
            validado=false;
        }
        if (Password.equalsIgnoreCase("123")) {
        } else {
            EPassword.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
            validado=false;
        }

        if (validado==true) {

            //Crea el objeto viaje el cual enviaremos a la segunda actividad
            Login objetoLogin = new Login(Correo,Password);

            //Utilizamos la clase Intent para enviar información de una actividad a otra
            Intent envioLogin = new Intent(this,recibidoraLogin.class);

            //Utilizamos el objeto Intent para enviar, implementando la clase Serializable que permite
            //Enviar OBJETOS de una actividad a otra
            envioLogin.putExtra("EnvioLogin",(Serializable) objetoLogin);
            startActivity(envioLogin);

        }

    }


}