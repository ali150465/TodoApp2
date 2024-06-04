package com.example.todoapp2.Database

import android.content.Context
import androidx.room.*

@Database(entities = [Todo::class], version = 2)
@TypeConverters(Converter::class)
abstract class MyDatabase_manager : RoomDatabase() {
    abstract fun getTodaoDao(): Dao
    companion object {
        var Insted: MyDatabase_manager? = null
        fun getInasted(context: Context) :MyDatabase_manager{
            if (Insted == null) {
                Insted = Room.databaseBuilder(
                    context.applicationContext,
                    MyDatabase_manager::class.java,
                    "TODoBP"
                )
                    .fallbackToDestructiveMigration().allowMainThreadQueries().build()
            }
            return Insted!!
        }
    }
}