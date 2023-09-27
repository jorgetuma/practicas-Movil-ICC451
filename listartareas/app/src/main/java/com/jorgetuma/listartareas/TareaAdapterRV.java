package com.jorgetuma.listartareas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class TareaAdapterRV extends RecyclerView.Adapter<TareaAdapterRV.ViewHolder> {

    private final ArrayList<Tarea>  tareas;

    public TareaAdapterRV(ArrayList<Tarea> tareas) {
        this.tareas = tareas;
    }

    @NonNull
    @NotNull
    @Override
    public TareaAdapterRV.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarea_rvlist,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TareaAdapterRV.ViewHolder holder, int position) {
        holder.asignarDatos(tareas.get(position));
    }

    @Override
    public int getItemCount() {
        return tareas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre;
        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.txt_tarea);
        }

        public void asignarDatos(Tarea tarea) {
            nombre.setText(tarea.getNombre());
        }
    }
}
