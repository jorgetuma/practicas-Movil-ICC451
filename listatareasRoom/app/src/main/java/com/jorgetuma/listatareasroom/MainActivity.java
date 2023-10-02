package com.jorgetuma.listatareasroom;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.jorgetuma.listatareasroom.databinding.ActivityMainBinding;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private ArrayList<Tarea> tareas;

    private TareaAdapterRV adapter;

    private static TareaViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        tareas = new ArrayList<Tarea>();
        binding.RVLista.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        model = new ViewModelProvider(this).get(TareaViewModel.class);
        adapter = new TareaAdapterRV(new TareaAdapterRV.TareaDiff(), tareas, model.mRepository);
        binding.RVLista.setAdapter(adapter);

        model.getmAllTareas().observe(this, tareas -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList((List<Tarea>) tareas);
        });
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
                        model.insert(t);
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
}
