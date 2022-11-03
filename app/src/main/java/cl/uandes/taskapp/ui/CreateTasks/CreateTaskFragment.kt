package cl.uandes.taskapp.ui.CreateTasks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import cl.uandes.taskapp.databinding.FragmentCreateTaskBinding
import androidx.navigation.fragment.findNavController
import cl.uandes.taskapp.data.db.AppDatabase
import cl.uandes.taskapp.data.db.entity.Project
import cl.uandes.taskapp.data.db.entity.Task

class CreateTaskFragment : Fragment() {
    private lateinit var binding: FragmentCreateTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
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


        createButton.setOnClickListener {
            //Logic of creating and saving the new project
            //...
            val db = AppDatabase.invoke(requireContext())
            val newTask = Task(0, title = title, description = description,taskCreator = taskCreator,comment = comment,deadline=deadline,creationDate=creationDate,"In Progress")
            db.getTaskDao().insertTask(newTask)
        }
    }
}