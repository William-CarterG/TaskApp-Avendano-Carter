package cl.uandes.taskapp.ui.CreateProject

import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.ViewModelProvider
import cl.uandes.taskapp.databinding.FragmentCreateProjectBinding
import androidx.navigation.fragment.findNavController
import cl.uandes.taskapp.data.datasources.InMemoryDataSource
import cl.uandes.taskapp.data.db.AppDatabase
import cl.uandes.taskapp.data.db.dao.ProjectDao
import cl.uandes.taskapp.data.db.entity.Project
import cl.uandes.taskapp.data.db.entity.User
import cl.uandes.taskapp.data.repository.ProjectRepository

class CreateProjectFragment : Fragment() {
    private lateinit var binding: FragmentCreateProjectBinding
    private lateinit var createProjectViewModel: CreateProjectViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        createProjectViewModel = ViewModelProvider(this)[CreateProjectViewModel::class.java]
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
        val button = binding.buttonSave


        button.setOnClickListener {
            val editProjectView: EditText = binding.editProject
            val editDescriptionView: EditText = binding.editDescriptionTask
            val editAdminView: EditText = binding.editAdmin
            val editParticipantView: EditText = binding.editParticipant
            val editCreationDateView: EditText = binding.editCreationDate
            val editDeadlineView: EditText = binding.editDeadline

            val title = editProjectView.text.toString()
            val description = editDescriptionView.text.toString()
            val admin = editAdminView.text.toString()
            val participant = editParticipantView.text.toString()
            val creationDate = editCreationDateView.text.toString()
            val deadline = editDeadlineView.text.toString()

            //Logic of creating and saving the new project
            //...
            //val db = AppDatabase.invoke(requireContext())
            val newProject = Project( title=title,description=description,admin=admin,participant=participant,creationDate=creationDate,deadline=deadline, percentageCompletion = "0%",status="In Progress")
            //db.getProjectDao().getAllProjects()
            createProjectViewModel.insert(newProject)
            InMemoryDataSource.projects.add(Project( title=title,description=description,admin=admin,participant=participant,creationDate=creationDate,deadline=deadline, percentageCompletion = "0%",status="In Progress"))
            Toast.makeText(requireContext(),"Project successfully created!", Toast.LENGTH_LONG).show()
        }
    }
}