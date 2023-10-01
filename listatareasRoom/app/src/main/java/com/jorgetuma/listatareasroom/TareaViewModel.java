package com.jorgetuma.listatareasroom;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TareaViewModel extends AndroidViewModel {

    private TareaRepository mRepository;

    private final LiveData<List<Tarea>> mAllTareas;


    public TareaViewModel(Application app) {
        super(app);
        this.mRepository = new TareaRepository(app);
        this.mAllTareas = mRepository.getmAllTareas();
    }

    public LiveData<List<Tarea>> getmAllTareas() { return mAllTareas; }

    public void insert(Tarea tarea) { mRepository.insert(tarea); }
}
