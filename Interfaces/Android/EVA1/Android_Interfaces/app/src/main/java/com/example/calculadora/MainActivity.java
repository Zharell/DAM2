package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView Numero,NumeroOld;
    Button n1, n2, n3, n4, n5, n6, n7, n8, n9, n0, nPunto, oMulti, oSuma, oResta, oDivi, oIgual, oCE;
    String aux="",n="0",operacion="";
    boolean limpiar=false;
    int OPERACION_VALOR=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Numero=findViewById(R.id.Numero);
        NumeroOld=findViewById(R.id.NumeroOld);
        //Variables Botón
        n1=findViewById(R.id.En1);
        n2=findViewById(R.id.En2);
        n3=findViewById(R.id.En3);
        n4=findViewById(R.id.En4);
        n5=findViewById(R.id.En5);
        n6=findViewById(R.id.En6);
        n7=findViewById(R.id.En7);
        n8=findViewById(R.id.En8);
        n9=findViewById(R.id.En9);
        n0=findViewById(R.id.En0);
        nPunto=findViewById(R.id.EnPunto);
        oMulti=findViewById(R.id.EoMulti);
        oDivi=findViewById(R.id.EoDivide);
        oSuma=findViewById(R.id.EoSuma);
        oResta=findViewById(R.id.EoResta);
        oIgual=findViewById(R.id.EoIgual);
        oCE=findViewById(R.id.EoCE);

        //Llamada al método
        n0.setOnClickListener(this);
        n1.setOnClickListener(this);
        n2.setOnClickListener(this);
        n3.setOnClickListener(this);
        n4.setOnClickListener(this);
        n5.setOnClickListener(this);
        n6.setOnClickListener(this);
        n7.setOnClickListener(this);
        n8.setOnClickListener(this);
        n9.setOnClickListener(this);
        nPunto.setOnClickListener(this);
        oMulti.setOnClickListener(this);
        oDivi.setOnClickListener(this);
        oSuma.setOnClickListener(this);
        oResta.setOnClickListener(this);
        oIgual.setOnClickListener(this);
        oCE.setOnClickListener(this);

        //Creamos Objeto Calculadora



    }

        //Creamos Objeto Calculadora
        Calculadora myCalc = new Calculadora(n,aux);

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.En0:
                aux+=0;
                limpiar=false;
                mostrar();
                break;
            case R.id.En1:
                aux+=1;
                limpiar=false;
                mostrar();
                break;
            case R.id.En2:
                aux+=2;
                limpiar=false;
                mostrar();
                break;
            case R.id.En3:
                aux+=3;
                limpiar=false;
                mostrar();
                break;
            case R.id.En4:
                aux+=4;
                limpiar=false;
                mostrar();
                break;
            case R.id.En5:
                aux+=5;
                limpiar=false;
                mostrar();
                break;
            case R.id.En6:
                aux+=6;
                limpiar=false;
                mostrar();
                break;
            case R.id.En7:
                aux+=7;
                limpiar=false;
                mostrar();
                break;
            case R.id.En8:
                aux+=8;
                limpiar=false;
                mostrar();
                break;
            case R.id.En9:
                aux+=9;
                limpiar=false;
                mostrar();
                break;
            case R.id.EnPunto:
                aux+=".";
                limpiar=false;
                mostrar();
                break;
            case R.id.EoDivide:
                operacion="/";
                divide();
                break;
            case R.id.EoMulti:
                operacion="*";
                multi();
                break;
            case R.id.EoResta:
                operacion="-";
                resta();
                break;
            case R.id.EoSuma:
                operacion="+";
                suma();
                break;
            case R.id.EoCE:
                ce();
                break;
            case R.id.EoIgual:
                igual();
                break;
        }

    }

    public void igual () {
        double resultado =0;
        switch (OPERACION_VALOR) {
            case 1:
                resultado = Double.parseDouble(n) + Double.parseDouble(aux);
                Numero.setText(String.valueOf(resultado));
                NumeroOld.setText("0");
                aux=String.valueOf(resultado);
                break;
            case 2:
                resultado = Double.parseDouble(n) - Double.parseDouble(aux);
                Numero.setText(String.valueOf(resultado));
                NumeroOld.setText("0");
                aux=String.valueOf(resultado);
                break;
            case 3:
                resultado = Double.parseDouble(n) * Double.parseDouble(aux);
                Numero.setText(String.valueOf(resultado));
                NumeroOld.setText("0");
                aux=String.valueOf(resultado);
                break;
            case 4:
                resultado = Double.parseDouble(n) / Double.parseDouble(aux);
                if (Double.isInfinite(resultado)) {
                    Numero.setText("No se puede dividir por 0");
                    NumeroOld.setText("0");
                    aux=String.valueOf(resultado);
                } else {
                    Numero.setText(String.valueOf(resultado));
                    NumeroOld.setText("0");
                    aux=String.valueOf(resultado);
                }
                break;
        }
    }


    public void suma() {
        n = aux;
        NumeroOld.setText(aux);
        Numero.setText("+");
        aux="0";
        OPERACION_VALOR=1;
    }

    public void divide() {
        n = aux;
        NumeroOld.setText(aux);
        Numero.setText("/");
        aux="0";
        OPERACION_VALOR=4;
    }

    public void resta() {
        n = aux;
        NumeroOld.setText(aux);
        Numero.setText("-");
        aux="0";
        OPERACION_VALOR=2;
    }

    public void multi() {
        n = aux;
        NumeroOld.setText(aux);
        Numero.setText("*");
        aux="0";
        OPERACION_VALOR=3;
    }

    public void ce () {
        aux="0";
        n="0";
        Numero.setText(aux);
        NumeroOld.setText(n);
    }


    public void mostrar() {
        if (!limpiar) {
            Numero.setText(aux);
        }
        limpiar=true;
    };

}