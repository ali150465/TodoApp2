package com.example.todoapp2.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.todoapp2.Addbottomsheetfragment
import com.example.todoapp2.R
import com.example.todoapp2.UI.Fragment.Settings_Fragment
import com.example.todoapp2.UI.Fragment.Todo_List_fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
lateinit var Botttomnavgation :BottomNavigationView
lateinit var Button_Add_task:FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        InitViews()


    }

     fun InitViews() {
        Botttomnavgation=findViewById(R.id.Botton_navigation)
         Botttomnavgation.setOnItemSelectedListener {
             if (it.itemId==R.id.icon_Settings){
                 pushfragment(Settings_Fragment())
             }else if (it.itemId==R.id.icon_List){
                 pushfragment(Todo_List_fragment())
             }
             return@setOnItemSelectedListener true
         }
         Botttomnavgation.selectedItemId=R.id.icon_List
         Button_Add_task=findViewById(R.id.add_Todo)
         Button_Add_task.setOnClickListener {
             val Addbottomsheetfragment = Addbottomsheetfragment()
             Addbottomsheetfragment.show(supportFragmentManager,null)
         }
     }

     fun pushfragment(fragment: Fragment) {
         supportFragmentManager
             .beginTransaction()
             .replace(R.id.fragment_container,fragment)
             .commit()

    }
}