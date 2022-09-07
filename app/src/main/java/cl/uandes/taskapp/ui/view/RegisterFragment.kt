package cl.uandes.taskapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import cl.uandes.taskapp.R
import cl.uandes.taskapp.databinding.FragmentRegisterBinding
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var registerButton = binding.registerButton
        registerButton.setOnClickListener {
            //TODO: validate data and navigate.
            }

        }
    }