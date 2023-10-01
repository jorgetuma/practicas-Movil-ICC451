package com.jorgetuma.listatareasroom;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.jorgetuma.listatareasroom.Tarea;
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
    public void onBindViewHolder(@NonNull @NotNull TareaAdapterRV.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.asignarDatos(tareas.get(position));

        holder.nombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.nombre.getContext());
                builder.setTitle("Eliminar tarea");
                builder.setMessage("¿Estás seguro de que deseas eliminar esta tarea?");

                // Botón "Sí"
                builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tareas.remove(position);
                        notifyItemRemoved(position);
                    }
                });

                // Botón "No"
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // No hacer nada.
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
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
