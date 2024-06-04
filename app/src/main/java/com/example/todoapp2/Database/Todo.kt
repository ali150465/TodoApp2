package com.example.todoapp2.Database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Todo(
    @PrimaryKey (autoGenerate = true)
    var ID: Int? = null,
    var title: String? = null,
    var Descrabtion: String? = null,
    var isdone: Boolean = false,
//    var Data: Date? = null

)
