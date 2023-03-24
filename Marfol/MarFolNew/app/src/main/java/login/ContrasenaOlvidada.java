package login;

import static login.Login.VOLVER;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.marfolnew.R;

public class ContrasenaOlvidada extends AppCompatActivity implements View.OnClickListener {
    public static final int CORREOENVIADO = 60;
    Button btnEnviarCorreo;
    EditText etContrasenaOlvidada;
    ImageView btnVolver;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contrasena_olvidada);
        getSupportActionBar().hide();
        btnVolver = findViewById(R.id.btnVolver);
        btnEnviarCorreo = findViewById(R.id.btnEnviarCorreo);
        btnVolver.setOnClickListener(this);
        btnEnviarCorreo.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        actividad(v.getId());
    }

    private void actividad(int opciones) {
        switch (opciones) {
            case R.id.btnVolver:
                intent = new Intent(this, login.CrearCuenta.class);
                setResult(VOLVER, intent);
                finish();
                break;
            case R.id.btnEnviarCorreo:
                intent = new Intent(this, login.CrearCuenta.class);
                setResult(CORREOENVIADO, intent);
                finish();
                break;

        }
    }
}