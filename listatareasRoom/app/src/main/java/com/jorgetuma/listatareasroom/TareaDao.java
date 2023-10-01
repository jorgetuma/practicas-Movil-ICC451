package com.jorgetuma.listatareasroom;

import androidx.room.*;

import java.util.List;

@Dao
public interface TareaDao {
    @Insert
    void insertTarea(Tarea tarea);

    @Update
    void updateTarea(Tarea tarea);

    @Delete
    void deleteTarea(Tarea tarea);

    @Query("SELECT * FROM Tarea")
    List<Tarea> getAllTareas();

    @Query("SELECT * FROM Tarea WHERE id = :taskId")
    Tarea getTareaById(int id);
}
