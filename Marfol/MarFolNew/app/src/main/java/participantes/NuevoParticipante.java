package participantes;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marfolnew.Principal;
import com.example.marfolnew.R;

import login.ContrasenaOlvidada;
import login.CrearCuenta;
import login.Login;

public class NuevoParticipante extends AppCompatActivity implements View.OnClickListener{
    ImageView btnAnadirParticipante,btnVolver;
    Intent intent;
    TextView btnNuevoPlato;
    ActivityResultLauncher launcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevo_participante);
        getSupportActionBar().hide();

        //Se asigna valor a la variable
        btnVolver = findViewById(R.id.btnVolver);
        btnAnadirParticipante=findViewById(R.id.btnAnadirParticipante);
        btnNuevoPlato= findViewById(R.id.btnNuevoPlato);

        //Se implementa el escuchador en el propio doc

        btnVolver.setOnClickListener(this);
        btnNuevoPlato.setOnClickListener(this);
        btnAnadirParticipante.setOnClickListener(this);
        launcher();

    }
    public void launcher() {
        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                   /* if (result.getResultCode() == VOLVER) {
                        Toast.makeText(this, "Vuelta a participantes", Toast.LENGTH_SHORT).show();
                    }
                    if (result.getResultCode() == CrearCuenta.CREAR_CUENTA) {
                        Toast.makeText(this, "Cuenta creada", Toast.LENGTH_SHORT).show();
                        // datos=(UsuarioNuevo) getIntent().getSerializableExtra(CrearCuenta.REGISTROCREADO);
                        // etCorreo.setText("Creado");
                    }
                    if (result.getResultCode() == ContrasenaOlvidada.CORREOENVIADO) {
                        Toast.makeText(this, "Correo enviado", Toast.LENGTH_SHORT).show();
                    }*/
                });
    }

    @Override
    public void onClick(View v) {
        actividad(v.getId());
    }

    private void actividad(int opciones) {
        switch (opciones) {
            case R.id.btnVolver:
                intent = new Intent(getApplicationContext(), ParticipantesVacio.class);
                finish();
                break;
            case R.id.btnAnadirParticipante:
                intent = new Intent(this, ParticipantesLleno.class);
                launcher.launch(intent);
                finish();
                break;
            case R.id.btnNuevoPlato:
                intent = new Intent(this, platos.NuevoPlato.class);
                launcher.launch(intent);
                finish();
                break;
        }
    }
}