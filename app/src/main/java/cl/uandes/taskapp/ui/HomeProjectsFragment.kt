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
import cl.uandes.taskapp.R
import androidx.recyclerview.widget.LinearLayoutManager


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

        val homeProjectsListView = binding.recyclerViewHomeProjects
        
        filterProjectsByDate()
        createNewProject()
        viewProjectProfileExample()
        toTasksHome()
        visitProfile()
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
        val filterProjectsByDateButton = binding.filterByDateButton
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

    private fun visitProfile () {
        val profileButton = binding.profileButton
        profileButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeProjectsFragment_to_userProfileFragment)
        }
    }
}