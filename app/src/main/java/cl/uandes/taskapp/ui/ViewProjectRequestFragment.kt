package cl.uandes.taskapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import cl.uandes.taskapp.databinding.FragmentViewProjectRequestBinding

class ViewProjectRequestFragment : Fragment() {
    private lateinit var binding: FragmentViewProjectRequestBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentViewProjectRequestBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addMemberToProject()
        returnToHomeProjects()
    }

    private fun addMemberToProject(){
        val addMemberButton = binding.addExampleButton
        addMemberButton.setOnClickListener {
            //TODO: Logic of adding a new member to project
            //...
        }
    }

    private fun returnToHomeProjects(){
        val leaveAddMembersButton = binding.leaveAddMembersButton
        leaveAddMembersButton.setOnClickListener {
            val action = AddMemberFragmentDirections.actionAddMemberFragmentToProjectProfileFragment()
            findNavController().navigate(action)
        }
    }
}