package cl.uandes.taskapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import cl.uandes.taskapp.databinding.FragmentHomeTasksBinding
import cl.uandes.taskapp.R
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import cl.uandes.taskapp.data.model.Task
import cl.uandes.taskapp.data.datasources.InMemoryDataSource

class HomeTasksFragment : Fragment(), TaskItemAdapter.ActionListener {
    private lateinit var binding: FragmentHomeTasksBinding
    private lateinit var taskItemAdapter: TaskItemAdapter
    private var allTasks = InMemoryDataSource.tasks

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        taskItemAdapter = TaskItemAdapter(allTasks,this)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeTasksBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homeTasksListView = binding.recyclerViewHomeTasks
        homeTasksListView.layoutManager = LinearLayoutManager(context)
        homeTasksListView.adapter = taskItemAdapter

        toCreateTask()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //TODO: Implement a SaveInstanceState to save projects extracted from a DB (eventually).
        //Should make the app more efficient not having to request the data constantly
        //...
    }


    private fun toCreateTask() {
        val createTaskButton = binding.AddNewTaskButton
        createTaskButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeTasksFragment_to_createTaskFragment)
        }
    }

    override fun goToTaskDetails(task: Task) {
        val bundle = bundleOf("taskTitle" to task.title, "taskDescription" to task.description,
        "taskCreator" to task.taskCreator, "taskComment" to task.comment, "taskDeadline" to task.deadline, "taskStatus" to task.status)
        findNavController().navigate(R.id.action_homeTasksFragment_to_taskProfileFragment, bundle)
    }
}