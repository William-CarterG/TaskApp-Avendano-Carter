package cl.uandes.taskapp.ui.UpdateProject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import cl.uandes.taskapp.R
import cl.uandes.taskapp.databinding.FragmentUpdateProjectBinding

class UpdateProjectFragment : Fragment() {
    private lateinit var binding: FragmentUpdateProjectBinding
    private lateinit var updateProjectViewModel: UpdateProjectViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        updateProjectViewModel = ViewModelProvider(this)[UpdateProjectViewModel::class.java]
        binding = FragmentUpdateProjectBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        returnToProjects()
    }

    private fun returnToProjects() {
        val goBack = binding.returnToProjectsButton
        goBack.setOnClickListener{
            findNavController().navigate(R.id.action_updateProjectFragment_to_homeProjectsFragment)
        }
    }
}