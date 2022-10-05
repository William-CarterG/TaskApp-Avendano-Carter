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

    override fun onDestroyView() {
        super.onDestroyView()
        //TODO: Save changes into DB
        //...
    }


    private fun returnToProject(){
        val returnToProjectsButton = binding.returnToProjectsButton

        returnToProjectsButton.setOnClickListener {
            //TODO Moving forward, consider passing the project to this fragment
            // so we can easily create a new task into the project.
            val action = CreateTaskFragmentDirections.actionCreateTaskFragmentToHomeProjectsFragment()
            findNavController().navigate(action)
        }
    }

    private fun addMembersToTask(){
        val createNewTaskButton = binding.createNewTaskButton

        createNewTaskButton.setOnClickListener {
            val action = CreateTaskFragmentDirections.actionCreateTaskFragmentToTaskAddMemberFragment()
            findNavController().navigate(action)

        }
    }
}