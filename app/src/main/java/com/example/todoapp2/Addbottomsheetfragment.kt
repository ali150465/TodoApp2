package com.example.todoapp2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.todoapp2.Database.MyDatabase_manager
import com.example.todoapp2.Database.Todo
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class Addbottomsheetfragment : BottomSheetDialogFragment() {
    lateinit var EditeText_title: EditText
    lateinit var EditeText_descrabtion: EditText
    lateinit var Button_add_new_task: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.addbottomsheetfragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initeview(view)
    }

    fun initeview(view: View) {
        EditeText_title = view.findViewById(R.id.addtitleTask)
        EditeText_descrabtion = view.findViewById(R.id.adddeatailsTask)
        Button_add_new_task = view.findViewById(R.id.bt_button_new_Task)
        Button_add_new_task.setOnClickListener {
            if (ifitemsvaled()){
                MyDatabase_manager
                    .getInasted(context = requireContext())
                    .getTodaoDao()
                    .InsertTask(Todo(
                        title = EditeText_title.text.toString(),
                        Descrabtion = EditeText_descrabtion.text.toString()
                    ))
            }
            dismiss()
        }

    }

    private fun ifitemsvaled(): Boolean {
        var isvailed: Boolean = true
        if (EditeText_title.text.isEmpty()) {
            EditeText_title.error = "please Enter Title for Task"
            isvailed = false
        } else if (EditeText_descrabtion.text.isEmpty()) {
            EditeText_descrabtion.error = "Please Enter the Description"
            isvailed = false
        }
        return isvailed

    }
}