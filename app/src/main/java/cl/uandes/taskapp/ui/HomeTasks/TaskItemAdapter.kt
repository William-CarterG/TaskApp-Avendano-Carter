package cl.uandes.taskapp.ui.HomeTasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.uandes.taskapp.R
import cl.uandes.taskapp.data.model.Task

class TaskItemAdapter (
    private val tasks: MutableList<Task>,
    private val actionListener: ActionListener
) : RecyclerView.Adapter<TaskItemAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val taskItem = itemView.findViewById<ViewGroup>(R.id.taskItem)
        val taskTitle = itemView.findViewById<TextView>(R.id.taskTitleTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val taskItemView: View = inflater.inflate(R.layout.home_task_item, parent, false)

        return ViewHolder(taskItemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task: Task = tasks[position]

        val detailsButton = holder.taskItem

        val title = holder.taskTitle

        title.text = task.title


        detailsButton.setOnClickListener {
            actionListener.goToTaskDetails(task)
        }
    }
    override fun getItemCount(): Int {
        return tasks.size
    }

    interface ActionListener {
        fun goToTaskDetails(task: Task)
    }
}
