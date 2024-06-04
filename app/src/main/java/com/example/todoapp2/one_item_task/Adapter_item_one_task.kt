package com.example.todoapp2.one_item_task

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.todoapp2.Database.Todo
import com.example.todoapp2.R

class Adapter_item_one_task(
    var Todolist: List<Todo>?, val Donecolor: Int, val praimarycolors: Int
) : Adapter<Adapter_item_one_task.ViewHolderr>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderr {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_one_task, parent, false)
        return ViewHolderr(view)
    }
    var onitemclicks: onitemclicks? = null
    var onitemclicksCheckbox:onitemclicks_checkbox?=null
    var onclickDeleteItem:onclick_Delete_item?=null
    override fun onBindViewHolder(holder: ViewHolderr, position: Int) {
        holder.titleTask.text = Todolist?.get(position)?.title
        if (Todolist?.get(position)?.isdone == true) {
            holder.line.setBackgroundColor(Donecolor)
            holder.checkBox.visibility = View.INVISIBLE
            holder.Done.visibility = View.VISIBLE
        } else {
            holder.line.setBackgroundColor(praimarycolors)
            holder.checkBox.visibility = View.VISIBLE
            holder.Done.visibility = View.INVISIBLE
        }
        holder.checkBox.setOnClickListener {
          onitemclicksCheckbox?.onclick(position)
        }
        holder.itemView.setOnClickListener {
            onitemclicks?.onclick(
                position, Todolist?.get(position)?.title, Todolist?.get(position)?.Descrabtion
            )
        }
        holder.bt_Delete.setOnClickListener {
            onclickDeleteItem?.onlcik_Delete(position, Todolist?.get(position) ?: return@setOnClickListener)
        }
    }

    override fun getItemCount(): Int {
        return Todolist?.size ?: 0
    }
    fun updata(todolist: List<Todo>?) {
        this.Todolist = todolist
        notifyDataSetChanged()
    }
    class ViewHolderr(itemview: View) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(itemview) {
        val titleTask: TextView = itemview.findViewById(R.id.title_item_one)
        val checkBox: ImageView = itemview.findViewById(R.id.checkbox_one_item)
        val line: View = itemview.findViewById(R.id.linee)
        val Done: TextView = itemview.findViewById(R.id.done_text_one_item)
        val bt_Delete:ConstraintLayout=itemview.findViewById(R.id.itemshow_ic_delete)
    }
}
interface onclick_Delete_item{
    fun onlcik_Delete(position: Int?,Todo:Todo)
}