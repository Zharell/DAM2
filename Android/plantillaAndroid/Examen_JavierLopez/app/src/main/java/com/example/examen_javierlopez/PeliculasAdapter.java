package com.example.examen_javierlopez;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import MapAPI.PeliculasResponse;

public class PeliculasAdapter extends RecyclerView.Adapter<PeliculasAdapter.PeliculasAdapterResultHolder>{
    private final int MAX_PALABRAS = 5;
    private List <PeliculasResponse> results = new ArrayList<>();
    private onItemClickListener mListener;
    public void setResults(List<PeliculasResponse> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    public void setmListener(onItemClickListener mListener) {
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public PeliculasAdapterResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_pelicula, parent, false);
        return new PeliculasAdapterResultHolder(itemView);
    }

    public List<PeliculasResponse> getResults() {
        return results;
    }

    @Override
    public void onBindViewHolder(@NonNull PeliculasAdapterResultHolder holder, int position) {

        holder.adapterPelicula.setText(String.valueOf(results.get(position).getEstrellas()));
        holder.nombrePelicula.setText(results.get(position).getNombrePelicula());

        //Para acortar la descripcion
        String descripcion = results.get(position).getDescripcionPelicula();
        List<String> fiveWords = Arrays.asList(descripcion.split("\\s+"));
        int num=0;
        String descripcionCorta ="";
        for (int i =0 ;i<fiveWords.size();i++) {
            if (num<MAX_PALABRAS) {
                descripcionCorta+=fiveWords.get(i)+" ";
            }
            num++;
        }
        //Añadimos la descripcion recortada
        holder.descripcionPelicula.setText(descripcionCorta);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    int position = holder.getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        mListener.onItemClick(position);
                    }
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class PeliculasAdapterResultHolder extends RecyclerView.ViewHolder {

        TextView nombrePelicula, descripcionPelicula, adapterPelicula;

        public PeliculasAdapterResultHolder(@NonNull View itemView) {
            super(itemView);

            nombrePelicula = itemView.findViewById(R.id.ENombreActor);
            descripcionPelicula = itemView.findViewById(R.id.EDescripcion);
            adapterPelicula = itemView.findViewById(R.id.EEstrellas);
        }
    }

    public interface onItemClickListener{
        void onItemClick(int position);
    }

}
