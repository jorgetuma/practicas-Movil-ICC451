package com.jorgetuma.parcial1;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import api.APIClient;
import api.APIInterface;
import com.jorgetuma.parcial1.databinding.ActivityDetalleProductoBinding;
import com.jorgetuma.parcial1.databinding.ActivityMainBinding;
import com.squareup.picasso.Picasso;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DetalleProducto extends AppCompatActivity {

    ActivityDetalleProductoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);

        binding = ActivityDetalleProductoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        APIInterface api = APIClient.getClient().create(APIInterface.class);

      /*  api.find(userId).enqueue(new Callback<UserSingle>() {
            @Override
            public void onResponse(Call<UserSingle> call, Response<UserSingle> response) {
                Log.w("onResponse", response.body().data.toString());
                user = response.body().getData();
                nombre.setText(user.getFirstName());
                apellido.setText(user.getLastName());
                correo.setText(user.getEmail());
                Picasso.get()
                        .load(user.getAvatar()) // URL de la imagen
                        .into(imagen);
            }

            @Override
            public void onFailure(Call<UserSingle> call, Throwable t) {
                Log.w("onFailure", t.getLocalizedMessage());
                call.cancel();
            }
        });*/
    }
}