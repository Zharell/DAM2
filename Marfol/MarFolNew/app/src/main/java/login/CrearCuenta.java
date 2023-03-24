package login;


import static login.Login.VOLVER;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.marfolnew.R;


public class CrearCuenta extends AppCompatActivity implements View.OnClickListener {

    public static int CREAR_CUENTA = 30;
    public static String REGISTROCREADO = "CREADO";

    ImageView btnVolver;
    Button btnRegistro;
    EditText etCorreo;
    Intent intent;
    UsuarioNuevo usuario = new UsuarioNuevo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_cuenta);
        getSupportActionBar().hide();
        btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(this);
        btnRegistro = findViewById(R.id.btnRegistro);
        btnRegistro.setOnClickListener(this);
        etCorreo = findViewById(R.id.etCorreo);
        usuario.setCorreo(etCorreo.getText().toString());

    }


    @Override
    public void onClick(View v) {
        actividad(v.getId());
    }

    private void actividad(int opciones) {
        switch (opciones) {
            case R.id.btnVolver:
                intent = new Intent(this, login.Login.class);
                setResult(VOLVER, intent);
                finish();
                break;
            case R.id.btnRegistro:
                intent = new Intent(this, login.Login.class);
                //intent.putExtra(REGISTROCREADO,(Serializable)usuario.getCorreo());
                setResult(CREAR_CUENTA, intent);
                finish();

                break;
        }
    }

}