package com.example.primerapp;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.primerapp.databinding.ActivityDisplayMessageBinding;
import com.example.primerapp.databinding.ActivityMainBinding;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

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
        boolean es_si = intent.getBooleanExtra("si",false);
        binding.txtView1.setText("Hola!, mi nombre es: " + Nombre +".");
        binding.txtView2.setText("Soy " + genero + ",y naci en fecha" + "\n" + nacimiento);
    }
}