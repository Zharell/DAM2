package participantes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.marfolnew.Factura;
import com.example.marfolnew.Principal;
import com.example.marfolnew.R;

import login.Login;

public class ParticipantesLleno extends AppCompatActivity implements View.OnClickListener {
    public static final int LLENO = 80;
    ImageView btnPagar,btnLogin,btnAnadirComida,javiel,btnVolver;
    ActivityResultLauncher launcher;
    //public static int VOLVER =10;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.participantes_lleno);
        getSupportActionBar().hide();

        //Se asigna valor a la variable
        btnLogin = findViewById(R.id.btnLoguearse3);
        btnPagar = findViewById(R.id.btnPagarFactura2);
        btnAnadirComida= findViewById(R.id.btnAnadirComida);
        btnVolver=findViewById(R.id.btnVolver3);
        javiel=findViewById(R.id.javiel);
        //Se implementa el escuchador en el propio doc
        btnLogin.setOnClickListener(this);
        btnPagar.setOnClickListener(this);
        btnAnadirComida.setOnClickListener(this);
        javiel.setOnClickListener(this);
        btnVolver.setOnClickListener(this);


        launcher();
    }


    public void launcher() {
        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    if (result.getResultCode() == Login.VOLVER) {
                        Toast.makeText(this, "Vuelta a participantes", Toast.LENGTH_SHORT).show();
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
                intent = new Intent(this, Factura.class);
                launcher.launch(intent);
                break;
            case R.id.btnAnadirComida:
                intent = new Intent(this, NuevoParticipante.class);
                launcher.launch(intent);
                finish();
                break;
            case R.id.javiel:
                intent = new Intent(this, platos.JavierMPlatos.class);
                launcher.launch(intent);
                break;
            case R.id.btnVolver3:
                intent = new Intent(this, com.example.marfolnew.Principal.class);
                launcher.launch(intent);
                finish();
                break;
        }
    }
}