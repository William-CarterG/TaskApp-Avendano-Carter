package cl.uandes.taskapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.util.Patterns
import androidx.navigation.fragment.findNavController
import cl.uandes.taskapp.databinding.FragmentHomeProjectsBinding

class HomeProjectsFragment : Fragment() {
    private lateinit var binding: FragmentHomeProjectsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeProjectsBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        filterProjectsByDate()
        createNewProject()
        viewProjectProfileExample()
        toTasksHome()
    }

    private fun createNewProject(){
        val createNewProjectButton = binding.AddNewProjectButton

        createNewProjectButton.setOnClickListener {
            val action = HomeProjectsFragmentDirections.actionHomeProjectsFragmentToCreateProjectFragment()
            findNavController().navigate(action)
        }
    }

    private fun viewProjectProfileExample(){
        val projectProfileExampleButton = binding.projectProfileExampleButton
        projectProfileExampleButton.setOnClickListener {
            val action = HomeProjectsFragmentDirections.actionHomeProjectsFragmentToProjectProfileFragment()
            findNavController().navigate(action)
        }
    }

    private fun filterProjectsByDate(){
        val filterProjectsByDateButton = binding.filetrByDateButton
        filterProjectsByDateButton.setOnClickListener {
            //TODO: Logic of filtering the projects by date
            //...
        }
    }

    private fun toTasksHome(){
        val homeTasksButton = binding.homeTasksButton
        homeTasksButton.setOnClickListener {
            val action = HomeProjectsFragmentDirections.actionHomeProjectsFragmentToHomeTasksFragment()
            findNavController().navigate(action)
        }
    }
}