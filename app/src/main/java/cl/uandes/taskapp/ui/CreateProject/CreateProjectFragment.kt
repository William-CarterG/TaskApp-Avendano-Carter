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
import cl.uandes.taskapp.data.db.AppDatabase
import cl.uandes.taskapp.data.db.entity.Project


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
        val button = binding.buttonSave

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

        button.setOnClickListener {
            //Logic of creating and saving the new project
            //...
            val db = AppDatabase.invoke(requireContext())
            val newProject = Project(0, title=title,description=description,admin=admin,participant=participant,creationDate=creationDate,deadline=deadline,"0%","In Progress")
            db.getProjectDao().insertProject(newProject)
        }
    }
}