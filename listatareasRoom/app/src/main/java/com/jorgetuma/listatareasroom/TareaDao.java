package com.jorgetuma.listatareasroom;

import android.database.sqlite.SQLiteDatabase;
import androidx.lifecycle.LiveData;
import androidx.room.*;

import java.util.List;

@Dao
public interface TareaDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Tarea tarea);

    @Update
    void update(Tarea tarea);

    @Delete
    void delete(Tarea tarea);

    @Query("SELECT * FROM Tarea")
    LiveData<List<Tarea>> getAllTareas();

    @Query("SELECT * FROM Tarea WHERE id = :id")
    Tarea getTareaById(int id);

    @Query("DELETE FROM Tarea")
    void deleteAll();
}
