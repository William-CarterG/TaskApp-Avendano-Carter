package cl.uandes.taskapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.util.Patterns
import androidx.navigation.fragment.findNavController
import cl.uandes.taskapp.databinding.FragmentHomeTasksBinding

class HomeTasksFragment : Fragment() {
    private lateinit var binding: FragmentHomeTasksBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeTasksBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun toHomeProjects(){
        val homeProjectsButton = binding.homeProjectsButton
        homeProjectsButton.setOnClickListener {
            val action = HomeTasksFragmentDirections.actionHomeTasksFragmentToHomeProjectsFragment()
            findNavController().navigate(action)
        }
    }
    //TODO: Navigate to HomeProjects and to TaskExample
}