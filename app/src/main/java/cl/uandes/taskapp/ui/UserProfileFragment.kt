package cl.uandes.taskapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import cl.uandes.taskapp.R
import cl.uandes.taskapp.databinding.FragmentUserProfileBinding

class UserProfileFragment : Fragment() {
    private lateinit var binding: FragmentUserProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentUserProfileBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logoutAction()
        goToTasks()
    }

    private fun logoutAction() {
        val logoutButton = binding.logoutButton
        logoutButton.setOnClickListener{
            findNavController().navigate(R.id.action_userProfileFragment_to_loginFragment)
        }
    }

    private fun goToProjects() {
        val projects = binding.myProjects
        projects.setOnClickListener {
            findNavController().navigate(R.id.action_userProfileFragment_to_homeProjectsFragment)
        }
    }

    private fun goToTasks() {
        val tasks = binding.myTasks
        tasks.setOnClickListener {
            findNavController().navigate(R.id.action_userProfileFragment_to_homeTasksFragment)
        }
    }
}