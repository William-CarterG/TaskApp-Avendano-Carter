package cl.uandes.taskapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.util.Patterns
import android.widget.TextView
import androidx.fragment.app.findFragment
import androidx.navigation.fragment.findNavController
import cl.uandes.taskapp.databinding.FragmentTaskProfileBinding
import cl.uandes.taskapp.R

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

        //safeargs
        val taskTitle = arguments?.getString("taskTitle")
        val title = view.findViewById<TextView>(R.id.taskTitleTextView)
        title.text = taskTitle

        val taskDescription = arguments?.getString("taskDescription")
        val description = view.findViewById<TextView>(R.id.taskDescriptionTextView2)
        description.text = taskDescription

        val taskTaskCreator = arguments?.getString("taskCreator")
        val taskCreator = view.findViewById<TextView>(R.id.taskCreatorTextView2)
        taskCreator.text = taskTaskCreator

        val taskComment = arguments?.getString("taskComment")
        val comment = view.findViewById<TextView>(R.id.taskCommentExampleTextView)
        comment.text = taskComment

        val taskDeadline = arguments?.getString("taskDeadline")
        val deadline = view.findViewById<TextView>(R.id.creationDateExampleTextView)
        deadline.text = taskDeadline

        val taskStatus = arguments?.getString("taskStatus")
        val status = view.findViewById<TextView>(R.id.taskStatusTextView2)
        status.text = taskStatus

        returnToHomeTasks()
        addMembers()
    }

    private fun returnToHomeTasks(){

        val leaveTaskProfileButton = binding.leaveTaskProfileButton

        leaveTaskProfileButton.setOnClickListener {
            val action = TaskProfileFragmentDirections.actionTaskProfileFragmentToHomeTasksFragment()
            findNavController().navigate(action)
        }


    }

    private fun addMembers(){
        val addParticipantsButton = binding.addParticipantsButton
        addParticipantsButton.setOnClickListener {
            val action = TaskProfileFragmentDirections.actionTaskProfileFragmentToTaskAddMemberFragment()
            findNavController().navigate(action)

        }
    }
}