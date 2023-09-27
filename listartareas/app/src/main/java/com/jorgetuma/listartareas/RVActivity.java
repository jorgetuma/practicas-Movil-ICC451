package com.jorgetuma.listartareas;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.jorgetuma.listartareas.databinding.ActivityMainBinding;
import com.jorgetuma.listartareas.databinding.ActivityRvactivityBinding;

import java.util.ArrayList;

public class RVActivity extends AppCompatActivity {

     ActivityRvactivityBinding binding;

     private ArrayList<Tarea> tareas;

    private TareaAdapterRV adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvactivity);
        binding = ActivityRvactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        tareas = new ArrayList<Tarea>();
        binding.RVLista.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapter = new TareaAdapterRV(tareas);
        binding.RVLista.setAdapter(adapter);
    }

    public void agregarTarea(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.input_tarea, null);

        final EditText etNombre = dialogView.findViewById(R.id.txt_nombre);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView)
                .setTitle("Ingrese nombre de la tarea")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String nombre = etNombre.getText().toString();
                        Tarea t = new Tarea(nombre);
                        tareas.add(t);
                        adapter.notifyDataSetChanged();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //No hacer nada
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void listView(View view) {
        Intent intent = new Intent(RVActivity.this,MainActivity.class);
        startActivity(intent);
    }
}