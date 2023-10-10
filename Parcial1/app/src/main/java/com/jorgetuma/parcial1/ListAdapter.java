package com.jorgetuma.parcial1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import dto.DTO;
import entity.Producto;

import java.util.List;

public class ListAdapter extends androidx.recyclerview.widget.ListAdapter<Producto,ListAdapter.ViewHolder> {
    private Context context;
    private DTO lista;

    public ListAdapter(@NonNull DiffUtil.ItemCallback<Producto> diffCallback,Context context, DTO lista) {
        super(diffCallback);
        this.context = context;
        this.lista = lista;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
         TextView nombre;
         TextView descripcion;

        public ViewHolder(View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.txt_nombre);
            descripcion = itemView.findViewById(R.id.txt_descripcion);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       Producto item = lista.getData().get(position);
        holder.nombre.setText(item.getNombre());
        holder.descripcion.setText(item.getDescripcion());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int productId = item.getId();
                Intent intent = new Intent(context, DetalleProducto.class);
                intent.putExtra("productId", productId);

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return lista.getData().size();
    }

    public static class ProductoDiff extends DiffUtil.ItemCallback<Producto> {

        @Override
        public boolean areItemsTheSame(@NonNull Producto oldItem, @NonNull Producto newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Producto oldItem, @NonNull Producto newItem) {
            return oldItem.getNombre().equals(newItem.getNombre());
        }
    }
}
