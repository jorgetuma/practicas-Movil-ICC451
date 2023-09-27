package com.jorgetuma.listartareas;

import android.content.Intent;
import android.view.View;
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

    public void listView(View view) {
        Intent intent = new Intent(RVActivity.this,MainActivity.class);
        startActivity(intent);
    }
}