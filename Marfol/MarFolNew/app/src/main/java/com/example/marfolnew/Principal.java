package com.example.marfolnew;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import login.Login;
import participantes.ParticipantesVacio;

public class Principal extends AppCompatActivity implements View.OnClickListener {
    ImageView btnLogin;
    ImageView btnPagar;
    ActivityResultLauncher launcher;
    //public static int VOLVER =10;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);
        getSupportActionBar().hide();

        //Se asigna valor a la variable
        btnLogin = findViewById(R.id.btnLoguearse);
        btnPagar = findViewById(R.id.btnPagar);

        //Se implementa el escuchador en el propio doc
        btnLogin.setOnClickListener(this);
        btnPagar.setOnClickListener(this);

        launcher();
    }


    public void launcher() {
        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    if (result.getResultCode() == Login.VOLVER) {
                        Toast.makeText(this, "Vuelta a principal", Toast.LENGTH_SHORT).show();
                    }
                    if (result.getResultCode() == Login.ENTRAR) {
                        Toast.makeText(this, "Login aprobado", Toast.LENGTH_SHORT).show();
                    }
                    if (result.getResultCode() == participantes.ParticipantesLleno.LLENO) {

                    }
                });
    }


    @Override
    public void onClick(View v) {
        actividad(v.getId());
    }

    private void actividad(int opciones) {
        switch (opciones) {
            case R.id.btnLoguearse:
                intent = new Intent(getApplicationContext(), login.Login.class);
                launcher.launch(intent);
                break;
            case R.id.btnPagar:
                intent = new Intent(this, participantes.ParticipantesVacio.class);
                launcher.launch(intent);
                break;
        }
    }
}

