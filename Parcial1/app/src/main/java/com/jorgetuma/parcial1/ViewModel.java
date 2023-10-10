package com.jorgetuma.parcial1;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import entity.Producto;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ViewModel extends AndroidViewModel {
    private Repository mRepository;
    private LiveData<List<Producto>> lista;

    public ViewModel(@NonNull @NotNull Application application) {
        super(application);
        this.mRepository = new Repository(application);
        this.lista = mRepository.getAllData();
    }

    public LiveData<List<Producto>> getAllData() {
        return lista;
    }
}
