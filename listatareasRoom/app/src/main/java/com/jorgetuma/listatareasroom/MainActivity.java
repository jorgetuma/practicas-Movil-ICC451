package com.jorgetuma.listatareasroom;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.jorgetuma.listatareasroom.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    private ArrayList<Tarea> tareas;

    private TareaAdapterRV adapter;

    private TareaViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        tareas = new ArrayList<Tarea>();
        binding.RVLista.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapter = new TareaAdapterRV( new TareaAdapterRV.TareaDiff());
        binding.RVLista.setAdapter(adapter);
       model = new ViewModelProvider(this).get(TareaViewModel.class);

        model.getmAllTareas().observe(this, tareas -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(tareas);
        });
    }
}