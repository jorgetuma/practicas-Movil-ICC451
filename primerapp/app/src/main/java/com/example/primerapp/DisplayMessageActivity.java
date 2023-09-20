package com.example.primerapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.primerapp.databinding.ActivityDisplayMessageBinding;

public class DisplayMessageActivity extends AppCompatActivity {

    ActivityDisplayMessageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        binding = ActivityDisplayMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        String Nombre = intent.getStringExtra("nombre");
        String genero = intent.getStringExtra("genero");
        String nacimiento = intent.getStringExtra("fecha");
        String lenguajes = intent.getStringExtra("lenguajes");
        boolean es_si = intent.getBooleanExtra("si",false);
        binding.txtView1.setText("Hola!, mi nombre es: " + Nombre +".");
        binding.txtView2.setText("Soy " + genero + ",y naci en fecha" + "\n" + nacimiento + ".");

        if(es_si) {
          String lang = lenguajes.replace(" ",",");
          binding.txtView3.setText("Me gusta programar. Mis lenguajes" + "\n" + "favoritos son: " + lang + ".");
        }

        if (!es_si) {
            binding.txtView3.setText("No me gusta programar.");
        }
    }
}