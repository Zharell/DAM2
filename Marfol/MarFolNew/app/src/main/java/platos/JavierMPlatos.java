package platos;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.marfolnew.Principal;
import com.example.marfolnew.R;

import login.ContrasenaOlvidada;
import login.CrearCuenta;
import participantes.NuevoParticipante;

public class JavierMPlatos extends AppCompatActivity implements View.OnClickListener {
    ImageView btnVolver,btnAnadir,btnLoguearse;
    Intent intent;
    ActivityResultLauncher launcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.javier_mplatos);
        getSupportActionBar().hide();
        btnAnadir=findViewById(R.id.btnAnadir);
        btnVolver=findViewById(R.id.btnVolver);
        btnLoguearse=findViewById(R.id.btnLoguearse);
        btnAnadir.setOnClickListener(this);
        btnVolver.setOnClickListener(this);
        btnLoguearse.setOnClickListener(this);
        launcher();
    }
    public void launcher() {
        launcher = registerForActivityResult(

                new ActivityResultContracts.StartActivityForResult(), result -> {/*
                    if (result.getResultCode() == login.Login.VOLVER) {
                        Toast.makeText(this, "Vuelta a login", Toast.LENGTH_SHORT).show();
                    }
                    if (result.getResultCode() == CrearCuenta.CREAR_CUENTA) {
                        Toast.makeText(this, "Cuenta creada", Toast.LENGTH_SHORT).show();
                        // datos=(UsuarioNuevo) getIntent().getSerializableExtra(CrearCuenta.REGISTROCREADO);
                        // etCorreo.setText("Creado");
                    }
                    if (result.getResultCode() == ContrasenaOlvidada.CORREOENVIADO) {
                        Toast.makeText(this, "Correo enviado", Toast.LENGTH_SHORT).show();
                    }
                    */
                    if (result.getResultCode() == NuevoPlato.VOLVERARESUMEN) {
                    }});
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
            case R.id.btnVolver:
                intent = new Intent(this, participantes.ParticipantesLleno.class);
                launcher.launch(intent);
                finish();
                break;
            case R.id.btnAnadir:
                intent = new Intent(this, NuevoPlato.class);
                launcher.launch(intent);
                break;
        }
    }
}