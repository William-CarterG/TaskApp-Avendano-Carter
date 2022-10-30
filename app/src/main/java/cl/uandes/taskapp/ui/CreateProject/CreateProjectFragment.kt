package cl.uandes.taskapp.ui.CreateProject

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.setFragmentResult
import cl.uandes.taskapp.databinding.FragmentCreateProjectBinding
import androidx.navigation.fragment.findNavController


class CreateProjectFragment : Fragment() {
    private lateinit var binding: FragmentCreateProjectBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCreateProjectBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        returnToProjects()
        createNewProject()
    }

    private fun returnToProjects(){
        val returnToProjectsButton = binding.returnToProjectsButton

        returnToProjectsButton.setOnClickListener {
            val action =
                cl.uandes.taskapp.ui.CreateProject.CreateProjectFragmentDirections.actionCreateProjectFragmentToHomeProjectsFragment()
            findNavController().navigate(action)
        }
    }

    private fun createNewProject(){
        lateinit var editProjectView: EditText
        val button = binding.buttonSave

        button.setOnClickListener {
            //Logic of creating and saving the new project
            //...
        }
    }
}