package com.example.primerapp;

import android.content.Intent;
import android.telephony.TelephonyCallback;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.primerapp.databinding.ActivityMainBinding;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    //Se ejecuta al presionar boton "send"
   public void sendMesage(View view) {
       Intent intent = new Intent(MainActivity.this, DisplayMessageActivity.class);
       String message = binding.txtNombre.getText().toString();
       intent.putExtra("nombre", message);
       startActivity(intent);
    }
}