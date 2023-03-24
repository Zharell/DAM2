package com.example.marfolnew;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import login.Login;

public class participantes_full extends AppCompatActivity implements View.OnClickListener {
    ImageView btnLogin;
    ImageView btnPagar,btnVolver;
    ActivityResultLauncher launcher;
    //public static int VOLVER =10;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participantes_full);
        getSupportActionBar().hide();

        //Se asigna valor a la variable
        btnLogin = findViewById(R.id.btnLoguearse3);
        btnPagar = findViewById(R.id.btnPagarFactura2);
        btnVolver = findViewById(R.id.btnVolver3);

        //Se implementa el escuchador en el propio doc
        btnLogin.setOnClickListener(this);
        btnPagar.setOnClickListener(this);
        btnVolver.setOnClickListener(this);

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
                });
    }


    @Override
    public void onClick(View v) {
        actividad(v.getId());
    }

    private void actividad(int opciones) {
        switch (opciones) {
            case R.id.btnLoguearse3:
                intent = new Intent(getApplicationContext(), login.Login.class);
                launcher.launch(intent);
                break;
            case R.id.btnPagarFactura2:
                intent = new Intent(this, Principal.class);
                launcher.launch(intent);
                break;
            case R.id.btnVolver3:
                intent = new Intent(this, Principal.class);
                launcher.launch(intent);
                finish();
                break;
        }
    }
}