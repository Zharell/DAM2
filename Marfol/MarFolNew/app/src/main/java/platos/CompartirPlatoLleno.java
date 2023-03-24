package platos;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.marfolnew.Factura;
import com.example.marfolnew.R;

import login.Login;
import participantes.NuevoParticipante;

public class CompartirPlatoLleno extends AppCompatActivity implements View.OnClickListener {
    ImageView btn45javi,btnLogin,btnAnadirParticipante,btnVolver;
    ActivityResultLauncher launcher;
    public static int VOLVER =120;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compartir_plato_lleno);
        getSupportActionBar().hide();

        //Se asigna valor a la variable
        btnLogin = findViewById(R.id.btnLoguearse);
        btn45javi = findViewById(R.id.btn45javi);
        btnAnadirParticipante= findViewById(R.id.btnAnadirParticipante);
        btnVolver=findViewById(R.id.btnVolver);
        //Se implementa el escuchador en el propio doc
        btnLogin.setOnClickListener(this);
        btn45javi.setOnClickListener(this);
        btnAnadirParticipante.setOnClickListener(this);
        btnVolver.setOnClickListener(this);


        launcher();
    }


    public void launcher() {
        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    if (result.getResultCode() == Login.VOLVER) {
                        Toast.makeText(this, "Vuelta a compartir", Toast.LENGTH_SHORT).show();
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
            case R.id.btnLoguearse:
                intent = new Intent(getApplicationContext(), login.Login.class);
                launcher.launch(intent);
                break;
            case R.id.btn45javi:
                intent = new Intent(this, Factura.class);
                launcher.launch(intent);
                break;
            case R.id.btnAnadirParticipante:
                intent = new Intent(this, participantes.ParticipantesLleno.class);
                launcher.launch(intent);
                finish();
                break;
            case R.id.btnVolver:
                intent = new Intent(this, NuevoPlato.class);
                launcher.launch(intent);
                finish();
                break;
        }
    }
}
