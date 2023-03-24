package login;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marfolnew.Principal;
import com.example.marfolnew.R;

public class Login extends AppCompatActivity implements View.OnClickListener {
    public static int VOLVER = 10;
    public static int ENTRAR = 20;

    ImageView btnVolver;
    Button btnLogin;
    ActivityResultLauncher launcher;
    TextView btnCrearCuenta;
    TextView btnContrasenaOlvidada;
    EditText etCorreo;
    Intent intent;
    UsuarioNuevo datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ///FALTA QUE A LA HORA DE CREAR UN USUARIO NUEVO SE QUEDE CON EL CORREO Y LO POJNGA
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        getSupportActionBar().hide();
        btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(this);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
        btnCrearCuenta = findViewById(R.id.btnCrearCuenta);
        btnCrearCuenta.setOnClickListener(this);
        etCorreo = findViewById(R.id.etCorreo);
        btnContrasenaOlvidada = findViewById(R.id.btnContrasenaOlvidada);
        btnContrasenaOlvidada.setOnClickListener(this);
        // Bundle extras= getIntent().getExtras();
        launcher();

    }

    public void launcher() {
        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    if (result.getResultCode() == VOLVER) {
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
                });
    }

    @Override
    public void onClick(View v) {
        actividad(v.getId());
    }

    private void actividad(int opciones) {
        switch (opciones) {
            case R.id.btnVolver:
                intent = new Intent(this, com.example.marfolnew.Principal.class);
                setResult(VOLVER, intent);
                finish();
                break;
            case R.id.btnLogin:
                intent = new Intent(this, com.example.marfolnew.Principal.class);
                setResult(ENTRAR, intent);
                finish();
                break;
            case R.id.btnCrearCuenta:
                intent = new Intent(this, login.CrearCuenta.class);
                //setResult(CREAR_CUENTA,intent);
                launcher.launch(intent);
                break;
            case R.id.btnContrasenaOlvidada:
                intent = new Intent(this, login.ContrasenaOlvidada.class);
                //setResult(CREAR_CUENTA,intent);
                launcher.launch(intent);
                break;
        }
    }
}