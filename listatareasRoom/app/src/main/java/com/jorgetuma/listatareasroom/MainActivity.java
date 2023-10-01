package com.jorgetuma.listatareasroom;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.jorgetuma.listatareasroom.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    private ArrayList<Tarea> tareas;

    private TareaAdapterRV adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        tareas = new ArrayList<Tarea>();
        binding.RVLista.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapter = new TareaAdapterRV(tareas);
        binding.RVLista.setAdapter(adapter);
    }
}