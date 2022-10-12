package cl.uandes.taskapp.ui.ProjectProfile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import cl.uandes.taskapp.databinding.FragmentProjectProfileBinding
import cl.uandes.taskapp.R

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

        //Added for safe args navigation
        val projectTitle = arguments?.getString("projectTitle")
        val title = view.findViewById<TextView>(R.id.projectTitleTextView)
        title.text = projectTitle

        val projectDescription = arguments?.getString("projectDescription")
        val description = view.findViewById<TextView>(R.id.projectDescriptionTextView)
        description.text = projectDescription

        val projectAdmin = arguments?.getString("projectAdmin")
        val admin = view.findViewById<TextView>(R.id.projectAdminTextView)
        admin.text = projectAdmin

        val projectParticipants = arguments?.getString("projectParticipants")
        val participants = view.findViewById<TextView>(R.id.projectParticipantsTextView)
        participants.text = projectParticipants

        val projectCreationDate = arguments?.getString("projectCreationDate")
        val creationDate = view.findViewById<TextView>(R.id.projectCreationDateTextView)
        creationDate.text = projectCreationDate

        val projectDeadline = arguments?.getString("projectDeadline")
        val deadline = view.findViewById<TextView>(R.id.projectDeadlineTextView)
        deadline.text = projectDeadline

        val projectPercentage = arguments?.getString("projectPercentage")
        val percentage = view.findViewById<TextView>(R.id.projectPercentageTextView) //consider changing the variable name to a more descriptive one
        percentage.text = projectPercentage

        val projectStatus = arguments?.getString("projectStatus")
        val status = view.findViewById<TextView>(R.id.projectStatusTextView)
        status.text = projectStatus


        //Navigation functions
        returnToHomeProjects()
        addMembers()
        viewPendingRequests()
        addTask()
    }

    private fun returnToHomeProjects(){
        val leaveProjectProfileButton = binding.leaveProjectProfileButton

        leaveProjectProfileButton.setOnClickListener {
            val action =
                cl.uandes.taskapp.ui.ProjectProfile.ProjectProfileFragmentDirections.actionProjectProfileFragmentToHomeProjectsFragment()
            findNavController().navigate(action)
        }
    }

    private fun addMembers(){
        val addParticipantsButton = binding.addParticipantsButton
        addParticipantsButton.setOnClickListener {
            val action =
                cl.uandes.taskapp.ui.ProjectProfile.ProjectProfileFragmentDirections.actionProjectProfileFragmentToAddMemberFragment()
            findNavController().navigate(action)

        }
    }

    private fun viewPendingRequests(){
        val viewPendingRequestsButton = binding.acceptParticipantsButton
        viewPendingRequestsButton.setOnClickListener {
            val action =
                cl.uandes.taskapp.ui.ProjectProfile.ProjectProfileFragmentDirections.actionProjectProfileFragmentToViewProjectRequestFragment()
            findNavController().navigate(action)
        }
    }

    private fun addTask(){
        val addTaskButton = binding.addTaskButton
        addTaskButton.setOnClickListener {
            val action =
                cl.uandes.taskapp.ui.ProjectProfile.ProjectProfileFragmentDirections.actionProjectProfileFragmentToCreateTaskFragment()
            findNavController().navigate(action)
        }
    }
}
