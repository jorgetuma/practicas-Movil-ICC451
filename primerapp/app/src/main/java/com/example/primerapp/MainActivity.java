package com.example.primerapp;

import android.content.Intent;

import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.primerapp.databinding.ActivityMainBinding;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    //Se ejecuta al presionar boton "enviar"
   public void sendMesage(View view) {
        if(!binding.txtNombre.getText().toString().isEmpty() && !binding.txtApellido.getText().toString().isEmpty()) {
            Intent intent = new Intent(MainActivity.this, DisplayMessageActivity.class);
            String nombre = binding.txtNombre.getText().toString() + " " + binding.txtApellido.getText().toString();
            intent.putExtra("nombre", nombre);
            String genero  = binding.spnGenero.getSelectedItem().toString();
            intent.putExtra("genero",genero);
            String fecha = String.valueOf(binding.datePicker.getDayOfMonth()) + "/" + String.valueOf(binding.datePicker.getMonth() + 1) + "/" + String.valueOf(binding.datePicker.getYear());
            intent.putExtra("fecha",fecha);
            intent.putExtra("si",false);
            int cant_lang = 0;
            if(binding.rbtnNo.isChecked()) {
                startActivity(intent);
            }

            if (binding.rbtnSi.isChecked()) {
                intent.putExtra("si",true);
                if (binding.cbxJava.isChecked()) {
                    intent.putExtra("java",binding.cbxJava.getText().toString());
                    cant_lang++;
                }
                if (binding.cbxJs.isChecked()) {
                    intent.putExtra("js",binding.cbxJs.getText().toString());
                    cant_lang++;
                }
                if (binding.cbxClang.isChecked()) {
                    intent.putExtra("clang",binding.cbxClang.getText().toString());
                    cant_lang++;
                }
                if (binding.cbxPython.isChecked()) {
                    intent.putExtra("python",binding.cbxPython.getText().toString());
                    cant_lang++;
                }
                if (binding.cbxGolang.isChecked()) {
                    intent.putExtra("golang",binding.cbxGolang.getText().toString());
                    cant_lang++;
                }
                if (binding.cbxCsharp.isChecked()) {
                    intent.putExtra("csharp",binding.cbxCsharp.getText().toString());
                    cant_lang++;
                }
                if (cant_lang > 0) {
                    startActivity(intent);
                }else {
                    AlertDialog.Builder alerta2 = new AlertDialog.Builder(MainActivity.this);
                    alerta2.setTitle("Error")
                            .setMessage("Al menos un lenguaje debe ser seleccionado")
                            .setPositiveButton("Aceptar", null)
                            .show();
                }
            }
        }else {
            AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
           alerta.setTitle("Error")
                    .setMessage("Alguno de los campos obligatorios(nombre,apellido y genero) esta vacio")
                    .setPositiveButton("Aceptar", null)
                    .show();
        }
    }

    //Se ejecuta al presionar boton "limpiar"
    public void clear(View view) {
        binding.txtNombre.setText("");
        binding.txtApellido.setText("");
        binding.spnGenero.setSelection(0);
        binding.datePicker.init(Calendar.getInstance().get(Calendar.YEAR),Calendar.getInstance().get(Calendar.MONTH),Calendar.getInstance().get(Calendar.DAY_OF_MONTH),null);
        binding.rbtnSi.setChecked(true);
        binding.cbxJava.setChecked(false);
        binding.cbxJs.setChecked(false);
        binding.cbxClang.setChecked(false);
        binding.cbxGolang.setChecked(false);
        binding.cbxPython.setChecked(false);
        binding.cbxCsharp.setChecked(false);
    }

    /*Se ejecuta al presionar boton "no". De esta forma se valida que no se pueda seleccionar un lenguaje si se selecciona "no"*/
    public void deshabilitar(View view) {
        binding.cbxJava.setChecked(false);
        binding.cbxJs.setChecked(false);
        binding.cbxClang.setChecked(false);
        binding.cbxGolang.setChecked(false);
        binding.cbxPython.setChecked(false);
        binding.cbxCsharp.setChecked(false);

        binding.cbxJava.setEnabled(false);
        binding.cbxJs.setEnabled(false);
        binding.cbxClang.setEnabled(false);
        binding.cbxGolang.setEnabled(false);
        binding.cbxPython.setEnabled(false);
        binding.cbxCsharp.setEnabled(false);
    }

    //Se ejecuta al presionar boton "si"
    public void habilitar(View view) {
        binding.cbxJava.setEnabled(true);
        binding.cbxJs.setEnabled(true);
        binding.cbxClang.setEnabled(true);
        binding.cbxGolang.setEnabled(true);
        binding.cbxPython.setEnabled(true);
        binding.cbxCsharp.setEnabled(true);
    }
}