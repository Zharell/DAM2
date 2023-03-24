package com.example.pantallalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class recibidoraLogin extends AppCompatActivity {

    TextView SLogin;
    Login miLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recibidora_login);

        //TextView que muestra los datos recibidos
        SLogin = findViewById(R.id.SLoginRecibido);

        //Recibe el objeto login con toda la información desde la otra actividad
        miLogin = (Login) getIntent().getSerializableExtra("EnvioLogin");

        //Muestro en pantalla los atributos del objeto
        SLogin.setText(miLogin.toString());



    }
}