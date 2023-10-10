package com.jorgetuma.parcial1;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import api.APIClient;
import api.APIInterface;
import dto.DTO;
import entity.Producto;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class Repository {

    private final  APIInterface api;
    private MutableLiveData<List<Producto>> lista;

    public Repository(Application app) {
        api = APIClient.getClient().create(APIInterface.class);

        api.findAll().enqueue(new Callback<DTO>() {
            @Override
            public void onResponse(Call<DTO> call, Response<DTO> response) {
                Log.w("ENTRO", "BIEN");
                lista.setValue(response.body().getData());

            }

            @Override
            public void onFailure(Call<DTO> call, Throwable t) {
                Log.w("ERROR", t.getMessage());
            }
        });
    }

    public MutableLiveData<List<Producto>> getAllData() {
        return lista;
    }
}
