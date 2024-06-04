package com.example.todoapp2.Database

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@androidx.room.Dao
interface Dao {
    @Insert()
    fun InsertTask(Todo:Todo)
    @Update
    fun Update(Todo: Todo)
    @Delete
    fun Delete(Todo: Todo)
    @Query("SELECT * FROM Todo")
    fun GETALL_TASK():List<Todo>
}