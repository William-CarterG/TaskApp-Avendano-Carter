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
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import cl.uandes.taskapp.data.model.Project
import cl.uandes.taskapp.data.datasources.InMemoryDataSource



class HomeProjectsFragment : Fragment(),  ProjectItemAdapter.ActionListener {
    private lateinit var binding: FragmentHomeProjectsBinding
    private lateinit var projectItemAdapter: ProjectItemAdapter
    private var allProjects = InMemoryDataSource.projects

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        projectItemAdapter = ProjectItemAdapter(allProjects, this)
        binding = FragmentHomeProjectsBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homeProjectsListView = binding.recyclerViewHomeProjects
        homeProjectsListView.layoutManager = LinearLayoutManager(context)
        homeProjectsListView.adapter = projectItemAdapter

        filterProjectsByDate()
        createNewProject()
        toTasksHome()
        goToUserProfile()
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //TODO: Implement a SaveInstanceState to save projects extracted from a DB (eventually).
        //Should make the app more efficient not having to request the data constantly
        //...
    }

    
    private fun createNewProject(){
        val createNewProjectButton = binding.AddNewProjectButton

        createNewProjectButton.setOnClickListener {
            val action = HomeProjectsFragmentDirections.actionHomeProjectsFragmentToCreateProjectFragment()
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

    override fun goToProjectDetails(project: Project) {
        //Here you write all of the args to do the navigation properly.
        val bundle = bundleOf("projectTitle" to project.title,
            "projectDescription" to project.description, "projectAdmin" to project.admin,
            "projectParticipants" to project.participant, "projectCreationDate" to project.creationDate,
            "projectDeadline" to project.deadline, "projectPercentage" to project.percentageCompletion,
            "projectStatus" to project.status)
        findNavController().navigate(R.id.action_homeProjectsFragment_to_projectProfileFragment, bundle)
    }

    private fun goToUserProfile() {
        val userProfileButton = binding.profileButton
        userProfileButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeProjectsFragment_to_userProfileFragment)
        }
    }
}