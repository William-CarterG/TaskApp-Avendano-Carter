package cl.uandes.taskapp.ui.view

import android.os.Bundle
import android.util.Patterns
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

        val emailEntered = binding.editTextTextEmailAddress.text.toString()
        var registerButton = binding.registerButton


        val cond = Patterns.EMAIL_ADDRESS.matcher(emailEntered).matches()

        registerButton.setOnClickListener {
            //TODO: validate data and navigate.

            if (Patterns.EMAIL_ADDRESS.matcher(emailEntered).matches()) {
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }
        }
        toLogin()
    }

    private fun toLogin() {
        var loginButton = binding.loginButton
        loginButton.setOnClickListener{
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }
}