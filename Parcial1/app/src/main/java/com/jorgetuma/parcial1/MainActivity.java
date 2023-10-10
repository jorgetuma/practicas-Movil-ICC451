package com.jorgetuma.parcial1;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import api.APIClient;
import api.APIInterface;
import com.jorgetuma.parcial1.databinding.ActivityMainBinding;
import dto.DTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private DTO lista;

    private ViewModel model;

    private ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        APIInterface api = APIClient.getClient().create(APIInterface.class);

        api.findAll().enqueue(new Callback<DTO>() {
            @Override
            public void onResponse(Call<DTO> call, Response<DTO> response) {
                lista = response.body();
                Log.w("ENTRO", "BIEN");

               listAdapter = new ListAdapter(new ListAdapter.ProductoDiff(),MainActivity.this, lista);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);

                binding.RVLista.setLayoutManager(linearLayoutManager);
                binding.RVLista.setAdapter(listAdapter);

                model = new ViewModelProvider(MainActivity.this).get(ViewModel.class);

                model.getAllData().observe(MainActivity.this, list -> {
                    //update
                });
            }

            @Override
            public void onFailure(Call<DTO> call, Throwable t) {
                Log.w("PELIGRO", "MAL");
            }
        });
}
}