package platos;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marfolnew.R;

import participantes.ParticipantesLleno;
import participantes.ParticipantesVacio;

public class NuevoPlato extends AppCompatActivity implements View.OnClickListener {
    public static final int VOLVERARESUMEN = 100 ;
    ImageView btnVolver,btnAnadirPlato,btnCompartir;
    Intent intent;
    ActivityResultLauncher launcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevo_plato);
        getSupportActionBar().hide();

        //Se asigna valor a la variable
        btnVolver = findViewById(R.id.btnVolver);
        btnAnadirPlato=findViewById(R.id.btnAnadirPlato);
        btnCompartir=findViewById(R.id.btnCompartir);

        //Se implementa el escuchador en el propio doc

        btnVolver.setOnClickListener(this);
        btnAnadirPlato.setOnClickListener(this);
        btnCompartir.setOnClickListener(this);
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
                intent = new Intent(getApplicationContext(), participantes.ParticipantesLleno.class);
                launcher.launch(intent);
                finish();
                break;
            case R.id.btnAnadirPlato:
                intent = new Intent(this, participantes.ParticipantesLleno.class);
                launcher.launch(intent);
                finish();
                break;
            case R.id.btnCompartir:
                intent = new Intent(this, platos.CompartirPlatoLleno.class);
                launcher.launch(intent);
                finish();
                break;
        }
    }
}