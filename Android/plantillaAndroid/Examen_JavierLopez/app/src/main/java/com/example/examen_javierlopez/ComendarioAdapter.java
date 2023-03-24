package com.example.examen_javierlopez;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import MapAPI.ActoresResponse;

public class ComendarioAdapter extends RecyclerView.Adapter<ComendarioAdapter.ComentarioAdapterResultHolder>{
    private List<ActoresResponse> results = new ArrayList<>();

    @NonNull
    @Override
    public ComentarioAdapterResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_comentario, parent, false);
        return new ComentarioAdapterResultHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ComentarioAdapterResultHolder holder, int position) {

        holder.eComentarioActor.setText(results.get(position).getNombreActor());

    }

    public List<ActoresResponse> getResults() {
        return results;
    }

    public void setResults(List<ActoresResponse> results) {
        this.results = results;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class ComentarioAdapterResultHolder extends RecyclerView.ViewHolder {
        TextView eComentarioActor;
        public ComentarioAdapterResultHolder(@NonNull View itemView) {
            super(itemView);
            eComentarioActor = itemView.findViewById(R.id.ENombreActor);
        }
    }


}
