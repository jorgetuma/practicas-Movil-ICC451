package com.jorgetuma.listatareasroom;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Tarea.class}, version = 1)
public abstract class TareaDb  extends RoomDatabase {
    public abstract TareaDao tareaDao();

    private static TareaDb instancia = null;

    private static final int NUMBER_OF_THREADS = 4;
    
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static TareaDb getDatabase(final Context context) {
        if (instancia == null) {
            synchronized (TareaDb.class) {
                if (instancia == null) {
                    instancia = Room.databaseBuilder(context.getApplicationContext(),
                                    TareaDb.class, "tarea_database")
                            .build();
                }
            }
        }
        return instancia;
    }
}
