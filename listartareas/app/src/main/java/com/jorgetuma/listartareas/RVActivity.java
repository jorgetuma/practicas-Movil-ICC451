package com.jorgetuma.listartareas;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.jorgetuma.listartareas.databinding.ActivityMainBinding;
import com.jorgetuma.listartareas.databinding.ActivityRvactivityBinding;

public class RVActivity extends AppCompatActivity {

     ActivityRvactivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvactivity);
        binding = ActivityRvactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void listView(View view) {
        Intent intent = new Intent(RVActivity.this,MainActivity.class);
        startActivity(intent);
    }
}