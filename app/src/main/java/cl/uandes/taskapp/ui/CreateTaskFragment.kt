package cl.uandes.taskapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.uandes.taskapp.databinding.FragmentCreateTaskBinding
import androidx.navigation.fragment.findNavController

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

    }

    private fun returnToProject(){
        val returnToProjectsButton = binding.returnToProjectsButton

        returnToProjectsButton.setOnClickListener {
            //TODO: Navigation back to project
        }
    }

    private fun addMembersToTask(){
        val createNewTaskButton = binding.createNewTaskButton

        createNewTaskButton.setOnClickListener {
            //TODO: Navigation to add new members
            //...

        }
    }
}