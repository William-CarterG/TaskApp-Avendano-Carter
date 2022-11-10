package cl.uandes.taskapp.ui.CreateTasks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import cl.uandes.taskapp.databinding.FragmentCreateTaskBinding
import androidx.navigation.fragment.findNavController
import cl.uandes.taskapp.data.db.AppDatabase
import cl.uandes.taskapp.data.db.entity.Project
import cl.uandes.taskapp.data.db.entity.Task
import cl.uandes.taskapp.ui.CreateProject.CreateProjectViewModel

class CreateTaskFragment : Fragment() {
    private lateinit var binding: FragmentCreateTaskBinding
    private lateinit var createTaskViewModel: CreateTaskViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        createTaskViewModel = ViewModelProvider(this)[CreateTaskViewModel::class.java]
        binding = FragmentCreateTaskBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        returnToProject()
        addMembersToTask()
        createTask()
    }

    private fun returnToProject(){
        val returnToProjectsButton = binding.returnToProjectsButton

        returnToProjectsButton.setOnClickListener {
            //TODO Moving forward, consider passing the project to this fragment
            // so we can easily create a new task into the project.
            val action =
                cl.uandes.taskapp.ui.CreateTasks.CreateTaskFragmentDirections.actionCreateTaskFragmentToHomeProjectsFragment()
            findNavController().navigate(action)
        }
    }

    private fun addMembersToTask(){
        val createNewTaskButton = binding.createNewTaskButton

        createNewTaskButton.setOnClickListener {
            val action =
                cl.uandes.taskapp.ui.CreateTasks.CreateTaskFragmentDirections.actionCreateTaskFragmentToTaskAddMemberFragment()
            findNavController().navigate(action)

        }
    }

    private fun createTask() {
        val createButton = binding.buttonSave


        createButton.setOnClickListener {
            //Logic of creating and saving the new task
            //...
            val editTaskView: EditText = binding.editTask
            val editDescriptionView: EditText = binding.editDescription
            val editTaskCreatorView: EditText = binding.editTaskCreator
            val editCommentView: EditText = binding.editComments
            val editDeadlineView: EditText = binding.editDeadline
            val editCreationDate: EditText = binding.editCreationDate

            val title = editTaskView.text.toString()
            val description = editDescriptionView.text.toString()
            val taskCreator = editTaskCreatorView.text.toString()
            val comment = editCommentView.text.toString()
            val deadline = editDeadlineView.text.toString()
            val creationDate = editCreationDate.text.toString()

            val newTask = Task(title = title, description = description,taskCreator = taskCreator,comment = comment,deadline=deadline,creationDate=creationDate,status="In Progress")
            createTaskViewModel.insert(newTask)
            Toast.makeText(requireContext(),"Task successfully created!",Toast.LENGTH_LONG).show()
        }
    }
}