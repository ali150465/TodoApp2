package com.example.todoapp2.UI.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp2.Constand
import com.example.todoapp2.one_item_task.Adapter_item_one_task
import com.example.todoapp2.Database.MyDatabase_manager
import com.example.todoapp2.Database.Todo
import com.example.todoapp2.R
import com.example.todoapp2.UI.EditTask
import com.example.todoapp2.one_item_task.onclick_Delete_item
import com.example.todoapp2.one_item_task.onitemclicks
import com.example.todoapp2.one_item_task.onitemclicks_checkbox

//import com.example.todoapp2.UI.DayContainer.DayViewContainer
//import com.kizitonwose.calendar.core.CalendarDay
//import com.kizitonwose.calendar.core.DayPosition
//import com.kizitonwose.calendar.core.firstDayOfWeekFromLocale
//import com.kizitonwose.calendar.view.CalendarView
//import com.kizitonwose.calendar.view.MonthDayBinder
//import java.lang.ref.Cleaner
//import java.time.YearMonth

class Todo_List_fragment : Fragment() {
    //    lateinit var calendarView: CalendarView
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: Adapter_item_one_task
    lateinit var todos: List<Todo>
    lateinit var checkBox: ImageView
    lateinit var Done: TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.todolist_fragment, container, false)
    }

    override fun onResume() {
        super.onResume()
        todos = MyDatabase_manager.getInasted(requireContext()).getTodaoDao().GETALL_TASK()
        adapter.updata(todos)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerview_item_one_task)
        adapter = Adapter_item_one_task(
            null, ResourcesCompat.getColor(resources, R.color.Green, null),
            ResourcesCompat.getColor(resources, R.color.Blue, null)
        )
        recyclerView.adapter = adapter
        adapter.onitemclicksCheckbox = object : onitemclicks_checkbox {
            override fun onclick(position: Int?) {
                position?.let {
                    todos.get(it).isdone = true
                }
                checkBox = view.findViewById(R.id.checkbox_one_item)
                Done = view.findViewById(R.id.done_text_one_item)
                checkBox.visibility = View.INVISIBLE
                Done.visibility = View.VISIBLE
              //  todos=MyDatabase_manager.getInasted(requireContext()).getTodaoDao().Update()
                adapter.updata(todos)
            }
        }
        adapter.onitemclicks = object : onitemclicks {
            override fun onclick(position: Int?, title: String?, Descrabtion: String?) {
                val intent = Intent(requireContext(), EditTask::class.java)
                intent.putExtra(Constand.CONSTANT_KEY_TITLE, position?.let { todos.get(it).title })
                intent.putExtra(
                    Constand.CONSTANT_KEY_Descrabtion,
                    position?.let { todos.get(it).Descrabtion })
                startActivity(intent)
            }
        }
        adapter.onclickDeleteItem = object : onclick_Delete_item {
            override fun onlcik_Delete(position: Int?, Todo: Todo) {
                MyDatabase_manager
                    .getInasted(requireContext())
                    .getTodaoDao()
                    .Delete(Todo)

            }
        }
        // Calendar
    }

    fun Calendar() {
        //        calendarView = view.findViewById(R.id.calendarView)
//        calendarView.dayBinder = object : MonthDayBinder<DayViewContainer> {
//            // Called only when a new container is needed.
//            override fun create(view: View) = DayViewContainer(view)
//
//            // Called every time we need to reuse a container.
//            override fun bind(container: DayViewContainer, data: CalendarDay) {
//                container.textView.text = data.date.dayOfMonth.toString()
//            }
//        }
//        val currentMonth = YearMonth.now()
//        val startMonth = currentMonth.minusMonths(100)  // Adjust as needed
//        val endMonth = currentMonth.plusMonths(100)  // Adjust as needed
//        val firstDayOfWeek = firstDayOfWeekFromLocale()// Available from the library
//        calendarView.setup(startMonth, endMonth, firstDayOfWeek)
//        calendarView.scrollToMonth(currentMonth)
//    }
    }


}