package com.example.examen_javierlopez;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import PeliculasActoresAPI.PeliculasViewModel;

public class MainActivity extends AppCompatActivity implements PeliculasAdapter.onItemClickListener {
    private RecyclerView lista;
    private PeliculasAdapter adapter;
    private PeliculasViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.SRecyclerPeliculas);

        //Adapter
        lista.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PeliculasAdapter();
        lista.setAdapter(adapter);
        adapter.setmListener(this);


        //ViewModel
        vm = new ViewModelProvider(this).get(PeliculasViewModel.class);
        vm.init();

        vm.getData().observe(this, (data) -> {

            adapter.setResults(data);

        });

        vm.listarPeliculas();

    }


    @Override
    public void onItemClick(int position) {

        String urlActor = adapter.getResults().get(position).getUrlPelicula();
        envio(urlActor);



    }

    public void envio(String url) {
        Intent intent = new Intent(this, MostrarDetalle.class);
        intent.putExtra("url",url);
        startActivity(intent);
    }

}