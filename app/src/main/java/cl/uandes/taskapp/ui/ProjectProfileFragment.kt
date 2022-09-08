package cl.uandes.taskapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.util.Patterns
import androidx.navigation.fragment.findNavController
import cl.uandes.taskapp.databinding.FragmentProjectProfileBinding
import androidx.navigation.fragment.findNavController

class ProjectProfileFragment : Fragment() {
    private lateinit var binding: FragmentProjectProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentProjectProfileBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun return_to_homeProjects(){
        val leaveProjectProfileButton = binding.leaveProjectProfileButton

        leaveProjectProfileButton.setOnClickListener {
            val action = ProjectProfileFragmentDirections.actionProjectProfileFragmentToHomeProjectsFragment()
            findNavController().navigate(action)
        }
    }
}
