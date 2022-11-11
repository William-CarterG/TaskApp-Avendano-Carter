package cl.uandes.taskapp.ui.HomeProjects

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import cl.uandes.taskapp.databinding.FragmentHomeProjectsBinding
import cl.uandes.taskapp.R
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import cl.uandes.taskapp.data.db.entity.Project
import cl.uandes.taskapp.data.datasources.InMemoryDataSource

import androidx.lifecycle.ViewModelProvider


class HomeProjectsFragment : Fragment(), ProjectItemAdapter.ActionListener {
    private lateinit var binding: FragmentHomeProjectsBinding
    private lateinit var projectItemAdapter: ProjectItemAdapter
    private var allProjects = InMemoryDataSource.projects

    //View model implementation
    private lateinit var viewModel: HomeProjectsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        projectItemAdapter = ProjectItemAdapter(allProjects, this)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        //Previous implementation
        binding = FragmentHomeProjectsBinding.inflate(inflater, container, false)

        /*
        //View Model implementation
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home_projects, container, false)
        */

        viewModel = ViewModelProvider(this)[HomeProjectsViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadProjects()
        projectItemAdapter = ProjectItemAdapter(mutableListOf(), this)

        /*
        val homeProjectsListView = binding.recyclerViewHomeProjects
        homeProjectsListView.layoutManager = LinearLayoutManager(context)
        homeProjectsListView.adapter = projectItemAdapter
        */

        binding.recyclerViewHomeProjects.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = projectItemAdapter
        }

        //TODO Implement subscription to live data
        observeProjectList()

        filterProjectsByDate()
        createNewProject()
        deleteProject()
    }

    private  fun observeProjectList() {
        viewModel.projectListLiveData.observe(viewLifecycleOwner) { projects ->
            projects?.let {
                binding.recyclerViewHomeProjects.visibility = View.VISIBLE
                projectItemAdapter.updateProjects(projects)
            }
        }
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
            val action =
                cl.uandes.taskapp.ui.HomeProjects.HomeProjectsFragmentDirections.actionHomeProjectsFragmentToCreateProjectFragment()
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

    override fun goToProjectDetails(project: Project) {
        //Here you write all of the args to do the navigation properly.
        val bundle = bundleOf("projectTitle" to project.title,
            "projectDescription" to project.description, "projectAdmin" to project.admin,
            "projectParticdipants" to project.participant, "projectCreationDate" to project.creationDate,
            "projectDeadline" to project.deadline, "projectPercentage" to project.percentageCompletion,
            "projectStatus" to project.status)
        findNavController().navigate(R.id.action_homeProjectsFragment_to_projectProfileFragment, bundle)
    }

    private fun deleteProject() {
        val deleteButton = binding.deleteProject

        deleteButton.setOnClickListener {
            val deleteProject: EditText = binding.projectToDelete
            val project = deleteProject.text.toString()
            viewModel.delete(project)
            Toast.makeText(requireContext(),"Project deleted successfully.",Toast.LENGTH_LONG).show()
        }
    }
}