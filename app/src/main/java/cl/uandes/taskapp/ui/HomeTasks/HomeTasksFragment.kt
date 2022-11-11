package cl.uandes.taskapp.ui.HomeTasks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import cl.uandes.taskapp.databinding.FragmentHomeTasksBinding
import cl.uandes.taskapp.R
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import cl.uandes.taskapp.data.db.entity.Task
import cl.uandes.taskapp.data.datasources.InMemoryDataSource
import cl.uandes.taskapp.ui.HomeProjects.HomeProjectsViewModel
import cl.uandes.taskapp.ui.HomeProjects.ProjectItemAdapter

class HomeTasksFragment : Fragment(), TaskItemAdapter.ActionListener {
    private lateinit var binding: FragmentHomeTasksBinding
    private lateinit var taskItemAdapter: TaskItemAdapter
    private var allTasks = InMemoryDataSource.tasks

    //View model implementation
    private lateinit var viewModel: HomeTasksViewModel

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

        viewModel = ViewModelProvider(this)[HomeTasksViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadTasks()
        taskItemAdapter = TaskItemAdapter(mutableListOf(), this)


        binding.recyclerViewHomeTasks.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = taskItemAdapter
        }

        observeTaskList()

        toCreateTask()
        deleteTask()
    }

    private fun observeTaskList(){
        viewModel.taskListLiveData.observe(viewLifecycleOwner) { tasks ->
            tasks?.let {
                binding.recyclerViewHomeTasks.visibility = View.VISIBLE
                taskItemAdapter.updateTasks(tasks)
            }
        }
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
        "taskCreator" to task.taskCreator, "taskComment" to task.comment, "taskDeadline" to task.deadline, "taskCreationDate" to task.creationDate
            , "taskStatus" to task.status)
        findNavController().navigate(R.id.action_homeTasksFragment_to_taskProfileFragment, bundle)
    }

    private fun deleteTask() {
        val deleteButton = binding.deleteTask

        deleteButton.setOnClickListener {
            val deleteTask: EditText = binding.taskToDelete
            val task = deleteTask.text.toString()
            viewModel.delete(task)
            Toast.makeText(requireContext(),"Task deleted successfully.", Toast.LENGTH_LONG).show()
        }
    }
}