package cl.uandes.taskapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import cl.uandes.taskapp.databinding.FragmentTaskAddMemberBinding

class TaskAddMemberFragment  : Fragment() {
    private lateinit var binding: FragmentTaskAddMemberBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentTaskAddMemberBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addMemberToTask()
        returnToTaskProfile()
    }

    private fun addMemberToTask(){
        val addMemberButton = binding.taskAddExampleButton
        addMemberButton.setOnClickListener {
            //TODO: Logic of adding a new member to project
            //...
        }
    }

    private fun returnToTaskProfile(){
        val leaveAddMembersButton = binding.leaveTaskAddMembersButton
        leaveAddMembersButton.setOnClickListener {
            //TODO: Navigation back to task profile
            //...
        }
    }
}