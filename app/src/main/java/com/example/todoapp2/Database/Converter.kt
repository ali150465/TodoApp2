package com.example.todoapp2.Database

import androidx.room.TypeConverter
import java.util.Date

class Converter {
    @TypeConverter
    fun todata(miliSecaound: Long): Date {
        return Date(miliSecaound)
    }
    @TypeConverter
    fun FromDate (date :Date):Long{
        return date.time
    }

}