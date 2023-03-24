package com.example.examen_javierlopez;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import PeliculasActoresAPI.PeliculasViewModel;

public class MostrarDetalle extends AppCompatActivity {

    TextView nombrePel,estrellasPel,descripcionPel;
    private ComendarioAdapter adapter;
    private PeliculasViewModel vm;
    RecyclerView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_detalle);

        nombrePel = findViewById(R.id.SNombrePel);
        estrellasPel = findViewById(R.id.EEstrellasPel);
        descripcionPel = findViewById(R.id.EDescripcionPel);
        lista = findViewById(R.id.RecyclerPel);


        String url = getIntent().getStringExtra("url");

        lista.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ComendarioAdapter();
        lista.setAdapter(adapter);

        vm = new ViewModelProvider(this).get(PeliculasViewModel.class);
        vm.init();

        vm.getDataActor().observe(this,(data) -> {

            nombrePel.setText(data.getNombrePel());
            estrellasPel.setText(""+data.getEstrellasPel());
            descripcionPel.setText(data.getDescripcionPel());
            adapter.setResults(data.getActoresResponses());


        });

        vm.mostrarComentario(url);

    }



}