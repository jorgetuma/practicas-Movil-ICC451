package com.jorgetuma.listatareasroom;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class TareaAdapterRV extends ListAdapter<Tarea,TareaAdapterRV.ViewHolder> {

    private  ArrayList<Tarea>  tareas;

    private TareaRepository mRepo;

    public TareaAdapterRV(@NonNull DiffUtil.ItemCallback<Tarea> diffCallback, ArrayList<Tarea> t, TareaRepository mRepository) {
        super(diffCallback);
        tareas = t;
        mRepo = mRepository;
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
                final String[] opciones = {"Completar", "Eliminar", "Cancelar"};

 // Crea un AlertDialog.Builder
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.nombre.getContext());
                builder.setTitle("Selecciona una opción");

  // Opciones en el diálogo
                builder.setItems(opciones, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String opcionSeleccionada = opciones[which];

                        // Realiza la acción correspondiente a la opción seleccionada
                        switch (which) {
                            case 0:
                                // Opción 1 deselection
                                long id = getItemId(position);
                                Tarea t = tareas.get(position);
                                t.setCompletada(true);
                                tareas.set(position,t);
                                mRepo.update(t);
                                notifyItemChanged(position);
                                break;
                            case 1:
                                // Opción 2 seleccionada
                                mRepo.remove(tareas.get(position));
                                tareas.remove(position);
                                notifyItemRemoved(position);
                                break;
                            case 2:
                                // Opción 3 seleccionada
                                dialog.dismiss();
                                break;
                        }
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

    public static class TareaDiff extends DiffUtil.ItemCallback<Tarea> {

        @Override
        public boolean areItemsTheSame(@NonNull Tarea oldItem, @NonNull Tarea newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Tarea oldItem, @NonNull Tarea newItem) {
            return oldItem.getNombre().equals(newItem.getNombre());
        }
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
