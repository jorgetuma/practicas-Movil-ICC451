package com.jorgetuma.listatareasroom;

import android.app.Application;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TareaRepository {

    private TareaDao  mTareaDao;

    private LiveData<List<Tarea>> mAllTareas;

    public TareaRepository(Application app) {
        TareaDb db = TareaDb.getDatabase(app);
        mTareaDao = db.tareaDao();
        mAllTareas = mTareaDao.getAllTareas();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<Tarea>> getAllWords() {
        return mAllTareas;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(Tarea tarea) {
        TareaDb.databaseWriteExecutor.execute(() -> {
            mTareaDao.insert(tarea);
        });
    }
}
