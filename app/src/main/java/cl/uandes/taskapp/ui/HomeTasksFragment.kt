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


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        taskItemAdapter = TaskItemAdapter(allTasks,this)
        binding = FragmentHomeTasksBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homeTasksListView = binding.recyclerViewHomeTasks
        homeTasksListView.layoutManager = LinearLayoutManager(context)
        homeTasksListView.adapter = taskItemAdapter

        toHomeProjects()
        toCreateTask()
        toUserProfile()
    }

    private fun toHomeProjects(){
        val homeProjectsButton = binding.homeProjectsButton
        homeProjectsButton.setOnClickListener {
            val action = HomeTasksFragmentDirections.actionHomeTasksFragmentToHomeProjectsFragment()
            findNavController().navigate(action)
        }
    }

    private fun toCreateTask() {
        val createTaskButton = binding.AddNewTaskButton
        createTaskButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeTasksFragment_to_createTaskFragment)
        }
    }

    private fun toUserProfile() {
        val profileButton = binding.profileButton
        profileButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeTasksFragment_to_userProfileFragment)
        }
    }

    override fun goToTaskDetails(task: Task) {
        val bundle = bundleOf("taskTitle" to task.title)
        findNavController().navigate(R.id.action_homeTasksFragment_to_taskProfileFragment, bundle)
    }
}