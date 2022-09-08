package cl.uandes.taskapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.util.Patterns
import androidx.navigation.fragment.findNavController
import cl.uandes.taskapp.databinding.FragmentTaskProfileBinding

class TaskProfileFragment : Fragment() {
    private lateinit var binding: FragmentTaskProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentTaskProfileBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        returnToHomeTasks()
        addMembers()
    }

    private fun returnToHomeTasks(){
        /*
        val leaveProjectProfileButton = binding.leaveTaskProfileButton

        leaveProjectProfileButton.setOnClickListener {
            val action = ProjectProfileFragmentDirections.actionProjectProfileFragmentToHomeProjectsFragment()
            findNavController().navigate(action)
        }
        */

    }

    private fun addMembers(){
        /*
        val addParticipantsButton = binding.addParticipantsButton
        addParticipantsButton.setOnClickListener {
            val action = ProjectProfileFragmentDirections.actionProjectProfileFragmentToAddMemberFragment()
            findNavController().navigate(action)

        }

         */
    }
}