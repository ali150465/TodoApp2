package com.example.todoapp2.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import com.example.todoapp2.R

class EditTask : AppCompatActivity() {
    lateinit var bt_back: ImageView
    lateinit var EditText_title:EditTask
    lateinit var EditText_descrabtion:EditTask
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_task)
        inite()




    }

    fun inite() {
        bt_back = findViewById(R.id.back_edite_activity)
        bt_back.setOnClickListener {
            finish()
        }
    }
}